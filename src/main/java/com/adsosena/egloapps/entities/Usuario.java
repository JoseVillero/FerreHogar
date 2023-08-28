package com.adsosena.egloapps.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


/**Clase producto:
 * Esta clase representa una entidad (tabla) en la base de datos.
 * Los atributos son representados como columnas en la base de datos
 * @author Jose David */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @OneToMany(mappedBy = "usuario")
    private List<Transaccion> transacciones;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Carrito carrito;
}
