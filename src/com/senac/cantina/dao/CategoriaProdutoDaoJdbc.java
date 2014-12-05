package com.senac.cantina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

import com.senac.cantina.dao.interfaces.CategoriaProdutoDao;
import com.senac.cantina.model.CategoriaProduto;

public class CategoriaProdutoDaoJdbc extends Dao implements CategoriaProdutoDao {

    @Override
    public CategoriaProduto getCategoriaProdutoById(
            CategoriaProduto categoriaProduto) {
        // TODO Auto-generated method stub
        return null;
    }

    public DefaultComboBoxModel<CategoriaProduto> getComboBoxModel() {
        DefaultComboBoxModel<CategoriaProduto> comboBoxModel =
                new DefaultComboBoxModel<CategoriaProduto>();

        String sql = "SELECT * FROM categoria_produto";
        try {
            super.iniciaConexao(sql);

            ResultSet res = comando.executeQuery();

            comboBoxModel.addElement(new CategoriaProduto(0,"Selecione um produto"));
            while (res.next()) {
                comboBoxModel.addElement(
                    new CategoriaProduto(
                        res.getInt("id"),
                        res.getString("descricao")
                   )
                );
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

        return comboBoxModel;
    }
}