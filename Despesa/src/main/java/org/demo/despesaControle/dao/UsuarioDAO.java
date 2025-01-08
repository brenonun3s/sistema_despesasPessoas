package org.demo.despesaControle.dao;

import org.demo.despesaControle.entities.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsuarioDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("despesasPUSQLITE");

    public void salvarUsuario(Usuario rendas) {
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

    public String atualizarUsuario(Usuario rendas) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(rendas);
            em.getTransaction().commit();
            return "USUARIO ALTERADA COM SUCESSO!";

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO ALTERAR USUARIO";
        } finally {
            em.close();

        }
    }

    public String excluir(Long id) {
        EntityManager em = this.emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Usuario categoria = em.find(Usuario.class, id);
            if (categoria != null) {
                em.remove(categoria);
                em.getTransaction().commit();
                return "USUARIO EXCLUIDA COM SUCESSO!";
            } else {
                em.getTransaction().rollback();
                return "USUARIO NÃO ENCONTRADA!";
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "ERRO AO EXCLUIR USUARIO!";
        } finally {
            em.close();
        }
    }

}
