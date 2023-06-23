package com.adsosena.egloapps.models;

import com.adsosena.egloapps.entities.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioModelTest {

    private UsuarioModel usuarioModel;

    private UsuarioModel usuarioModel2;

    private HashSet<Rol> roles;

    @BeforeEach
    void setUp() {

        roles = new HashSet<>();
        roles.add(Rol.USER);
        usuarioModel = new UsuarioModel("Joselu", "joselu@fake.com",
                "passwordTest", "847944", true, roles);

        usuarioModel2 = new UsuarioModel();
    }

    @Test
    void testAllArgumentsConstructor(){
        assertNotNull(usuarioModel);
    }

    @Test
    void testNonArgumentsConstructor(){
        assertNotNull(usuarioModel2);
    }

    @Test
    void getNombreCompleto() {
        assertEquals("Joselu", usuarioModel.getNombreCompleto());
    }

    @Test
    void getEmail() {
        assertEquals("joselu@fake.com", usuarioModel.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("passwordTest", usuarioModel.getPassword());
    }

    @Test
    void getTelefono() {
        assertEquals("847944", usuarioModel.getTelefono());
    }

    @Test
    void isEnable() {
        assertTrue(usuarioModel.isEnable());
    }

    @Test
    void getRoles() {
        assertTrue(usuarioModel.getRoles().contains(Rol.USER));
    }

    @Test
    void setNombreCompleto() {
        usuarioModel2.setNombreCompleto("Julian");
        assertEquals("Julian", usuarioModel2.getNombreCompleto());
    }

    @Test
    void setEmail() {
        usuarioModel2.setEmail("julian@fake.com");
        assertEquals("julian@fake.com", usuarioModel2.getEmail());
    }

    @Test
    void setPassword() {
        usuarioModel2.setPassword("PasswordTest");
        assertEquals("PasswordTest", usuarioModel2.getPassword());
    }

    @Test
    void setTelefono() {
        usuarioModel2.setTelefono("8789415");
        assertEquals("8789415", usuarioModel2.getTelefono());
    }

    @Test
    void setEnable() {
        usuarioModel2.setEnable(true);
        assertTrue(usuarioModel2.isEnable());
    }

    @Test
    void setRoles() {
        roles.clear();
        roles.add(Rol.ADMIN);
        usuarioModel2.setRoles(roles);
        assertTrue(roles.contains(Rol.ADMIN));
    }
}