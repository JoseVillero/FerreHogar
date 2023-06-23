package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioServiceImplTest {

    @InjectMocks
    UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;


    @BeforeEach
    void setUp() {

        HashSet<Rol> roles = new HashSet<Rol>();
        roles.add(Rol.USER);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        usuario = new Usuario("Andres Hernandez", "andres@fake.com",
                passwordEncoder.encode("passwordTest"), "787897", true, roles);

        when(usuarioRepository.findUsuarioByEmail("andres@fake.com")).thenReturn(usuario);
    }

    @Test
    void testloadUserByUsername() {
        UserDetails userDetails = usuarioService.loadUserByUsername("andres@fake.com");
        assertInstanceOf(UserDetails.class, userDetails);
        assertEquals(usuario.getEmail(), userDetails.getUsername());
    }
}