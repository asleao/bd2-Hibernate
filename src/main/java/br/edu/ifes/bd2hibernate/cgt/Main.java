/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgt;

import br.edu.ifes.bd2hibernate.cdp.Jogador;
import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.Date;

/**
 *
 * @author aleao
 */
public class Main {

    public static void main(String args[]) {
        Time time = new Time(3, "Florminense das Laranjeiras", new Date(), 500.00f);
//        List<Time> listaTime = new ArrayList();
//        Time time = new Time();
//        Time time = new Time().selecionarTodos().get(0);
//        
//        for (Time t : listaTime) {
//            System.out.println(t.toString());
//        }
        
        Jogador j = new Jogador("Rafael Sobis", new Date(), "Rua Colina", time);
        j.inserir(j);
    }
}
