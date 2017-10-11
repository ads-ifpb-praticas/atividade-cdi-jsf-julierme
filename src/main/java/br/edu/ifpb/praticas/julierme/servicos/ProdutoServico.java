/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.servicos;

import br.edu.ifpb.praticas.julierme.Produto;
import br.edu.ifpb.praticas.julierme.dao.Dados;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Julierme Heinstein
 */
public class ProdutoServico implements Servico<Produto>{
    
    @Inject
    private Dados<Produto> produtodados;
    @Inject
    private CategoriaServico categoriaserv;

    /* Adiciona produto no banco */
    @Override
    public void adicionar(Produto produto) {
        try {produtodados.persistir(produto);}
        catch (SQLException ex) {Logger.getLogger(ProdutoServico.class.getName()).log(Level.SEVERE, null, ex);}
    }

    /* Lista todas os produtos presentes no banco */
    @Override
    public List<Produto> listar() {
        try {return produtodados.listar();}
        catch (SQLException ex) {Logger.getLogger(ProdutoServico.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }

    /* Procura os produtos no banco passando um nome como parâmetro */
    @Override
    public Produto procurar(String nome) {
        try {return produtodados.buscar(nome);}
        catch (SQLException ex) {Logger.getLogger(ProdutoServico.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }
    
}
