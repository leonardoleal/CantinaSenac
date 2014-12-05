package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;

import com.senac.cantina.dao.CategoriaProdutoDaoJdbc;
import com.senac.cantina.model.CategoriaProduto;

public class CategoriaProdutoController implements ActionListener {
//    private FormCategoriaProduto formCategoriaProduto;

//    public CategoriaProdutoController(FormCategoriaProduto formCategoriaProduto) {
//        this.formCategoriaProduto = formCategoriaProduto;
//    }

//    public CategoriaProdutoController() {
//        this.formCategoriaProduto = new FormCategoriaProduto();
//    }

    public static ComboBoxModel<CategoriaProduto> getComboBoxModel() {
        CategoriaProdutoDaoJdbc cpJdbc = new CategoriaProdutoDaoJdbc();
        return cpJdbc.getComboBoxModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}