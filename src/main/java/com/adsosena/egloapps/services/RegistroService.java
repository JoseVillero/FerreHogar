package com.adsosena.egloapps.services;


import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.UsuarioModel;

/**interface ProductoService: Esta interface declara los metodos a usar para los servicios(Logica de negocio)
 * @author Jose David */
public interface RegistroService {

    boolean consultarUsuarioPorId(UsuarioModel usuarioModel);
    boolean registrarUsuario(UsuarioModel usuarioModel);
    void agregarUsuario(UsuarioModel usuarioModel);

    void  eliminarUsuario(String id);


}
