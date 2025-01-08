package org.demo.despesaControle.dao;

import org.demo.despesaControle.entities.Orcamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrcamentoDAO {

    private static final String PERSISTENCE_UNIT_NAME = "despesasPUSQLite"; // Nome da unidade de persistência
    private final EntityManagerFactory emf;

    public OrcamentoDAO() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void salvarOrcamento(Orcamento orcamento) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(orcamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public String atualizarOrcamento(Orcamento orcamento) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(orcamento);
            em.getTransaction().commit();
            return "ORCÇAMENTO ALTERADA COM SUCESSO!";

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ORÇAMENTO AO ALTERAR DESPESA";
        } finally {
            em.close();

        }
    }

    public String excluir(Long id) {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Orcamento categoria = em.find(Orcamento.class, id);
            if (categoria != null) {
                em.remove(categoria);
                em.getTransaction().commit();
                return "ORÇAMENTO EXCLUIDA COM SUCESSO!";
            } else {
                em.getTransaction().rollback();
                return "ORÇAMENTO NÃO ENCONTRADA!";
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO EXCLUIR ORÇAMENTO!";
        } finally {
            em.close();
        }
    }
}
