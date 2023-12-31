package ar.edu.unnoba.poo2013.model.service;

import ar.edu.unnoba.poo2013.model.model.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsuarioService extends UserDetailsService {
    public void create(Usuario usuario);
    public List<Usuario> getParticipantes();
    public List<Usuario> getAllUsuarios();
    public List<Usuario> getEvaluador();
    public List<Usuario> getAdministrador();
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException;
    public void cargarMaterial(MaterialEducativo material);
    public List<MaterialEducativo> materialesEducativos();


}
