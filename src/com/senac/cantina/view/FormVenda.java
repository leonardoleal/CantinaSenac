package com.senac.cantina.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.senac.cantina.controller.CategoriaProdutoController;
import com.senac.cantina.controller.ProdutoController;
import com.senac.cantina.controller.VendaController;
import com.senac.cantina.librarie.Session;
import com.senac.cantina.model.CategoriaProduto;
import com.senac.cantina.model.Produto;

public class FormVenda extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel lblIdCategoriaProduto, lblAtendente, lblMatricula, lblQuantidade, lblRegistrarVenda;
    private JLabel lblIdProduto;
    public JTextField txtMatricula, txtQuantidade;
    public JComboBox<CategoriaProduto> cmbIdCategoriaProduto;
    public JComboBox<Produto> cmbIdProduto;
    public JButton btnSalvar, btnCancelar;
    private VendaController vendaC;


    public FormVenda() {
        vendaC = new VendaController(this);
        init();
    }

    public FormVenda(VendaController vendaController)  {
        vendaC = vendaController;
        init();
    }

    public void init() {
        setTitle("Registro de Venda");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 300, 300, 305);
        setLayout(null);

        iniciarComponentes();

        setResizable(false);
        setVisible(true);
    }

    private void iniciarComponentes() {
        lblRegistrarVenda = new JLabel("Registro de Venda");
        lblRegistrarVenda.setBounds(10, 11, 153, 14);
        add(lblRegistrarVenda);

        lblAtendente = new JLabel("Atendente: " + Session.USUARIO.getNome());
        lblAtendente.setBounds(45, 42, 46, 14);
        add(lblAtendente);

        lblMatricula = new JLabel("Cliente: ");
        lblMatricula.setBounds(45, 73, 46, 14);
        add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setBounds(120, 70, 124, 20);
        txtMatricula.setColumns(10);
        add(txtMatricula);

        lblIdCategoriaProduto = new JLabel("Categoria:");
        lblIdCategoriaProduto.setBounds(45, 106, 90, 14);
        add(lblIdCategoriaProduto);

        cmbIdProduto = new JComboBox<Produto>();

        cmbIdCategoriaProduto = new JComboBox<CategoriaProduto>();
        cmbIdCategoriaProduto.setModel(CategoriaProdutoController.getComboBoxModel());
        cmbIdCategoriaProduto.addActionListener(
                new ActionListener() {
                    @SuppressWarnings("unchecked")
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cmbIdProduto.setModel(
                            ProdutoController.getComboBoxModel(
                                ((CategoriaProduto)
                                    ((JComboBox<CategoriaProduto>) e.getSource())
                                .getSelectedItem()
                                ).getId()
                            )
                        );
                    }
                }
        );
        cmbIdCategoriaProduto.setBounds(120, 103, 124, 20);
        add(cmbIdCategoriaProduto);

        lblIdProduto = new JLabel("Produto:");
        lblIdProduto.setBounds(45, 139, 90, 14);
        add(lblIdProduto);

        cmbIdProduto.setModel(ProdutoController.getComboBoxModel(1));
        cmbIdProduto.setBounds(120, 136, 124, 20);
        add(cmbIdProduto);

        lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(45, 172, 90, 14);
        add(lblQuantidade);

        txtQuantidade = new JTextField("1");
        txtQuantidade.setBounds(120, 169, 124, 20);
        txtQuantidade.setEditable(false);
        add(txtQuantidade);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(45, 206, 94, 23);
        btnSalvar.addActionListener(vendaC);
        add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(150, 206, 94, 23);
        btnCancelar.addActionListener(vendaC);
        add(btnCancelar);
    }
}