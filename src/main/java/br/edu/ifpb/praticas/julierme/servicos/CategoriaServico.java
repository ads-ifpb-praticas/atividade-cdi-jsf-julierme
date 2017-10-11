/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.servicos;

import br.edu.ifpb.praticas.julierme.Categoria;
import br.edu.ifpb.praticas.julierme.dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julierme Heinstein
 */
public class CategoriaServico implements Servico<Categoria>{
    
    private CategoriaDAO dao;

    /* Adiciona categoria no banco */
    @Override
    public void adicionar(Categoria categoria) {
        try {dao.persistir(categoria);}
        catch (SQLException ex) {Logger.getLogger(CategoriaServico.class.getName()).log(Level.SEVERE, null, ex);}
    }

    /* Lista todas as categorias presentes no banco */
    @Override
    public List<Categoria> listar() {
        try {return dao.listar();}
        catch (SQLException ex) {Logger.getLogger(CategoriaServico.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }

    /* Procura as categorias no banco passando um nome como parâmetro */
    @Override
    public Categoria procurar(String nome) {
        try {return dao.buscar(nome);}
        catch (SQLException ex) {Logger.getLogger(CategoriaServico.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }
    
}
