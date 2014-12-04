package com.senac.cantina.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.senac.cantina.dao.interfaces.UsuarioDao;
import com.senac.cantina.model.Usuario;

public class UsuarioDaoJdbc extends Dao implements UsuarioDao {

    @Override
    public Usuario inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, usuario, senha) "
                + "VALUES (:nome, :usuario, :senha)";
        try {
            super.iniciaConexao(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setString("nome", usuario.getNome());
            comando.setString("usuario", usuario.getUsuario());
            comando.setString("senha", usuario.getSenha());
            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();

            usuario.setId(resultado.getInt(1));
            return usuario;
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
    public boolean deletar(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Usuario> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario buscarPorId(Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

}