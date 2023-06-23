package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.UsuarioModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioConverterTest {

    @InjectMocks
    private UsuarioConverter usuarioConverter;

    @Mock
    private Usuario usuario;

    @Mock
    private UsuarioModel usuarioModel;


    @BeforeEach
    void setUp() {

        HashSet<Rol> roles = new HashSet<>();
        roles.add(Rol.USER);

        when(usuarioModel.getNombreCompleto()).thenReturn("Roberto");
        when(usuarioModel.getEmail()).thenReturn("roberto@fake.com");
        when(usuarioModel.getPassword()).thenReturn("passwordTest");
        when(usuarioModel.getTelefono()).thenReturn("9784548");
        when(usuarioModel.getRoles()).thenReturn(roles);

    }

    @Test
    void testUsuarioModelToUsuario() {

        Usuario usuario = usuarioConverter.usuarioModelToUsuario(usuarioModel);
        assertNotNull(usuario);
        assertEquals(usuarioModel.getNombreCompleto(), usuario.getNombreCompleto());
        assertEquals(usuarioModel.getEmail(), usuario.getEmail());
        assertNotEquals(usuarioModel.getPassword(), usuario.getPassword());
        assertEquals(usuarioModel.getTelefono(), usuario.getTelefono());
        assertEquals(usuarioModel.getRoles(), usuario.getRoles());
    }
}