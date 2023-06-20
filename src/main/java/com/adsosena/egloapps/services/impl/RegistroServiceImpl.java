package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.components.converters.UsuarioConverter;
import com.adsosena.egloapps.models.UsuarioModel;
import com.adsosena.egloapps.repositories.UsuarioRepository;
import com.adsosena.egloapps.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**Clase RegistroServiceImpl: Esta clase ejecuta los servicios
 * es decir contiene la logica de negocio de la aplicacion.
 * Esta clase implementa la interface RegistroService, dicha interface
 * tiene metodos declados. La clase RegistroServiceImpl sobreescribe los metodos heredados de la interface
 * @author Jose David */
@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**Metodo consultarUsuarioPorId: Este metodo recibe un UsuarioModel, llama al repositorio de Usuario y solicita
     * consultar si el usuario del UsuarioModel esta registrado en la base de datos
     * @param usuarioModel recibe un UsuarioModel con el fin de consultar si el usuario existe en base de datos
     * @return boolean - respuesta de la peticion si existe o no el usuario*/
    @Override
    public boolean consultarUsuarioPorId(UsuarioModel usuarioModel) {
        return usuarioRepository.existsById(usuarioModel.getEmail());
    }

    /**Metodo registrarUsuario: Este metodo recibe un UsuarioModel, llama al repositorio de Usuario y solicita
     * guardar el usuario. El parametro recibido es un UsuarioModel, el metodo convierte el parametor UsuarioModel
     * a un objeto de entidad Usuario por medio de un objeto de tipo UsuarioConverter.
     * @param usuarioModel recibe un UsuarioModel para convertirlo en Usuario con el fin de guardarlo en base de datos
     * @return boolean - respuesta de la peticion si guardo o no el usuario*/
    @Override
    public boolean registrarUsuario(UsuarioModel usuarioModel) {

        UsuarioConverter usuarioConverter = new UsuarioConverter();
        return usuarioRepository.save(usuarioConverter.usuarioModelToUsuario(usuarioModel)) != null;

    }
}
