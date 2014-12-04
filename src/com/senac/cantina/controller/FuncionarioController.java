package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.senac.cantina.dao.FuncionarioDaoJdbc;
import com.senac.cantina.dao.UsuarioDaoJdbc;
import com.senac.cantina.model.Funcionario;
import com.senac.cantina.view.FormFuncionario;

public class FuncionarioController implements ActionListener {
    private FormFuncionario formFuncionario;

    public FuncionarioController(FormFuncionario formFuncionario) {
        this.formFuncionario = formFuncionario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formFuncionario.btnSalvar)) {
            if (Arrays.equals(
                    formFuncionario.pwdSenha.getPassword(),
                    formFuncionario.pwdReSenha.getPassword()
                ) && ! formFuncionario.pwdSenha.getPassword().toString().isEmpty()
            ) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(formFuncionario.txtNome.getText());
                funcionario.setUsuario(formFuncionario.txtUsuario.getText());
                funcionario.setSenha(
                        formFuncionario.pwdSenha.getPassword().toString()
                );

                // cria usuario
                UsuarioDaoJdbc uJdbc = new UsuarioDaoJdbc();
                funcionario.setUsuario(uJdbc.inserir(funcionario));

                if (funcionario.getUsuarioObject() != null) {
                    // cadastra o funcionario
                    FuncionarioDaoJdbc fJdbc = new FuncionarioDaoJdbc();
                    funcionario = fJdbc.inserir(funcionario);

                    if (funcionario != null) {
                        JOptionPane.showMessageDialog(null,
                                "Funcionário cadastrado com sucesso!", "Cadastro", 2);
                        formFuncionario.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Não foi possível cadastradar o funcionário", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Não foi possível cadastradar o usuário.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "As senhas não conferem!", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
                formFuncionario.pwdSenha.requestFocus();
            }
        } else if (e.getSource().equals(formFuncionario.btnCancelar)) {
            formFuncionario.dispose();
        }
    }
}