/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Julierme Heinstein
 */
@Entity
@SequenceGenerator(name = "produto")
public class Produto implements Serializable{
    
    /* Atributos */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nidentificacao;
    @Column(unique = true, nullable = false)
    private String nome;
    private String foto;
    private String descricao;
    private float precounitario;
    private String marca;
    @OneToOne
    private Categoria categoria;
    
    
    /* Construtor padrão */
    public Produto(){}

    /* Construtor sem Categoria*/
    public Produto (int identificacao, String nome, String foto, String descricao, float preco, String marca){
        this.nidentificacao = identificacao;
        this.nome = nome;
        this.foto = foto;
        this.descricao = descricao;
        this.precounitario = preco;
        this.marca = marca;
    }
    
    /* Construtor com Categoria*/
    public Produto (int identificacao, String nome, String foto, String descricao, float preco, String marca, Categoria categoria){
        this.nidentificacao = identificacao;
        this.nome = nome;
        this.foto = foto;
        this.descricao = descricao;
        this.precounitario = preco;
        this.marca = marca;
        this.categoria = categoria;
    }
    
    /* Getters e Setters */
    public int getIdentificacao(){return this.nidentificacao;}
    public void setIdentificacao(int identificacao){this.nidentificacao = identificacao;}
    
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    
    public String getFoto(){return this.foto;}
    public void setFoto(String foto){this.foto = foto;}
    
    public String getDescricao(){return this.descricao;}
    public void setDescricao(String descricao){this.descricao = descricao;}
    
    public float getPrecoUnitario(){return this.precounitario;}
    public void setPrecoUnitario(float preco){this.precounitario = preco;}
    
    public String getMarca(){return this.marca;}
    public void setMarca(String marca){this.marca = marca;}
    
    public Categoria getCategoria(){return this.categoria;}
    public void setCategoria(Categoria categoria){this.categoria = categoria;}

    public int getNidentificacao() {
        return nidentificacao;
    }

    public void setNidentificacao(int nidentificacao) {
        this.nidentificacao = nidentificacao;
    }
    
}
