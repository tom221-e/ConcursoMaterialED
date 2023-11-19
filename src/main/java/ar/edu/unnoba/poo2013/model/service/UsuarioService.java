package ar.edu.unnoba.poo2013.model.service;

import ar.edu.unnoba.poo2013.model.model.*;
import ar.edu.unnoba.poo2013.model.repository.MaterialEducativoRepository;
import ar.edu.unnoba.poo2013.model.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsuarioService extends UserDetailsService {
    public List<MaterialEducativo> materialesEducativosEnRevision();
    public void create(Usuario usuario);
    public List<Usuario> getParticipantes();
    public List<Usuario> getAllUsuarios();
    public List<Usuario> getEvaluador();
    public List<Usuario> getAdministrador();
    public Usuario loadUserByUsername(String username) throws
            UsernameNotFoundException;
    public void cargarMaterial(MaterialEducativo material, Usuario usuario);
    public List<MaterialEducativo> materialesEducativos();
    public MaterialEducativoRepository getMaterialEducativoRepository();
    public UsuarioRepository getUsuarioRepository();
    public void updateAprobado(Long id);
    public void updateRechazado(Long id);


}
