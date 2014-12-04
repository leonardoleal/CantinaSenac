package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.senac.cantina.dao.UsuarioDaoJdbc;
import com.senac.cantina.model.Usuario;
import com.senac.cantina.view.LoginView;

public class LoginController implements ActionListener {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    public LoginController() {
        this.loginView = new LoginView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginView.btnOK)) {
            if (! (loginView.txtUsuario.toString().isEmpty()
                    && loginView.pwdSenha.toString().isEmpty())
            ) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(loginView.txtUsuario.getText());
                usuario.setSenha(loginView.pwdSenha.getPassword());

                // seleciona usuario
                UsuarioDaoJdbc uJdbc = new UsuarioDaoJdbc();
                usuario = uJdbc.validarLogin(usuario);

                if (usuario != null) {
                    new JanelaPrincipalController(usuario);
                    loginView.dispose();
                    return;
                }
            }
        } else if (e.getSource().equals(loginView.btnSair)) {
            loginView.dispose();
            return;
        }

        JOptionPane.showMessageDialog(null, "Usuário ou senha inválida.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
    }
}