/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.controladores;

import br.edu.ifpb.praticas.julierme.Categoria;
import br.edu.ifpb.praticas.julierme.Produto;
import br.edu.ifpb.praticas.julierme.servicos.Servico;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Julierme Heinstein
 */
public class ProdutoControlador{
    
    private String foto;
    private Servico<Produto> produtoserv;
    private Servico<Categoria> categoriaserv;
    private Produto produto;
    
    /* adicionar Produtos */
    public String adicionarProduto() throws IOException{
        
        Categoria categoria = categoriaserv.procurar(produto.getCategoria().getNomeCategoria());
        if (categoria == null) {
            categoriaserv.adicionar(produto.getCategoria());
        }
        produto.setFoto(foto);
        produtoserv.adicionar(produto);
        produto = new Produto();
        return null;
    }
    
    public String getFoto(){return this.foto;}
    public void setFoto(String caminho){this.foto = caminho;}
    public List<Produto> listarProdutos(){return produtoserv.listar();} /* Listar todos os produtos */
    public Produto getProduto(){return this.produto;}
    public void setProduto(Produto produto){this.produto = produto;}
    
}
