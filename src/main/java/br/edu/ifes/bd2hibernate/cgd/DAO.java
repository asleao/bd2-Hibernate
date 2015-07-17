/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgd;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aleao
 */
public abstract class DAO {

    

    public void inserir(Object obj, Class c) {
        Session s = HibernateUtil.getSession();
        HibernateUtil.begin();
        
        s.save(c.cast(obj));
        
        HibernateUtil.commit();
        HibernateUtil.close();
    }

    
    public void atualizar(Object obj, Class c) {
        Session s = HibernateUtil.getSession();
        HibernateUtil.begin();
        
        s.update(c.cast(obj));
        
        HibernateUtil.commit();
        HibernateUtil.close();
    }
    
    public void deletar(int id, Class c) {
        Session s = HibernateUtil.getSession();
        HibernateUtil.begin();

        Object o = c.cast(s.load(c, new Integer(id)));
        s.delete(c.cast(o));

        HibernateUtil.commit();
        HibernateUtil.close();
    }

    public void deletar(Object obj, Class c) {
        Session s = HibernateUtil.getSession();
        HibernateUtil.begin();
        
        s.delete(c.cast(obj));

        HibernateUtil.commit();
        HibernateUtil.close();
    }

    public List<?> selecionarTodos(Class c){        
        List listObj = new ArrayList();        
        
        try {
            Session s = HibernateUtil.getSession();
            HibernateUtil.begin();

            Query query = s.createQuery("from " + c.getName());
            listObj =  query.list();

            HibernateUtil.commit();
            HibernateUtil.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return listObj;
    }
    
    public List<?> selecionar(Class c, Field f, String value){
        List listObj = new ArrayList();
        
        try {
            Session s = HibernateUtil.getSession();
            HibernateUtil.begin();
            
            listObj = s.createCriteria(c)
                    .add(Restrictions.like(c.getSimpleName()+"."+f.getName(), value, MatchMode.ANYWHERE))
                    .list();
            
            HibernateUtil.commit();
            HibernateUtil.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObj;
    }
    
    public List<?> selecionar(Class c, Object o){
        List listObj = new ArrayList();
        try {
            Session s = HibernateUtil.getSession();
            HibernateUtil.begin();
            
            listObj = s.createCriteria(c)
                    .add(Example.create(o).excludeZeroes())
                    .list();
            
            HibernateUtil.commit();
            HibernateUtil.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObj;        
    }
    
    public Object selecionar(int id, Class c) {
        Object o = null;
        try {

            Session s = HibernateUtil.getSession();
            HibernateUtil.begin();
            
            o = s.get(c, id);
            
            HibernateUtil.commit();
            HibernateUtil.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}

