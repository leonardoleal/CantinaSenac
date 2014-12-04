package com.senac.cantina.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.senac.cantina.controller.ClienteController;

public class FormCliente extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel lblCliente, lblId, lblUsuario, lblReSenha, lblSenha;
    private JLabel lblEmail, lblMatricula, lblSaldo, lblNome;
    public JTextField txtEmail, txtMatricula, txtSaldo, txtNome, txtUsuario;
    public JPasswordField pwdSenha, pwdReSenha;
    public JButton btnSalvar, btnCancelar;
    private ClienteController clienteC;

    public FormCliente() {
        clienteC = new ClienteController(this);
        init();
    }

    public FormCliente(ClienteController clienteController) {
        clienteC = clienteController;
        init();
    }

    private void init() {
        setTitle("Cadastro de Cliente");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500, 200, 300, 400);
        setLayout(null);

        iniciarComponentes();

        setResizable(false);
        setVisible(true);
    }

    private void iniciarComponentes() {
        lblCliente = new JLabel("Dados do Cliente");
        lblCliente.setBounds(10, 11, 153, 14);
        add(lblCliente);

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

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(45, 106, 69, 14);
        add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(120, 103, 124, 20);
        txtEmail.setColumns(10);
        add(txtEmail);

        lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(45, 139, 69, 14);
        add(lblMatricula);
        
        txtMatricula = new JTextField();
        txtMatricula.setBounds(120, 136, 124, 20);
        txtMatricula.setColumns(10);
        add(txtMatricula);

        lblSaldo = new JLabel("Saldo Inicial:");
        lblSaldo.setBounds(45, 172, 69, 14);
        add(lblSaldo);
        
        txtSaldo = new JTextField();
        txtSaldo.setBounds(120, 169, 124, 20);
        txtSaldo.setColumns(10);
        add(txtSaldo);
        
        lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(45, 215, 69, 14);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 212, 124, 20);
        txtUsuario.setColumns(10);
        add(txtUsuario);

        lblSenha = new JLabel("Senha");
        lblSenha.setBounds(45, 248, 69, 14);
        add(lblSenha);

        pwdSenha = new JPasswordField();
        pwdSenha.setBounds(120, 245, 124, 20);
        add(pwdSenha);

        lblReSenha = new JLabel("Re-senha:");
        lblReSenha.setBounds(45, 291, 69, 14);
        add(lblReSenha);

        pwdReSenha = new JPasswordField();
        pwdReSenha.setBounds(120, 288, 124, 20);
        add(pwdReSenha);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(45, 332, 94, 23);
        btnSalvar.addActionListener(clienteC);
        add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(150, 332, 94, 23);
        btnCancelar.addActionListener(clienteC);
        add(btnCancelar);
    }

//    public static void main(String[] args) {
//        Dao.DAODEBUG = false;
//        new FormCliente();
//    }
}