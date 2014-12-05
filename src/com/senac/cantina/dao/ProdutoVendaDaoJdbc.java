package com.senac.cantina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.senac.cantina.dao.interfaces.ProdutoVendaDao;
import com.senac.cantina.model.Produto;
import com.senac.cantina.model.ProdutoVenda;
import com.senac.cantina.model.Venda;

public class ProdutoVendaDaoJdbc extends Dao implements ProdutoVendaDao {

    @Override
    public ProdutoVenda cadastrarItemVenda(Venda venda, Produto produto, int quantidade) {
        ProdutoVenda produtoVenda = null;

        String sql = "INSERT INTO produto_venda(id_venda, id_produto, quantidade, valor) "
                + "VALUES (:idVenda, :idProduto, :quantidade, :valor)";
        try {
            double total = produto.getValor() * quantidade;
            super.iniciaConexao(sql, Statement.RETURN_GENERATED_KEYS);

            comando.setInt("idVenda", venda.getId());
            comando.setInt("idProduto", produto.getId());
            comando.setInt("quantidade", quantidade);
            comando.setDouble("valor", total);
            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                produtoVenda = montaProdutoVenda(resultado);
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

        return produtoVenda;
    }

    @Override
    public List<Integer> getIdProdutoDoCarrinho(Venda venda) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletarProdutosDaVenda(Venda venda) {
        // TODO Auto-generated method stub
        
    }
    
    private ProdutoVenda montaProdutoVenda(ResultSet resultado) throws SQLException {
        ProdutoVenda venda = new ProdutoVenda(
                resultado.getInt("id"),
                resultado.getInt("id_venda"),
                resultado.getInt("id_produto"),
                resultado.getInt("quantidade"),
                resultado.getDouble("valor")
        );

        return venda;
    }

}