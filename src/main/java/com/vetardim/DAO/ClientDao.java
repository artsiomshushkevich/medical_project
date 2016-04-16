package com.vetardim.DAO;

import org.hibernate.Criteria;
import com.vetardim.model.Client;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



import java.util.List;

public class ClientDao {

    public static void addOrUpdateClient(Client client) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteClient(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Client client = session.get(Client.class, id);

            if (client != null) {
                session.delete(client);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static Client getClientByUserId(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Client client = null;
        try {
            Criteria criteria = session.createCriteria(Client.class);
            criteria.add(Restrictions.eq("userId", id));
            client = (Client)criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return client;
    }

    public static List<Client> getClientsList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Client> clientsList = null;
        try {
            clientsList = (List<Client>)session.createCriteria(Client.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return clientsList;
    }
}
