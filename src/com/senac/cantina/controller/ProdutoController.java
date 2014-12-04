package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.senac.cantina.dao.ProdutoDaoJdbc;
import com.senac.cantina.model.Produto;
import com.senac.cantina.view.FormProduto;

public class ProdutoController implements ActionListener {
    private FormProduto formProduto;

    public ProdutoController(FormProduto formProduto) {
        this.formProduto = formProduto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formProduto.btnSalvar)) {
            Produto produto = new Produto();
            produto.setNome(formProduto.txtNome.getText());
            produto.setValor(Double.parseDouble(formProduto.txtPreco.getText()));
            produto.setIdCategoria(Integer.parseInt(formProduto.txtIdCategoriaProduto.getText()));

            ProdutoDaoJdbc pJdbc = new ProdutoDaoJdbc();
            produto = pJdbc.inserir(produto);

            if (produto != null) {
                JOptionPane.showMessageDialog(null,
                        "Produto cadastrado com sucesso!", "Cadastro", 2);
                formProduto.dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "N�o foi poss�vel cadastradar o produto", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(formProduto.btnCancelar)) {
            formProduto.dispose();
        }
    }
}