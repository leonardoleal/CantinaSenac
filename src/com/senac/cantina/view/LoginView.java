package com.senac.cantina.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.senac.cantina.controller.LoginController;

public class LoginView extends JFrame {
    private static final long serialVersionUID = 1L;

    public JLabel lblLogin, lblUsuario, lblSenha;
    public JTextField txtUsuario;
    public JPasswordField pwdSenha;
    public JButton btnOK, btnSair;
    private LoginController loginC;

    public LoginView() {
        this.loginC = new LoginController(this);
        init();
    }

    public LoginView(LoginController loginC) {
        this.loginC = loginC;
        init();
    }

    private void init() {
        setTitle("LOGIN - Cantina Senac");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 250, 360, 320);
        setLayout(null);

        iniciarComponentes();

        setResizable(false);
        this.setVisible(true);
    }

    private void iniciarComponentes() {
        lblLogin = new JLabel("Sistema Cantina/SENAC");
        lblLogin.setBounds(111, 34, 196, 28);
        add(lblLogin);

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(111, 73, 132, 14);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(111, 88, 145, 20);
        txtUsuario.setColumns(10);
        add(txtUsuario);

        lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(111, 119, 46, 14);
        add(lblSenha);

        pwdSenha = new JPasswordField();
        pwdSenha.setBounds(111, 134, 145, 20);
        add(pwdSenha);

        btnOK = new JButton("OK");
        btnOK.setBounds(111, 165, 52, 23);
        btnOK.addActionListener(loginC);
        add(btnOK);

        btnSair = new JButton("Sair");
        btnSair.setBounds(168, 165, 88, 23);
        btnSair.addActionListener(loginC);

        add(btnSair);
    }
}