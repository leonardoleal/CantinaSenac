package com.senac.cantina.dao.interfaces;

import javax.swing.DefaultComboBoxModel;

import com.senac.cantina.model.CategoriaProduto;

public interface CategoriaProdutoDao {
    public CategoriaProduto getCategoriaProdutoById(CategoriaProduto categoriaProduto);
    public DefaultComboBoxModel<CategoriaProduto> getComboBoxModel();
}