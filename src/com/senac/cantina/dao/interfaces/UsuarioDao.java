package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Usuario;

public interface UsuarioDao {
    public Usuario inserir(Usuario usuario);
    public boolean deletar(Usuario usuario);
    public boolean atualizar(Usuario usuario);
    public List<Usuario> listar();
    public Usuario buscarPorId(Usuario usuario);
    public Usuario validarLogin(Usuario usuario);
}