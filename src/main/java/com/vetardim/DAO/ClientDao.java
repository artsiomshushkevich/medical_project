package com.vetardim.DAO;

import com.vetardim.model.Client;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


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
