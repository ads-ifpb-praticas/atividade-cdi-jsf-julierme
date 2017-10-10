/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.servicos;

import br.edu.ifpb.praticas.julierme.Produto;
import br.edu.ifpb.praticas.julierme.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julierme Heinstein
 */
public class ProdutoServico implements Servico<Produto>{
    
    private ProdutoDAO dao;

    @Override
    public void adicionar(Produto produto) {
        try {dao.persistir(produto);}
        catch (SQLException ex) {Logger.getLogger(ProdutoServico.class.getName()).log(Level.SEVERE, null, ex);}
    }

    @Override
    public List<Produto> listar() {
        try {return dao.listar();}
        catch (SQLException ex) {Logger.getLogger(ProdutoServico.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }

    @Override
    public Produto procurar(String chave) {
        try {return dao.buscar(chave);}
        catch (SQLException ex) {Logger.getLogger(ProdutoServico.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }
    
}
