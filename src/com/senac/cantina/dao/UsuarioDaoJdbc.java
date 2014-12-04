package com.senac.cantina.dao;

import java.util.List;

import com.senac.cantina.dao.interfaces.UsuarioDao;
import com.senac.cantina.model.Usuario;

public class UsuarioDaoJdbc extends Dao implements UsuarioDao {

    @Override
    public Usuario inserir(Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deletar(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Usuario> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario buscarPorId(Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

}