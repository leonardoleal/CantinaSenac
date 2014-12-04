package com.senac.cantina.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.senac.cantina.controller.ProdutoController;

public class FormProduto extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel lblIdCategoriaProduto, lblId, lblNome, lblPreco, lblCadastrarProduto;
    public JTextField txtNome, txtIdCategoriaProduto, txtPreco;
    public JButton btnSalvar, btnCancelar;

    public FormProduto() {
        setTitle("Cadastro de Produto");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 300, 300, 275);
        setLayout(null);

        iniciarComponentes();

        setResizable(false);
        setVisible(true);
    }

    private void iniciarComponentes() {
        ProdutoController produtoC = new ProdutoController(this);

        lblCadastrarProduto = new JLabel("Dados do Produto");
        lblCadastrarProduto.setBounds(10, 11, 153, 14);
        add(lblCadastrarProduto);

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

        lblIdCategoriaProduto = new JLabel("Categoria:");
        lblIdCategoriaProduto.setBounds(45, 106, 69, 14);
        add(lblIdCategoriaProduto);

        txtIdCategoriaProduto = new JTextField();
        txtIdCategoriaProduto.setBounds(120, 103, 124, 20);
        txtIdCategoriaProduto.setColumns(10);
        add(txtIdCategoriaProduto);

        lblPreco = new JLabel("Preço(R$):");
        lblPreco.setBounds(45, 139, 69, 14);
        add(lblPreco);

        txtPreco = new JTextField();
        txtPreco.setBounds(120, 136, 124, 20);
        txtPreco.setColumns(10);
        add(txtPreco);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(45, 176, 94, 23);
        btnSalvar.addActionListener(produtoC);
        add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(150, 176, 94, 23);
        btnCancelar.addActionListener(produtoC);
        add(btnCancelar);
    }

    public static void main(String[] args) {
        new FormProduto();
    }
}