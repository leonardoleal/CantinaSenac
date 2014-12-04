package com.senac.cantina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.senac.cantina.dao.interfaces.FuncionarioDao;
import com.senac.cantina.model.Funcionario;

public class FuncionarioDaoJdbc extends Dao implements FuncionarioDao {

    @Override
    public Funcionario inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(id_usuario) "
                + "VALUES (:idUsuario)";
        try {
            super.iniciaConexao(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setInt("idUsuario", funcionario.getIdUsuario());
            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();

            funcionario.setId(resultado.getInt(1));
            return funcionario;
        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        return null;
    }

    @Override
    public boolean deletar(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Funcionario> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Funcionario buscarPorId(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return null;
    }

}