package com.adsosena.egloapps.services.impl;


import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.UsuarioModel;
import com.adsosena.egloapps.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class RegistroServiceImplTest {

    @InjectMocks
    private RegistroServiceImpl registroService;

    @Mock
    private UsuarioRepository usuarioRepository;

    private UsuarioModel usuarioModel;

    private HashSet<Rol> roles;

    private Usuario usuario;

    @BeforeEach
    void setUp() {

        roles = new HashSet<>();
        roles.add(Rol.USER);

        usuarioModel = new UsuarioModel();
        usuarioModel.setEmail("guillermo@fake.com");
        usuarioModel.setRoles(roles);
        usuarioModel.setEmail("Guilleromo@fake.com");
        usuarioModel.setPassword("passwordTest");
        usuarioModel.setEnable(true);
        usuarioModel.setNombreCompleto("Guillermo");
        usuarioModel.setTelefono("7987945");

        when(usuarioRepository.existsById(usuarioModel.getEmail())).thenReturn(true);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(new Usuario());

    }

    @Test
    void testConsultarUsuarioPorId() {
        assertTrue(registroService.consultarUsuarioPorId(usuarioModel));
    }

    @Test
    void testConsultarUsuarioNoexitePorId(){
        when(usuarioRepository.existsById(usuarioModel.getEmail())).thenReturn(false);
        assertFalse(registroService.consultarUsuarioPorId(usuarioModel));
    }

    @Test
    void testRegistrarUsuario() {

        assertTrue(registroService.registrarUsuario(usuarioModel));

    }
}