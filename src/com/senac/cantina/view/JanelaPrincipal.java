package com.senac.cantina.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.senac.cantina.controller.JanelaPrincipalController;
import com.senac.cantina.librarie.Session;
import com.senac.cantina.model.Cliente;

public class JanelaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;

    public JMenuItem itemSair, itemCadastroCliente, itemCadastroProduto, itemCadastroFuncionario;
    public JMenuItem itemRegistrarVenda, itemRelPorCliente, itemRelPorFuncionario, itemRelPorMes;
    public JanelaPrincipalController janelaPrincipalC;

    public JanelaPrincipal() {
        janelaPrincipalC = new JanelaPrincipalController(this);
        init();
    }

    public JanelaPrincipal(JanelaPrincipalController janelaPrincipalController) {
        janelaPrincipalC = janelaPrincipalController;
        init();
    }

    private void init() {
        String titulo = "Cantina Senac";

        if (Session.isCliente()) {
            titulo += " - Cliente";
        } else {
            titulo += " - Funcionario";
        }

        setTitle(titulo);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400, 200, 500, 500);
        setLayout(null);

        iniciaMenu();

        setResizable(false);
        this.setVisible(true);
    }

    private void iniciaMenu() {
        JMenuBar barraMenu = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);

        itemSair = new JMenuItem("Sair");
        itemSair.setIcon(createImageIcon("/imagem/sair.png"));
        itemSair.setMnemonic(KeyEvent.VK_R);
        itemSair.setAccelerator(KeyStroke.getKeyStroke("control W"));
        itemSair.setToolTipText("Sai da aplicação");
        itemSair.addActionListener(janelaPrincipalC);
        menuArquivo.add(itemSair);

        barraMenu.add(menuArquivo);

        if (! Session.isCliente()) {
            JMenu menuCadastro = new JMenu("Cadastro");
            menuCadastro.setMnemonic(KeyEvent.VK_D);

            itemCadastroCliente = new JMenuItem("Cadastrar Cliente");
            itemCadastroCliente.setMnemonic(KeyEvent.VK_C);
            itemCadastroCliente.setAccelerator(KeyStroke.getKeyStroke("control C"));
            itemCadastroCliente.setToolTipText("Cadastrar Cliente");
            itemCadastroCliente.addActionListener(janelaPrincipalC);
            menuCadastro.add(itemCadastroCliente);

            itemCadastroFuncionario = new JMenuItem("Cadastrar Funcionário");
            itemCadastroFuncionario.setMnemonic(KeyEvent.VK_F);
            itemCadastroFuncionario.setAccelerator(KeyStroke.getKeyStroke("control F"));
            itemCadastroFuncionario.setToolTipText("Cadastrar Funcionário");
            itemCadastroFuncionario.addActionListener(janelaPrincipalC);
            menuCadastro.add(itemCadastroFuncionario);

            itemCadastroProduto = new JMenuItem("Cadastrar Produto");
            itemCadastroProduto.setMnemonic(KeyEvent.VK_P);
            itemCadastroProduto.setAccelerator(KeyStroke.getKeyStroke("control P"));
            itemCadastroProduto.setToolTipText("Cadastrar Produto");
            itemCadastroProduto.addActionListener(janelaPrincipalC);
            menuCadastro.add(itemCadastroProduto);

            barraMenu.add(menuCadastro);

            itemRegistrarVenda = new JMenuItem("Registrar Venda");
            itemRegistrarVenda.setMnemonic(KeyEvent.VK_V);
            itemRegistrarVenda.setAccelerator(KeyStroke.getKeyStroke("control V"));
            itemRegistrarVenda.setToolTipText("Registrar Venda");
            itemRegistrarVenda.addActionListener(janelaPrincipalC);
            itemRegistrarVenda.setMaximumSize(new Dimension(100, 50));
            barraMenu.add(itemRegistrarVenda);

            JMenu menuRelatorio = new JMenu("Relatório");
            menuRelatorio.setMnemonic(KeyEvent.VK_L);

            itemRelPorCliente = new JMenuItem("Vendas por Cliente");
            itemRelPorCliente.setMnemonic(KeyEvent.VK_C);
            itemRelPorCliente.setAccelerator(KeyStroke.getKeyStroke("control E"));
            itemRelPorCliente.setToolTipText("Relatório de Vendas por Cliente");
            itemRelPorCliente.addActionListener(janelaPrincipalC);
            menuRelatorio.add(itemRelPorCliente);

            itemRelPorFuncionario = new JMenuItem("Vendas por Funcionário");
            itemRelPorFuncionario.setMnemonic(KeyEvent.VK_F);
            itemRelPorFuncionario.setAccelerator(KeyStroke.getKeyStroke("control O"));
            itemRelPorFuncionario.setToolTipText("Relatório de Vendas por Funcionário");
            itemRelPorFuncionario.addActionListener(janelaPrincipalC);
            menuRelatorio.add(itemRelPorFuncionario);

            itemRelPorMes = new JMenuItem("Vendas por Mês");
            itemRelPorMes.setMnemonic(KeyEvent.VK_M);
            itemRelPorMes.setAccelerator(KeyStroke.getKeyStroke("control S"));
            itemRelPorMes.setToolTipText("Relatório de Vendas por Cliente");
            itemRelPorMes.addActionListener(janelaPrincipalC);
            menuRelatorio.add(itemRelPorMes);

            barraMenu.add(menuRelatorio);

            JLabel lblDados = new JLabel("Funcionário: " + Session.USUARIO.getId());
            lblDados.setBounds(10, 11, 200, 14);
            add(lblDados);

            JLabel lblNome = new JLabel("Você está logado como: " + Session.USUARIO.getNome());
            lblNome.setBounds(45, 42, 300, 14);
            add(lblNome);


        //dados do cliente
        } else {
            JLabel lblDados = new JLabel("Seus dados");
            lblDados.setBounds(10, 11, 200, 14);
            add(lblDados);

            JLabel lblNome = new JLabel("Nome: " + Session.USUARIO.getNome());
            lblNome.setBounds(45, 42, 200, 14);
            add(lblNome);

            JLabel lblEmail = new JLabel("Email: " + ((Cliente) Session.USUARIO).getEmail());
            lblEmail.setBounds(45, 73, 200, 14);
            add(lblEmail);
            
            JLabel lblSaldo = new JLabel("Saldo: " + ((Cliente) Session.USUARIO).getSaldo());;
            lblSaldo.setBounds(45, 106, 200, 14);
            add(lblSaldo);
        }

        barraMenu.add(Box.createHorizontalGlue());

        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic(KeyEvent.VK_J);
        barraMenu.add(menuAjuda);

        this.setJMenuBar(barraMenu);
    }

    protected static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = JanelaPrincipal.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = JanelaPrincipal.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

//    public static void main(String[] args) {
//        new JanelaPrincipal();
//    }
}