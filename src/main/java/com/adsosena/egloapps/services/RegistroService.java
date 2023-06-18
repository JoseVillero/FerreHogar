package com.adsosena.egloapps.services;


import com.adsosena.egloapps.models.UsuarioModel;

public interface RegistroService {

    boolean consultarUsuarioPorId(UsuarioModel usuarioModel);
    boolean registrarUsuario(UsuarioModel usuarioModel);

}
