package com.example.backendmentoria.services;

import com.example.backendmentoria.models.Usuario;
import com.example.backendmentoria.models.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);

}
