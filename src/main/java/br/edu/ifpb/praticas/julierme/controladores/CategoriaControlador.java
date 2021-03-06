/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.controladores;

import br.edu.ifpb.praticas.julierme.Categoria;
import br.edu.ifpb.praticas.julierme.servicos.Servico;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Julierme Heinstein
 */
@Named
@RequestScoped
public class CategoriaControlador implements Serializable{
    
    @Inject
    private Servico<Categoria> servico;
    private String categoria;
    
    public CategoriaControlador(){}
    
    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String adicionarCategoria() {
        servico.adicionar(new Categoria(categoria));
        categoria = "";
        return null;
    }
    
    public List<Categoria> lista() {
        return Collections.unmodifiableList(servico.listar());
    }

    public Categoria getNomeCategoria(String nome) {
        return servico.procurar(nome);
    }
    
}
