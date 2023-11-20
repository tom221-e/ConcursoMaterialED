package ar.edu.unnoba.poo2013.model.service;
import ar.edu.unnoba.poo2013.model.model.Usuario;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class SecurityService {

    public boolean isAdmin(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return usuario.getTipo().equals("Administrador");
    }
}