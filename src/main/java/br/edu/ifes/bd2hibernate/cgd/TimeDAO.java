/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgd;

import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleao
 */
public class TimeDAO extends DAO {

    
    public void inserir(Object obj) {
        inserir(obj, Time.class);
    }

    public void atualizar(Object obj) {
        atualizar(obj, Time.class);
    }

    public void deletar(Object obj) {
        deletar(obj, Time.class);
    }

    public void deletar(int id) {
        deletar(id, Time.class);
    }

    public List<Time> selecionarTodos() {
        return (List<Time>) selecionarTodos(Time.class);
    }

    public Time selecionar(int id) {
        return (Time) selecionar(id, Time.class);
    }
    
    public Time selecionar(String nome){
        
        List selecionados = new ArrayList();
        try {
            //Voltar na posicao 0
            Time t = new Time();
            t.setNome(nome);
            selecionados = selecionar(Time.class, t);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if(!selecionados.isEmpty()){
            return (Time) selecionados.get(0);
        }
        
        return null;
    }
    
}
