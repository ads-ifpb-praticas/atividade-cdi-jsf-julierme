/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme;

import java.io.Serializable;

/**
 *
 * @author Julierme Heinstein
 */
public class Categoria implements Serializable{
    
    /* Atributos */
    private int ID;
    private String categoria;
    
    /* Construtor padrão */
    public Categoria(){}
    
    /* Construtor com Nome */
    public Categoria(String nome){this.categoria = nome;}
    
    /* Construtor com Nome e Produto */
    public Categoria(int id, String nome){
        this.ID = id;
        this.categoria = nome;
    }
    
    /* Getters e Setters */
    public int getID(){return this.ID;}
    public void setID(int id){this.ID = id;}
    
    public String getNomeCategoria(){return this.categoria;}
    public void setNomeCategoria(String categoria){this.categoria = categoria;}
    
}
