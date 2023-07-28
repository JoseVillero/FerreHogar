package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.UsuarioModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
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

    /**
     * Metodo usuarioModelToUsuario:
     * permite convertir un objeto UsuarioModel (objeto java) a un objeto Usuario para persistencia en base de datos
     *
     * @param usuarioModel de tipo UsuarioModel
     * @return Usuario
     */
    public Usuario usuarioModelToUsuario(UsuarioModel usuarioModel) {

        setAtributosDeUsuario(usuarioModel);
        usuario.setEnable(true);
        usuario.setRoles(new HashSet<>());
        usuario.getRoles().add(Rol.USER);
        return usuario;
    }

    public UsuarioModel usuarioToUsuarioModel(Usuario usuario) {
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNombreCompleto(usuario.getNombreCompleto());
        usuarioModel.setEmail(usuario.getEmail());
        usuarioModel.setPassword(usuario.getPassword());
        usuarioModel.setTelefono(usuario.getTelefono());
        usuarioModel.setEnable(usuario.isEnable());
        usuarioModel.setRoles(usuario.getRoles());
        return usuarioModel;
    }

    public Usuario agregarUsuario(UsuarioModel usuarioModel) {

        setAtributosDeUsuario(usuarioModel);
        usuario.setEnable(usuarioModel.isEnable());
        usuario.setRoles(new HashSet<>());
        for (Rol rol : usuarioModel.getRoles()) {
            usuario.getRoles().add(rol);
        }
        return usuario;
    }

    public void setEditarUsuario(Usuario usuario, UsuarioModel usuarioModel){

        usuario.setNombreCompleto(usuarioModel.getNombreCompleto());
        usuario.setPassword(passwordEncoder.encode(usuarioModel.getPassword()));
        usuario.setTelefono(usuarioModel.getTelefono());
        usuario.setEnable(usuarioModel.isEnable());
        for (Rol rol: usuarioModel.getRoles()) {
            usuario.getRoles().clear();
            usuario.getRoles().add(rol);
        }
    }

    private void setAtributosDeUsuario(UsuarioModel usuarioModel){

        usuario.setNombreCompleto(usuarioModel.getNombreCompleto());
        usuario.setEmail(usuarioModel.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioModel.getPassword()));
        usuario.setTelefono(usuarioModel.getTelefono());
        usuario.setTransacciones(new ArrayList<>());
    }
}

