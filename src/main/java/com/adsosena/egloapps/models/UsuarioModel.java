package com.adsosena.egloapps.models;

import com.adsosena.egloapps.entities.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**Clase UsuarioModel:
 * Esta clase representa un modelo de una entidad(tabla) de la base de datos.
 * Un modelo es un objeto intermedio que puede representar un objeto de la entidad. Ya sea para convertirse
 * en la entidad o ya esta convertido de una entidad
 * @author Jose David */
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
