/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cdp;

import br.edu.ifes.bd2hibernate.cgd.TimeDAO;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author 20141BSI0566
 */
@Entity
@Table(name = "times")
public class Time extends TimeDAO implements Serializable{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "dataCriacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(name = "mensalidadeSocio", nullable = false)
    private float mensalidadeSocio;
    
    @OneToMany(mappedBy="time")
    private Set<Jogador> jogadores;

    public Time() {
    }

    public Time(String nome, Date dataCriacao, float mensalidadeSocio) {
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.mensalidadeSocio = mensalidadeSocio;
    }
    
    public Time(int id, String nome, Date dataCriacao, float mensalidadeSocio) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.mensalidadeSocio = mensalidadeSocio;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public float getMensalidadeSocio() {
        return mensalidadeSocio;
    }

    public void setMensalidadeSocio(float mensalidadeSocio) {
        this.mensalidadeSocio = mensalidadeSocio;
    }
   
    
}
