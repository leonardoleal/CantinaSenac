package com.senac.cantina.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.senac.cantina.controller.FuncionarioController;

public class FormFuncionario extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel lblFuncionario, lblId, lblUsuario, lblReSenha;
    private JLabel lblNome, lblSenha;
    public JTextField txtNome, txtUsuario;
    public JPasswordField pwdSenha, pwdReSenha;
    public JButton btnSalvar, btnCancelar;

    public FormFuncionario() {
        setTitle("Cadastro de Funcionário");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500, 200, 300, 320);
        setLayout(null);

        iniciarComponentes();

        setResizable(false);
        setVisible(true);
    }

    private void iniciarComponentes() {
        FuncionarioController funcionarioC = new FuncionarioController(this);

        lblFuncionario = new JLabel("Dados do Funcionário");
        lblFuncionario.setBounds(10, 11, 153, 14);
        add(lblFuncionario);

        lblId = new JLabel("Codigo: ");
        lblId.setBounds(45, 42, 46, 14);
        add(lblId);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(45, 73, 46, 14);
        add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(120, 70, 124, 20);
        txtNome.setColumns(10);
        add(txtNome);
        
        lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(45, 106, 69, 14);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 103, 124, 20);
        txtUsuario.setColumns(10);
        add(txtUsuario);

        lblSenha = new JLabel("Senha");
        lblSenha.setBounds(45, 139, 69, 14);
        add(lblSenha);

        pwdSenha = new JPasswordField();
        pwdSenha.setBounds(120, 136, 124, 20);
        add(pwdSenha);

        lblReSenha = new JLabel("Re-senha:");
        lblReSenha.setBounds(45, 172, 69, 14);
        add(lblReSenha);

        pwdReSenha = new JPasswordField();
        pwdReSenha.setBounds(120, 169, 124, 20);
        add(pwdReSenha);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(45, 216, 94, 23);
        btnSalvar.addActionListener(funcionarioC);
        add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(150, 216, 94, 23);
        btnCancelar.addActionListener(funcionarioC);
        add(btnCancelar);
    }

//    public static void main(String[] args) {
//        new FormFuncionario();
//    }
}