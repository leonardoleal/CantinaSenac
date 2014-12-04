package com.senac.cantina.view;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.senac.cantina.controller.JanelaPrincipalController;

public class JanelaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;

    public JMenuItem itemSair, itemCadastroCliente, itemCadastroProduto, itemCadastroFuncionario;
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
        setTitle("Cantina Senac");
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

        JMenu menuCadastro = new JMenu("Cadastro");
        menuArquivo.setMnemonic(KeyEvent.VK_D);

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