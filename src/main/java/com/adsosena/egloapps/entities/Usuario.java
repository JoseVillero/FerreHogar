package com.adsosena.egloapps.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Column(name = "nombre_completo", unique = false, length = 45, nullable = false)
    private String nombreCompleto;

    @Id
    @Column(name = "correo", unique = true, length = 45, nullable = false )
    private String email;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "telefono", unique = false, length = 25, nullable = true)
    private String telefono;

    @Column(name = "activado", nullable = false, columnDefinition = "boolean default true")
    private boolean enable;

    @ElementCollection(targetClass = Rol.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "roles_usuario")
    @Column(name = "rol")
    private Set<Rol> roles;

}
