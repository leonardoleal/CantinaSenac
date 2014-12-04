package com.senac.cantina.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.banco.ConnectionFactory;
import com.senac.cantina.librarie.NamedParameterStatement;

public class Dao {
    protected Connection conexao;
    protected NamedParameterStatement comando;

    protected void iniciaConexao(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConexaoPostgres();
        comando = new NamedParameterStatement(conexao, sql);
    }
    
    protected void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }

    protected void logger(String className, Exception ex) {
        Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, className, ex);
    }
}