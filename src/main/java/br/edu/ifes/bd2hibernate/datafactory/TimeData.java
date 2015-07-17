/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.datafactory;

import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.Date;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author aleao
 */
public class TimeData {
    
    public void criaTimeRandom(DataFactory df,int qtdTim){
        for (int i = 0; i < qtdTim; i++) {
            salvarTime(criarTime(df));
        }
    }
    
    public Time criarTime(DataFactory df){
        Time time = new Time();
        
        time.setNome(df.getRandomWord()+" FC");
        time.setDataCriacao(df.getDateBetween(df.getDate(1960, 1, 1),
                df.getDate(2015, 8, 1)));
        time.setMensalidadeSocio(df.getNumberBetween(2000,3000));
        
        return time;
    }
    
    public void salvarTime(Time time){
        try {
            time.inserir(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
