package org.demo.despesaControle.dao;

import org.demo.despesaControle.entities.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoriaDAO {
    private static final String PERSISTENCE_UNIT_NAME = "despesasPUSQLite"; // Nome da unidade de persistência
    private final EntityManagerFactory emf;

    public CategoriaDAO() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void salvarCategoria(Categoria categoria) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public String atualizarCategoria(Categoria categoria) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(categoria);
            em.getTransaction().commit();
            return "CATEGORIA ALTERADA COM SUCESSO!";

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO ALTERAR CATEGORIA";
        } finally {
            em.close();

        }
    }

    public String excluir(Long id) {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Categoria categoria = em.find(Categoria.class, id);
            if (categoria != null) {
                em.remove(categoria);
                em.getTransaction().commit();
                return "CATEGORIA EXCLUIDA COM SUCESSO!";
            } else {
                em.getTransaction().rollback();
                return "CATEGORIA NÃO ENCONTRADA!";
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO EXCLUIR CATEGORIA!";
        } finally {
            em.close();
        }
    }

}
