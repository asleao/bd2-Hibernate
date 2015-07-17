/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgd;

import br.edu.ifes.bd2hibernate.cdp.Jogador;
import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleao
 */
public class JogadorDAO extends DAO{

    
    public void inserir(Object obj) {
        inserir(obj, Jogador.class);
    }

    
    public void atualizar(Object obj) {
        atualizar(obj, Jogador.class);
    }

    public void deletar(Object obj) {
        deletar(obj, Jogador.class);
    }

    public void deletar(int id) {
        deletar(id, Jogador.class);
    }
    
    public List<Jogador> selecionarTodos() {
        return (List<Jogador>) selecionarTodos(Jogador.class);
    }

    public Jogador selecionar(int id) {
        return (Jogador) selecionar(id, Jogador.class);
    }
    
    public List<Jogador> selecionar(String nomeTime){
        
        List jogadores = new ArrayList();
        try {
            Time t = new Time().selecionar(nomeTime);
            Jogador j = new Jogador();
            j.setTime(t);
            jogadores.addAll(t.getJogadores());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jogadores;
    }
}
