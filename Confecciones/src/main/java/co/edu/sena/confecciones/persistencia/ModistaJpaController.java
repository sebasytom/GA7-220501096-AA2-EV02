/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.confecciones.persistencia;

import co.edu.sena.confecciones.logica.Modista;
import co.edu.sena.confecciones.persistencia.exceptions.NonexistentEntityException;
import co.edu.sena.confecciones.persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author SEBAS
 */

public class ModistaJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;
    
    
    public ModistaJpaController() {
        emf=Persistence.createEntityManagerFactory("confeccionesPU");
    }

    public ModistaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Modista modista) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(modista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findModista(modista.getId()) != null) {
                throw new PreexistingEntityException("Modista " + modista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Modista modista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            modista = em.merge(modista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = modista.getId();
                if (findModista(id) == null) {
                    throw new NonexistentEntityException("The modista with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Modista modista;
            try {
                modista = em.getReference(Modista.class, id);
                modista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The modista with id " + id + " no longer exists.", enfe);
            }
            em.remove(modista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Modista> findModistaEntities() {
        return findModistaEntities(true, -1, -1);
    }

    public List<Modista> findModistaEntities(int maxResults, int firstResult) {
        return findModistaEntities(false, maxResults, firstResult);
    }

    private List<Modista> findModistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Modista.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Modista findModista(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Modista.class, id);
        } finally {
            em.close();
        }
    }

    public int getModistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Modista> rt = cq.from(Modista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
