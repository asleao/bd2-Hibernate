/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgd;

import br.edu.ifes.bd2hibernate.cdp.Time;
import java.util.List;

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

    @Override
    public List<?> selecionarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object selecionar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
