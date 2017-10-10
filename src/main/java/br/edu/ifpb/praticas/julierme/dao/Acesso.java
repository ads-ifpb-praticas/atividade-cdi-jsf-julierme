/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.julierme.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Julierme Heinstein
 */
public class Acesso {
    
    /* Estabelecer conexão com o banco */
    public static Statement getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/cdi-jsf-bd";
        String user = "postgres";
        String senha = "avantasia";
        Connection conn = DriverManager.getConnection(url, user, senha);
        Statement stat = conn.createStatement();
        return stat;
    }
    
}
