/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.dao;

import br.edu.ifpb.praticas.julierme.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Julierme Heinstein
 */
public class CategoriaDAO implements Dados<Categoria>{
    
    private Statement stat;

    public CategoriaDAO() throws SQLException, ClassNotFoundException {
        this.stat = Acesso.getConnection();
    }
    
    @Override
    public void persistir(Categoria categoria) throws SQLException {
        try{
            int id = categoria.getID();
            String nome = categoria.getNomeCategoria();
            String sql = "INSERT INTO Categoria VALUES("+id+","+nome+")";
            
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e){throw new PersistenceException(e);}
    }

    @Override
    public Categoria buscar(String nome) throws SQLException {
        String sql = "SELECT * FROM Categoria WHERE categoria = " + nome;
        
        try{
            ResultSet rs = stat.executeQuery(sql);
        
            Categoria categoria = new Categoria();
            categoria.setID(rs.getInt(1));
            categoria.setNomeCategoria(rs.getString(2));
            
            stat.close();
        
            return categoria;
        } catch (SQLException e){throw new PersistenceException(e);}
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        String sql = "SELECT p FROM Produto p";
        
        try{
            ResultSet rs = stat.executeQuery(sql);
            List<Categoria> categorias = null;
            
            while(rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setID(rs.getInt(1));
                categoria.setNomeCategoria(rs.getString(2));
            
                
                categorias.add(categoria);
            }
            
            stat.close();
            return categorias;
        } catch (SQLException e){throw new PersistenceException(e);}
    }
    
}
