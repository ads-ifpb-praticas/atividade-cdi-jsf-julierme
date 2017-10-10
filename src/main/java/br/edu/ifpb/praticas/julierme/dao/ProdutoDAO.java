/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.dao;

import br.edu.ifpb.praticas.julierme.Categoria;
import br.edu.ifpb.praticas.julierme.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Julierme Heinstein
 */
public class ProdutoDAO implements Dados<Produto>{
    
    private Statement stat;
    
    public ProdutoDAO() throws SQLException, ClassNotFoundException{
        this.stat = Acesso.getConnection();
    }

    @Override
    public void persistir(Produto produto) throws SQLException{
        try{
            int ident = produto.getIdentificacao();
            String nome = produto.getNome();
            String foto = produto.getFoto();
            String desc = produto.getDescricao();
            float preco = produto.getPrecoUnitario();
            String marca = produto.getMarca();
            Categoria categoria = produto.getCategoria();
            
            String sql = "INSERT INTO Produto VALUES("+ident+","+nome+","+foto+","
                    +desc+","+preco+","+marca+","+categoria+")";
            
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e){throw new PersistenceException(e);}
    }

    @Override
    public Produto buscar(String nomeMarca) throws SQLException{
        String sql = "SELECT * FROM Produto p WHERE marca =" + nomeMarca;
        
        try{
            ResultSet rs = stat.executeQuery(sql);
        
            Produto produto = new Produto();
            produto.setIdentificacao(rs.getInt(1));
            produto.setNome(rs.getString(2));
            produto.setFoto(rs.getString(3));
            produto.setDescricao(rs.getString(4));
            produto.setPrecoUnitario(rs.getFloat(5));
            produto.setMarca(rs.getString(6));
            produto.setCategoria(rs.getObject(7, Categoria.class));
            
            stat.close();
        
            return produto;
        } catch (SQLException e){throw new PersistenceException(e);}
    }

    @Override
    public List<Produto> listar() throws SQLException{
        String sql = "SELECT p FROM Produto p";
        
        try{
            ResultSet rs = stat.executeQuery(sql);
            List<Produto> produtos = null;
            
            while(rs.next()) {
                Produto produto = new Produto();
                produto.setIdentificacao(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setFoto(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setPrecoUnitario(rs.getFloat(5));
                produto.setMarca(rs.getString(6));
                produto.setCategoria(rs.getObject(7, Categoria.class));
                
                produtos.add(produto);
            }
            
            stat.close();
            
            return produtos;
        } catch (SQLException e){throw new PersistenceException(e);}
    }
    
}
