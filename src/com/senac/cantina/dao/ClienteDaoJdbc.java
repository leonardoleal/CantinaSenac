package com.senac.cantina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.senac.cantina.dao.interfaces.ClienteDao;
import com.senac.cantina.model.Cliente;

public class ClienteDaoJdbc extends Dao implements ClienteDao {

    @Override
    public Cliente inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(id_usuario, matricula, email, saldo) "
                + "VALUES (:idUsuario, :matricula, :email, :saldo)";
        try {
            super.iniciaConexao(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setInt("idUsuario", cliente.getIdUsuario());
            comando.setInt("matricula", cliente.getMatricula());
            comando.setString("email", cliente.getEmail());
            comando.setDouble("saldo", cliente.getSaldo());
            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();

            cliente.setId(resultado.getInt(1));
            return cliente;
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
    public boolean deletar(Cliente cliente) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Cliente> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente buscarPorId(Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente buscarPorMatricula(Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }

}