package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.components.converters.UsuarioConverter;
import com.adsosena.egloapps.entities.Carrito;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.UsuarioModel;
import com.adsosena.egloapps.repositories.UsuarioRepository;
import com.adsosena.egloapps.services.CarritoService;
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

    private final UsuarioRepository usuarioRepository;

    private final UsuarioConverter usuarioConverter;


    private final CarritoService carritoService;

    private Usuario usuario;

    private Carrito carrito;

    @Autowired
    public RegistroServiceImpl(UsuarioRepository usuarioRepository, CarritoService carritoService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioConverter = new UsuarioConverter();
        this.carritoService = carritoService;
    }

    /**Metodo consultarUsuarioPorId: Este metodo recibe un UsuarioModel, llama al repositorio de Usuario y solicita
     * consultar si el usuario del UsuarioModel está registrado en la base de datos
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
    public void registrarUsuario(UsuarioModel usuarioModel) {

            usuario = usuarioConverter.usuarioModelToUsuario(usuarioModel);
            setCarritoYGuardarUsuario(usuario);
    }

    @Override
    public void agregarUsuario(UsuarioModel usuarioModel) {

        usuario = usuarioConverter.agregarUsuario(usuarioModel);
        setCarritoYGuardarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(String id) {

        usuarioRepository.deleteById(id);
    }

    @Override
    public void editarUsuario(UsuarioModel usuarioModel) {

        usuario = usuarioRepository.findUsuarioByEmail(usuarioModel.getEmail());
        usuarioConverter.setEditarUsuario(usuario, usuarioModel);
        usuarioRepository.save(usuario);
    }

    private void setCarritoYGuardarUsuario(Usuario usuario){

        carrito = carritoService.crearCarrito(usuario);
        usuario.setCarrito(carrito);
        usuarioRepository.save(usuario);
    }
}
