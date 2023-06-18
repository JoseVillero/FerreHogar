package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.components.converters.UsuarioConverter;
import com.adsosena.egloapps.models.UsuarioModel;
import com.adsosena.egloapps.repositories.UsuarioRepository;
import com.adsosena.egloapps.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public boolean consultarUsuarioPorId(UsuarioModel usuarioModel) {
        return usuarioRepository.existsById(usuarioModel.getEmail());
    }

    @Override
    public boolean registrarUsuario(UsuarioModel usuarioModel) {

        UsuarioConverter usuarioConverter = new UsuarioConverter();
        return usuarioRepository.save(usuarioConverter.usuarioModelToUsuario(usuarioModel)) != null;

    }
}
