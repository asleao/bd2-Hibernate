/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgt;

import br.edu.ifes.bd2hibernate.cdp.Jogador;
import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleao
 */
public class Main {

    public static void main(String args[]) {
        Time time1 = new Time("Flamengo", new Date(), 1000f);
//        Time time2= new Time("Vasco", new Date(), 1000f);
//        
//        time1.inserir(time1);
//        time2.inserir(time2);
//        
//        Jogador jogador1 = new Jogador("André Aguiar",new Date(), "Rua", time1);
//        Jogador jogador2 = new Jogador("André Leão",new Date(), "Rua", time1);
//        Jogador jogador3 = new Jogador("Breno Sampaio",new Date(), "Rua", time2);
//        Jogador jogador4 = new Jogador("Diego Pasti",new Date(), "Rua", time2);
        
//        jogador1.inserir(jogador1);
//        jogador2.inserir(jogador2);
//        jogador3.inserir(jogador3);
//        jogador4.inserir(jogador4);
        
//        List<Time> times = new ArrayList<Time>();
//                times.add(new Time().selecionar("Flamengo"));
//        for (Time j : times) {
//            System.out.println(j);
//        }
        
        
        Menu menu = new Menu();
        menu.load();
    }
}
