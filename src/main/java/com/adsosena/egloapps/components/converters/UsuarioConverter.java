package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.UsuarioModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;


/**
 * Clase UsuarioConverter:
 * Brinda metodos que permite convertir un objeto de una clase modelo(una clase java estandar)
 * en un objeto de una entidad (una clase que representa una tabla)
 * @author Jose David */
public class UsuarioConverter {

    private final PasswordEncoder passwordEncoder;

    private final Usuario usuario;

    public UsuarioConverter() {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.usuario = new Usuario();
    }

    /**Metodo usuarioModelToUsuario:
     * permite convertir un objeto UsuarioModel (objeto java) a un objeto Usuario para persistencia en base de datos
     * @param usuarioModel de tipo UsuarioModel
     * @return Usuario*/
    public Usuario usuarioModelToUsuario(UsuarioModel usuarioModel){


        usuario.setNombreCompleto(usuarioModel.getNombreCompleto());
        usuario.setEmail(usuarioModel.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioModel.getPassword()));
        usuario.setTelefono(usuarioModel.getTelefono());
        usuario.setEnable(true);
        usuario.setRoles(new HashSet<>());
        usuario.getRoles().add(Rol.USER);
       // TODO: Hacer usuario.setTransacciones() usuario.setCarrito()

        return usuario;
    }

    public UsuarioModel usuarioToUsuarioModel(Usuario usuario){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNombreCompleto(usuario.getNombreCompleto());
        usuarioModel.setEmail(usuario.getEmail());
        usuarioModel.setPassword(usuario.getPassword());
        usuarioModel.setTelefono(usuario.getTelefono());
        usuarioModel.setEnable(usuario.isEnable());
        usuarioModel.setRoles(usuario.getRoles());
        // TODO: Hacer usuarioModel.setTransacciones() usuarioModel.setCarrito()


        return usuarioModel;
    }

    public Usuario agregarUsuario(UsuarioModel usuarioModel){


        usuario.setNombreCompleto(usuarioModel.getNombreCompleto());
        usuario.setEmail(usuarioModel.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioModel.getPassword()));
        usuario.setTelefono(usuarioModel.getTelefono());
        usuario.setEnable(usuarioModel.isEnable());
        usuario.setRoles(new HashSet<>());
        for(Rol rol: usuarioModel.getRoles()){
            usuario.getRoles().add(rol);
        }
        // TODO: Hacer usuario.setTransacciones() usuario.setCarrito()

        return usuario;
    }
}
//todo: agregar nuevos atributos junto con setter getter, revisar constructor