package org.demo.despesaControle.dao;

import org.demo.despesaControle.entities.Rendas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RendasDAO {

    private static final String PERSISTENCE_UNIT_NAME = "despesasPUSQLite"; // Nome da unidade de persistência
    private final EntityManagerFactory emf;

    public RendasDAO() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void salvarRendas(Rendas rendas) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rendas);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public String atualizarRendas(Rendas rendas) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(rendas);
            em.getTransaction().commit();
            return "RENDA ALTERADA COM SUCESSO!";

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO ALTERAR RENDA";
        } finally {
            em.close();

        }
    }

    public String excluir(Long id) {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Rendas categoria = em.find(Rendas.class, id);
            if (categoria != null) {
                em.remove(categoria);
                em.getTransaction().commit();
                return "RENDA EXCLUIDA COM SUCESSO!";
            } else {
                em.getTransaction().rollback();
                return "RENDA NÃO ENCONTRADA!";
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO EXCLUIR RENDA!";
        } finally {
            em.close();
        }
    }

}
