package br.com.snbsolucoes.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.snbsolucoes.util.HibernateUtil;

public class DAOGenerico implements Serializable {

    private static final long serialVersionUID = 1L;

    public List listarNamedQuery(String namedQuery, Map parametros) {
        try {
        	Session session = HibernateUtil.getSession();
            List lista;
            
            Query query = (Query) session.getNamedQuery(namedQuery);

            if (parametros != null) {
                for (Object key : parametros.keySet()) {
                    System.err.println("key: "+key);
                    query.setParameter(key.toString(), parametros.get(key));
                }
            }

            lista = query.list();

            return lista;
        } catch (Exception e) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }

    public Object buscarNamedQuery(String namedQuery, Map parametros) {
        try {
        	Session session = HibernateUtil.getSession();

            Object lista;
            Query query = (Query) session.getNamedQuery(namedQuery);

            if (parametros != null) {
                for (Object key : parametros.keySet()) {
                    query.setParameter(key.toString(), parametros.get(key));
                }
            }

            lista = query.uniqueResult();

            return lista;
        } catch (Exception e) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }

    public Object save(Object objeto) {
    	Session session = HibernateUtil.getSession();

        try {

            session.getTransaction().begin();
            objeto = session.merge(objeto);
            session.flush();
            session.refresh(objeto);
            session.getTransaction().commit();

            return objeto;

        } catch (Exception e) {
            session.getTransaction().rollback();
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }

    public BigDecimal getSequenceValue(String sequence) {
        try {
        	Session session = HibernateUtil.getSession();
        	
            BigDecimal retorno;

            Query query = (Query) session.createSQLQuery("select " + sequence + ".nextval as seq from sys.dual");
            retorno = (BigDecimal) query.uniqueResult();

            return retorno;
        } catch (Exception e) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, e.toString(), null));
            e.printStackTrace();
            return null;
        }
    }
}
