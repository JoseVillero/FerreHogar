package com.adsosena.egloapps.models;


import com.adsosena.egloapps.entities.Carrito;
import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Transaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**Clase UsuarioModel:
 * Esta clase representa un modelo de una entidad(tabla) de la base de datos.
 * Un modelo es un objeto intermedio que puede representar un objeto de la entidad. Ya sea para convertirse
 * en la entidad o ya está convertido de una entidad
 * @author Jose David */
@Getter
@AllArgsConstructor
public class UsuarioModel {

    private String nombreCompleto;

    private String email;

    private String password;

    private String telefono;

    private boolean enable;

    private Set<Rol> roles;

    private List<Transaccion> transacciones;

    private Carrito carrito;

    public UsuarioModel() {

        this.roles = new HashSet<>();
        this.transacciones = new ArrayList<>();
    }

    public void setNombreCompleto(String nombreCompleto) {
        if(nombreCompleto !=null && !nombreCompleto.isBlank()){
            this.nombreCompleto = nombreCompleto;
        }

    }

    public void setEmail(String email) {
        if(email !=null && !email.isBlank()){
            this.email = email;
        }
    }

    public void setPassword(String password) {
        if(password !=null && !password.isBlank()){
            this.password = password;
        }
    }

    public void setTelefono(String telefono) {
        if(telefono !=null && !telefono.isBlank()){
            this.telefono = telefono;
        }
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setEnable(String enable) {
        this.enable = Boolean.parseBoolean(enable);
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}
