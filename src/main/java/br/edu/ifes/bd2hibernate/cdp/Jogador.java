/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cdp;

import br.edu.ifes.bd2hibernate.cgd.JogadorDAO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author 20141BSI0566
 */
@Entity
@Table(name = "jogadores")
public class Jogador extends JogadorDAO implements Serializable{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome",nullable = false)
    private String nome;
    
    @Column(name = "dataNascimento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "endereco",nullable = false)
    private String endereco;
    
    @ManyToOne
    @JoinColumn(name="time_id")
    private Time time;

    public Jogador() {
    }

    public Jogador(int id, String nome, Date dataNascimento, String endereço, Time time) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereço;
        this.time = time;
    }
    
    public Jogador(String nome, Date dataNascimento, String endereço, Time time) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereço;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Jogador{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", time=" + time + '}';
    }
}
