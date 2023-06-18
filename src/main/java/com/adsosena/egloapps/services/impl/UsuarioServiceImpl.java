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

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return crearUser(usuarioRepository.findUsuarioByEmail(username));
    }

    private User crearUser(Usuario usuario){
        return new User(usuario.getEmail(),usuario.getPassword(), usuario.isEnable(),true,
                true,true, crearAuthority(usuario.getRoles()));
    }

    private Collection<GrantedAuthority> crearAuthority(Set<Rol> roles){
        Set<GrantedAuthority> authorities = new HashSet<>();

        for(Rol rol: roles){
            authorities.add(new SimpleGrantedAuthority(rol.name()));
        }

        return new ArrayList<>(authorities);
    }

}
