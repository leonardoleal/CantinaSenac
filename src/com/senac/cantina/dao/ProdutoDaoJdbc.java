package com.senac.cantina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.senac.cantina.dao.interfaces.ProdutoDao;
import com.senac.cantina.model.Produto;

public class ProdutoDaoJdbc extends Dao implements ProdutoDao {

    @Override
    public Produto inserir(Produto produto) {
        String sql = "INSERT INTO produto(id_categoria, nome, valor) "
                + "VALUES (:idCategoria, :nome, :valor)";
        try {
            super.iniciaConexao(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setInt("idCategoria", produto.getIdCategoria());
            comando.setString("nome", produto.getNome());
            comando.setDouble("valor", produto.getValor());
            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            resultado.next();

            produto.setId(resultado.getInt(1));
            return produto;
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
    public boolean deletar(Produto produto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Produto produto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Produto> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produto buscarPorId(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }

}