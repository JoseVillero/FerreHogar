package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.UsuarioModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

public class UsuarioConverter {

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
