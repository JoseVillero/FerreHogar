package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**Clase UsuarioServiceImpl: Esta clase ejecuta los servicios
 * es decir contiene la logica de negocio de la aplicacion.
 * Esta clase implementa la interface UsuarioService, dicha interface
 * tiene metodos declados. La clase UsuarioServiceImpl sobreescribe los metodos heredados
 * @author Jose David */
@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**Metodo loadUserByUsername : Metodo heredado de la interface. El metodo es sobre escrito e implemtado.
     * recibe una cadena con el nombre de usuario. El metodo llama al objeto de tipo UsuarioRepository.
     * y el objeto se encarga de buscar el nombre de usuario en la base de datos
     * @param username  recibe una cadena con el nombre de usuario
     * @return UserDetails - este objeto contiene la informacion de la autorizacion y autenticacion del usuario*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return crearUser(usuarioRepository.findUsuarioByEmail(username));
    }

    /**Metodo crearUser : Metodo de apoyo. Recibe un objeto de tipo Usuario y lo convierte en un objeto User de
     * Spring security. Este objeto tiene la contraseña cifrada de la base de datos y los authority es el objeto
     * que spring valida esta o no autenticado
     * @param usuario  de tipo Usuario
     * @return User - objeto de tipo User de Spring Security*/
    private User crearUser(Usuario usuario){
        return new User(usuario.getEmail(),usuario.getPassword(), usuario.isEnable(),true,
                true,true, crearAuthority(usuario.getRoles()));
    }

    /**Metodo crearAuthority : Metodo de apoyo. Recibe un Set de tipo Rol y lo convierte en una coleccion
     * con tipos de datos GrantedAuthority
     * @param roles  de tipo Set Rol
     * @return Collection<> - coleccion de tipo GrantedAuthority de Spring Security*/
    private Collection<GrantedAuthority> crearAuthority(Set<Rol> roles){
        Set<GrantedAuthority> authorities = new HashSet<>();

        for(Rol rol: roles){
            authorities.add(new SimpleGrantedAuthority(rol.name()));
        }

        return new ArrayList<>(authorities);
    }

}
