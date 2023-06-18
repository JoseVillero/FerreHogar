package com.adsosena.egloapps.models;

import com.adsosena.egloapps.entities.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    private String nombreCompleto;

    private String email;

    private String password;

    private String telefono;

    private boolean enable;

    private Set<Rol> roles;



}
