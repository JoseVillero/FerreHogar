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

    /**Metodo usuarioModelToUsuario:
     * permite convertir un objeto UsuarioModel (objeto java) a un objeto Usuario para persistencia en base de datos
     * @param usuarioModel de tipo UsuarioModel
     * @return Usuario*/
    public Usuario usuarioModelToUsuario(UsuarioModel usuarioModel){

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Usuario usuario = new Usuario();

        usuario.setNombreCompleto(usuarioModel.getNombreCompleto());
        usuario.setEmail(usuarioModel.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioModel.getPassword()));
        usuario.setTelefono(usuarioModel.getTelefono());
        usuario.setEnable(true);
        usuario.setRoles(new HashSet<>());
        usuario.getRoles().add(Rol.USER);

        return usuario;
    }
}
