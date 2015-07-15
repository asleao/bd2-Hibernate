/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgd;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author aleao
 */
public abstract class DAO {

    public SessionFactory sessionFactory = HibernateSessionManager.getSessionFactory();

    public void inserir(Object obj, Class c) {
        Session s = this.sessionFactory.openSession();
        s.beginTransaction();
        s.save(c.cast(obj));
        s.getTransaction().commit();
        HibernateSessionManager.shutdown();
    }

    ;
    
    public void atualizar(Object obj, Class c) {
        Session s = this.sessionFactory.openSession();
        s.beginTransaction();
        s.update(c.cast(obj));
        s.getTransaction().commit();
        HibernateSessionManager.shutdown();
    }

    ;
    
    public void deletar(int id, Class c) {
        Session s = this.sessionFactory.openSession();
        s.beginTransaction();

        Object o = c.cast(s.load(c, new Integer(id)));
        s.delete(c.cast(o));

        s.getTransaction().commit();
        HibernateSessionManager.shutdown();
    }

    public void deletar(Object obj, Class c) {
        Session s = this.sessionFactory.openSession();
        s.beginTransaction();
        
        s.delete(c.cast(obj));

        s.getTransaction().commit();
        HibernateSessionManager.shutdown();
    }

    public  List<?> selecionarTodos(Class c){        
        List listObj = new ArrayList();        
        
        try {
            Session s = this.sessionFactory.openSession();
            s.beginTransaction();

            Query query = s.createQuery("from " + c.getName());
            listObj =  query.list();

            s.getTransaction().commit();
            HibernateSessionManager.shutdown();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateSessionManager.shutdown();
        }
       return listObj;
    }

    
    public abstract Object selecionar(int id);
}
