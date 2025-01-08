package org.demo.despesaControle.dao;

import org.demo.despesaControle.entities.Despesas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DespesasDAO {

    private static final String PERSISTENCE_UNIT_NAME = "despesasPUSQLite"; // Nome da unidade de persistência
    private final EntityManagerFactory emf;

    public DespesasDAO() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public Despesas salvarDespesas(Despesas despesas) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(despesas);
            em.getTransaction().commit();
            return despesas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public String atualizarDespesas(Despesas despesas, Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(despesas);
            em.getTransaction().commit();
            return "DESPESA ALTERADA COM SUCESSO!";

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO ALTERAR DESPESA";
        } finally {
            em.close();

        }
    }

    public String excluir(Despesas despesas, Long id) {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Despesas categoria = em.find(Despesas.class, id);
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
