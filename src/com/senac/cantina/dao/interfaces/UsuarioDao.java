package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Usuario;

public interface UsuarioDao {
    public Usuario inserir(Usuario Usuario);
    public boolean deletar(Usuario Usuario);
    public boolean atualizar(Usuario Usuario);
    public List<Usuario> listar();
    public Usuario buscarPorId(Usuario Usuario);
}