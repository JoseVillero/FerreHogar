package com.adsosena.egloapps.services;

import com.adsosena.egloapps.models.UsuarioModel;

/**Interface ProductoService: Esta interface declara los metodos a usar para los servicios(Logica de negocio)
 * @author Jose David */
public interface RegistroService {

    boolean consultarUsuarioPorId(UsuarioModel usuarioModel);
    void registrarUsuario(UsuarioModel usuarioModel);
    void agregarUsuario(UsuarioModel usuarioModel);

    void  eliminarUsuario(String id);

    void editarUsuario(UsuarioModel usuarioModel);
}
