/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.servicos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Julierme Heinstein
 * @param <O>
 */
public interface Servico<O> extends Serializable{
    
    /* Interface que implementa os serviços de adicionar, listar e procurar */
    void adicionar(O o);
    List<O> listar();
    O procurar(String nome);
    
}
