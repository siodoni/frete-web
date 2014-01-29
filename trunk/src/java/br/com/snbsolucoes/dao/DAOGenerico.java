package br.com.snbsolucoes.dao;

import br.com.snbsolucoes.util.Constantes;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOGenerico implements Serializable {

    //private FacesContext context = FacesContext.getCurrentInstance();
    private static EntityManager em;

    private EntityManager getEntityManager() {

        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT);
            entityManager = factory.createEntityManager();
        } finally {
            if (factory != null){
                factory.close();
            }   
        }
        return entityManager;
    }

    public List buscarNamedQuery(String namedQuery, Map parametros) {
        try {
            List lista;

            if (em == null) {
                em = getEntityManager();
            }

            Query query = (Query) em.createNamedQuery(namedQuery);

            if (parametros != null) {
                for (Object key : parametros.keySet()) {
                    System.err.println("key: "+key);
                    query.setParameter(key.toString(), parametros.get(key));
                }
            }

            lista = query.getResultList();

            return lista;
        } catch (Exception e) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }

    public Object buscarNamedQuery(Map parametros, String namedQuery) {
        try {

            if (em == null) {
                em = getEntityManager();
            }

            Object lista;
            Query query = (Query) em.createNamedQuery(namedQuery);

            if (parametros != null) {
                for (Object key : parametros.keySet()) {
                    query.setParameter(key.toString(), parametros.get(key));
                }
            }

            lista = query.getSingleResult();

            return lista;
        } catch (Exception e) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }

    public Object save(Object objeto) {
        if (em == null) {
            em = getEntityManager();
        }

        try {

            em.getTransaction().begin();
            objeto = em.merge(objeto);
            em.flush();
            em.refresh(objeto);
            em.getTransaction().commit();

            return objeto;

        } catch (Exception e) {
            em.getTransaction().rollback();
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }

    public BigDecimal getSequenceValue(String sequence) {
        try {
            if (em == null) {
                em = getEntityManager();
            }

            BigDecimal retorno;

            Query query = (Query) em.createNativeQuery("select " + sequence + ".nextval as seq from sys.dual");
            retorno = (BigDecimal) query.getSingleResult();

            return retorno;
        } catch (Exception e) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }
}
