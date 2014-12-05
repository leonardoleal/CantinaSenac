package com.senac.cantina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.senac.cantina.dao.interfaces.VendaDao;
import com.senac.cantina.model.Cliente;
import com.senac.cantina.model.Funcionario;
import com.senac.cantina.model.Venda;
import com.senac.cantina.model.VendaClienteModelo;

public class VendaDaoJdbc extends Dao implements VendaDao {

    @Override
    public Venda registrar(Cliente cliente, Funcionario funcionario, Double total) {
        Venda venda = null;

        String sql = "INSERT INTO venda(id_funcionario, id_cliente, total, data) "
                + "VALUES (:idFuncionario, :idCliente, :total, CURRENT_DATE)";
        try {
            super.iniciaConexao(sql, Statement.RETURN_GENERATED_KEYS);

            comando.setInt("idFuncionario", funcionario.getId());
            comando.setInt("idCliente", cliente.getId());
            comando.setDouble("total", total);
            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();

            if (resultado.next()) {
                venda = montaVenda(resultado);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        return venda;
    }

    @Override
    public boolean deletar(Venda codigoVenda) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public AbstractTableModel listarVendaPorFuncionario(int id) {
        // TODO SQL e Colunas
        String[] colunas = {"Nome", "Idade"};
        List<Venda> listaVendas = new ArrayList<>();

        String sql = "SELECT * FROM venda";
        try {
            iniciaConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next())
            {
                Venda venda = montaVenda(resultado);
                listaVendas.add(venda);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        VendaClienteModelo modelo = new VendaClienteModelo(colunas, listaVendas);

        return modelo;
    }

    @Override
    public AbstractTableModel listarVendaPorCliente(int id) {
        // TODO SQL e Colunas
        String[] colunas = {"Nome", "Idade"};
        List<Venda> listaVendas = new ArrayList<>();

        String sql = "SELECT * FROM venda";
        try {
            iniciaConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next())
            {
                Venda venda = montaVenda(resultado);
                listaVendas.add(venda);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        VendaClienteModelo modelo = new VendaClienteModelo(colunas, listaVendas);

        return modelo;
    }

    @Override
    public AbstractTableModel listarVendaPorMes(int mes, int ano) {
        // TODO SQL e Colunas
        String[] colunas = {"Nome", "Idade"};
        List<Venda> listaVendas = new ArrayList<>();

        String sql = "SELECT * FROM venda";
        try {
            iniciaConexao(sql);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next())
            {
                Venda venda = montaVenda(resultado);
                listaVendas.add(venda);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            super.logger(this.getClass().getName(), ex);
        } finally {
            try {
                super.fecharConexao();
            } catch (SQLException ex) {
                super.logger(this.getClass().getName(), ex);
            }
        }

        VendaClienteModelo modelo = new VendaClienteModelo(colunas, listaVendas);

        return modelo;
    }
    
    private Venda montaVenda(ResultSet resultado) throws SQLException {
        Venda venda = new Venda(
                resultado.getInt("id"),
                resultado.getInt("id_funcionario"),
                resultado.getInt("id_cliente"),
                resultado.getDouble("total"),
                resultado.getDate("data")
        );

        return venda;
    }

}