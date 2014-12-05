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
            cliente.setId(resultado.getInt("id"));

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
            cliente = null;
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        return cliente;
    }

    @Override
    public boolean deletar(Cliente cliente) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE cliente "
                        + "SET matricula = :matricula, email = :email, saldo = :saldo "
                        + "WHERE id = :id";
        try {
            iniciaConexao(sql);

            comando.setInt("id", cliente.getId());
            comando.setInt("matricula", cliente.getMatricula());
            comando.setString("email", cliente.getEmail());
            comando.setDouble("saldo", cliente.getSaldo());

            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                return true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        return false;
    }

    @Override
    public List<Cliente> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente buscarPorId(Cliente cliente) {
        String sql = "SELECT * FROM cliente "
                        + "WHERE id = :id";

        try {
            iniciaConexao(sql);

            comando.setInt("id", cliente.getId());
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                cliente = montaCliente(resultado);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }
        return cliente;
    }

    @Override
    public Cliente buscarPorMatricula(Cliente cliente) {
        String sql = "SELECT * FROM cliente "
                + "WHERE matricula = :matricula";

        try {
            iniciaConexao(sql);

            comando.setInt("matricula", cliente.getMatricula());
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                cliente = montaCliente(resultado);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        return cliente;
    }

    private Cliente montaCliente(ResultSet resultado) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setId(resultado.getInt("id"));
        cliente.setIdUsuario(resultado.getInt("id_usuario"));
        cliente.setMatricula(resultado.getInt("matricula"));
        cliente.setEmail(resultado.getString("email"));
        cliente.setSaldo(resultado.getDouble("saldo"));

        return cliente;
    }
}