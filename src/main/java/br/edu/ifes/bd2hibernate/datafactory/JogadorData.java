/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.datafactory;

import br.edu.ifes.bd2hibernate.cdp.Jogador;
import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author aleao
 */
public class JogadorData {
    
    public void criaJogadorRandom(DataFactory df,int qtdJog){
        for (int i = 0; i < qtdJog; i++) {
            salvarJogador(criarJogador(df));
        }
    }
    
    public Jogador criarJogador(DataFactory df){
        Jogador jogador = new Jogador();
        List<Time> listaTime = new Time().selecionarTodos();
        
        jogador.setNome(df.getName());
        jogador.setDataNascimento(df.getBirthDate());
        jogador.setEndereco(df.getAddress());
        jogador.setTime(df.getItem(listaTime));
        
        return jogador;
    }
    
    public void salvarJogador(Jogador jogador){
        try {
            jogador.inserir(jogador);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
}
