/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgt;

import br.edu.ifes.bd2hibernate.cdp.Jogador;
import br.edu.ifes.bd2hibernate.cdp.Time;
import br.edu.ifes.bd2hibernate.cgd.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleao
 */
public class Main {

    public static void main(String args[]) {
        List<Time> listaTime = new ArrayList();
        Time time = new Time();
        listaTime = time.selecionarTodos();
        for (Time t : listaTime) {
            System.out.println(t);
        }
        
        Jogador j = new Jogador("André Leão", new Date(), "Rua Tinhosa", listaTime.get(0));
        j.inserir(j);
        
        j = j.selecionar(1);
        System.out.println(j);
        //System.out.println(j);
        //j.setNome("André Leão");
        //j.atualizar(j);
        
        HibernateUtil.shutdown();
    }
}
