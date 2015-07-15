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
        Time time = new Time(4, "Florminense das Laranjeiras", new Date(), 500.00f);
        time.deletar(time.getId());
    }
}
