package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.senac.cantina.dao.ClienteDaoJdbc;
import com.senac.cantina.dao.UsuarioDaoJdbc;
import com.senac.cantina.model.Cliente;
import com.senac.cantina.view.FormCliente;

public class ClienteController implements ActionListener {
    private FormCliente formCliente;

    public ClienteController(FormCliente formCliente) {
        this.formCliente = formCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formCliente.btnSalvar)) {
            if (Arrays.equals(
                    formCliente.pwdSenha.getPassword(),
                    formCliente.pwdReSenha.getPassword()
                ) && ! formCliente.pwdSenha.getPassword().toString().isEmpty()
            ) {
                Cliente cliente = new Cliente();
                cliente.setMatricula(Integer.parseInt(formCliente.txtMatricula.getText()));
                cliente.setEmail(formCliente.txtEmail.getText());
                cliente.setSaldo(Double.parseDouble(formCliente.txtSaldo.getText()));
                cliente.setNome(formCliente.txtNome.getText());
                cliente.setUsuario(formCliente.txtUsuario.getText());
                cliente.setSenha(
                        formCliente.pwdSenha.getPassword().toString()
                );

                // cria usuario
                UsuarioDaoJdbc uJdbc = new UsuarioDaoJdbc();
                cliente.setUsuario(uJdbc.inserir(cliente));

                if (cliente.getUsuarioObject() != null) {
                    // cadastra o cliente
                    ClienteDaoJdbc cJdbc = new ClienteDaoJdbc();
                    cliente = cJdbc.inserir(cliente);

                    if (cliente != null) {
                        JOptionPane.showMessageDialog(null,
                                "Cliente cadastrado com sucesso!", "Cadastro", 2);
                        formCliente.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Não foi possível cadastradar o cliente.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Não foi possível cadastradar o usuário.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                    // TODO rollback
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "As senhas não conferem!", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
                formCliente.pwdSenha.requestFocus();
            }
        } else if (e.getSource().equals(formCliente.btnCancelar)) {
            formCliente.dispose();
        }
    }
}