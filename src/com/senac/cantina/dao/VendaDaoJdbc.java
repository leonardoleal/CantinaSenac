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
import com.senac.cantina.model.VendaModelo;

@SuppressWarnings({ "unchecked", "rawtypes" })
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
        String[] colunas = {"Data", "Total", "Atendente", "Matricula Cliente", "Cliente"};
        List<ArrayList> listaVendas = new ArrayList<>();

        String sql = "SELECT v.data, v.total, uf.nome, c.matricula, uc.nome FROM venda v "
                + "JOIN funcionario f ON f.id = v.id_funcionario AND f.id = :idFuncionario "
                + "JOIN usuario uf ON uf.id = f.id_usuario "
                + "JOIN cliente c on c.id = v.id_cliente "
                + "JOIN usuario uc ON uc.id = c.id_usuario";
        try {
            iniciaConexao(sql);
            comando.setInt("idFuncionario", id);
            ResultSet resultado = comando.executeQuery();

            ArrayList list;
            while(resultado.next()) {
                list = new ArrayList();
                list.add(resultado.getString(1));
                list.add(resultado.getString(2));
                list.add(resultado.getString(3));
                list.add(resultado.getString(4));
                list.add(resultado.getString(5));

                listaVendas.add(list);
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

        VendaModelo modelo = new VendaModelo(colunas, listaVendas);

        return modelo;
    }

    @Override
    public AbstractTableModel listarVendaPorCliente(int id) {
        String[] colunas = {"Data", "Total", "Atendente", "Matricula Cliente", "Cliente"};
        List<ArrayList> listaVendas = new ArrayList<>();

        String sql = "SELECT v.data, v.total, uf.nome, c.matricula, uc.nome FROM venda v "
                + "JOIN funcionario f ON f.id = v.id_funcionario "
                + "JOIN usuario uf ON uf.id = f.id_usuario "
                + "JOIN cliente c on c.id = v.id_cliente AND c.id = :idCliente "
                + "JOIN usuario uc ON uc.id = c.id_usuario";
        try {
            iniciaConexao(sql);
            comando.setInt("idCliente", id);
            ResultSet resultado = comando.executeQuery();

            ArrayList list;
            while(resultado.next()) {
                list = new ArrayList();
                list.add(resultado.getString(1));
                list.add(resultado.getString(2));
                list.add(resultado.getString(3));
                list.add(resultado.getString(4));
                list.add(resultado.getString(5));

                listaVendas.add(list);
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

        VendaModelo modelo = new VendaModelo(colunas, listaVendas);

        return modelo;
    }

    @Override
    public AbstractTableModel listarVendaPorMes(int mes, int ano) {
        String[] colunas = {"Data", "Total", "Atendente", "Matricula Cliente", "Cliente"};
        List<ArrayList> listaVendas = new ArrayList<>();

        String sql = "SELECT v.data, v.total, uf.nome, c.matricula, uc.nome FROM venda v "
                + "JOIN funcionario f ON f.id = v.id_funcionario "
                + "JOIN usuario uf ON uf.id = f.id_usuario "
                + "JOIN cliente c on c.id = v.id_cliente "
                + "JOIN usuario uc ON uc.id = c.id_usuario "
                + "WHERE EXTRACT(YEAR FROM v.data) = :ano "
                + "AND EXTRACT(MONTH FROM v.data) = :mes ";
        try {
            iniciaConexao(sql);
            comando.setInt("ano", ano);
            comando.setInt("mes", mes);
            ResultSet resultado = comando.executeQuery();

            ArrayList list;
            while(resultado.next()) {
                list = new ArrayList();
                list.add(resultado.getString(1));
                list.add(resultado.getString(2));
                list.add(resultado.getString(3));
                list.add(resultado.getString(4));
                list.add(resultado.getString(5));

                listaVendas.add(list);
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

        VendaModelo modelo = new VendaModelo(colunas, listaVendas);

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