/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Julierme Heinstein
 * @param <O>
 */
public interface Dados<O> {
    
    /* Interface que implementa os métodos de persistir, buscar e listar acessando o banco */
    void persistir(O o) throws SQLException;
    O buscar(String nome) throws SQLException;
    List<O> listar() throws SQLException;
    
}
