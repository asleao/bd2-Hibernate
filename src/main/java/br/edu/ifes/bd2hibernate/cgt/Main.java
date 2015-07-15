/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgt;

import br.edu.ifes.bd2hibernate.cdp.Time;
import br.edu.ifes.bd2hibernate.cgd.HibernateSessionManager;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author aleao
 */
public class Main {

    public static void main(String args[]) {
        Session session = HibernateSessionManager.getSessionFactory().openSession();

        session.beginTransaction();
        Time time = new Time("Flamengo", new Date(), 2000.00f);
//        Jogador jogador = new Jogador(null, "André Leão", Calendar.getInstance(), "Rua", "");


        session.save(time);
        session.getTransaction().commit();
        
        HibernateSessionManager.shutdown();
    }
}
