package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.senac.cantina.view.JanelaPrincipal;

public class JanelaPrincipalController implements ActionListener {
    private JanelaPrincipal janelaPrincipal;

    public JanelaPrincipalController(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    public JanelaPrincipalController() {
        this.janelaPrincipal = new JanelaPrincipal(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(janelaPrincipal.itemSair)) {
            janelaPrincipal.dispose();
        } else if (e.getSource().equals(janelaPrincipal.itemCadastroCliente)) {
            new ClienteController();
        } else if (e.getSource().equals(janelaPrincipal.itemCadastroFuncionario)) {
            new FuncionarioController();
        } else if (e.getSource().equals(janelaPrincipal.itemCadastroProduto)) {
            new ProdutoController();
        } else if (e.getSource().equals(janelaPrincipal.itemRegistrarVenda)) {
            new VendaController();
        } else if (e.getSource().equals(janelaPrincipal.itemRelPorCliente)) {
            new RelatorioController(RelatorioController.tipoRelatorio.VENDAPORCLIENTE);
        } else if (e.getSource().equals(janelaPrincipal.itemRelPorFuncionario)) {
            new RelatorioController(RelatorioController.tipoRelatorio.VENDAPORFUNCIONARIO);
        } else if (e.getSource().equals(janelaPrincipal.itemRelPorMes)) {
            new RelatorioController(RelatorioController.tipoRelatorio.VENDAPORMES);
        }

    }
}