package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.senac.cantina.model.Cliente;
import com.senac.cantina.model.Usuario;
import com.senac.cantina.view.JanelaPrincipal;

public class JanelaPrincipalController implements ActionListener {
    private JanelaPrincipal janelaPrincipal;
    public Usuario usuario;

    public JanelaPrincipalController(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    public JanelaPrincipalController() {
        this.janelaPrincipal = new JanelaPrincipal(this);
    }

    public JanelaPrincipalController(Usuario usuario) {
        this.usuario = usuario;
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
        }
    }

    public boolean isCliente() {
        if (usuario instanceof Cliente) {
            return true;
        } 

        return false;
    }
}