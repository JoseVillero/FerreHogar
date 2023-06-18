package com.adsosena.egloapps.Configurations;

import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(usuarioService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http)throws Exception{

        http
                .authorizeHttpRequests((authorize) -> authorize.requestMatchers("/css/**", "/images/**", "/registro", "/registrar").permitAll().anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout(LogoutConfigurer::permitAll)
                .authenticationProvider(authenticationProvider());

        return http.build();

    }
}
