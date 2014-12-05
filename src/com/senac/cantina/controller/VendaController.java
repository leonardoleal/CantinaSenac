package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.senac.cantina.dao.ClienteDaoJdbc;
import com.senac.cantina.dao.ProdutoVendaDaoJdbc;
import com.senac.cantina.dao.VendaDaoJdbc;
import com.senac.cantina.librarie.Session;
import com.senac.cantina.model.Cliente;
import com.senac.cantina.model.Funcionario;
import com.senac.cantina.model.Produto;
import com.senac.cantina.model.ProdutoVenda;
import com.senac.cantina.model.Venda;
import com.senac.cantina.view.FormVenda;

public class VendaController implements ActionListener {
    private FormVenda formVenda;

    public VendaController(FormVenda formVenda) {
        this.formVenda = formVenda;
    }

    public VendaController() {
        this.formVenda = new FormVenda(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formVenda.btnSalvar)) {
            Venda venda = new Venda();
            Cliente cliente = new Cliente();
            cliente.setMatricula(Integer.parseInt(formVenda.txtMatricula.getText()));
            Produto produto = ((Produto) formVenda.cmbIdProduto.getSelectedItem());

            ClienteDaoJdbc cJdbc = new ClienteDaoJdbc();
            cliente = cJdbc.buscarPorMatricula(cliente);

            VendaDaoJdbc vJdbc = new VendaDaoJdbc();
            venda = vJdbc.registrar(
                cliente,
                (Funcionario) Session.USUARIO,
                produto.getValor()
            );

            if (venda != null) {
                // debita do cliente
                cliente.setSaldo(
                    cliente.getSaldo() - venda.getTotal()
                );
                cJdbc.atualizar(cliente);

                // registra produto_venda
                ProdutoVendaDaoJdbc pvJdbc = new ProdutoVendaDaoJdbc();
                ProdutoVenda produtoVenda = pvJdbc.cadastrarItemVenda(
                    venda,
                    produto,
                    Integer.parseInt(formVenda.txtQuantidade.getText())
                );

                if (produtoVenda != null) {
                    JOptionPane.showMessageDialog(null,
                            "Venda registrada.\nValor debitado: " + venda.getTotal(), "Cadastro", 2);
                }
                formVenda.dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Não foi possível cadastradar o produto", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(formVenda.btnCancelar)) {
            formVenda.dispose();
        }
    }
}