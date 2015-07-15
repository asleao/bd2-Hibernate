/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgt;

import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleao
 */
public class Main {

    public static void main(String args[]) {
//        Time time = new Time(4, "Florminense das Laranjeiras", new Date(), 500.00f);
        List<Time> listaTime = new ArrayList();
        Time time = new Time();
        listaTime = time.selecionarTodos();
        
        for (Time t : listaTime) {
            System.out.println(t.toString());
        }
    }
}
