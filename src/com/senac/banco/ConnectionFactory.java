/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.senac.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lhries
 */
public class ConnectionFactory {
    public final static String BANCO = "cantina_senac";
    public final static String USER="postgres";
    public final static String SENHA="postgres";
    
    public static Connection getConexaoPostgres() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/"+BANCO;
        
        Connection conexao = DriverManager.getConnection(url, USER, SENHA);
        return(conexao);
    }
    
    public static Connection getConexaoMySQL() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/"+BANCO;
        
        Connection conexao = DriverManager.getConnection(url, USER, SENHA);
        return(conexao);
        
    }
}
