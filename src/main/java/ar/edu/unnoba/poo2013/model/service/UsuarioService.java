package ar.edu.unnoba.poo2013.model.service;

import ar.edu.unnoba.poo2013.model.model.*;
import ar.edu.unnoba.poo2013.model.repository.RepositorioDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsuarioService extends UserDetailsService {
    public void create(Usuario usuario);
    public List<Participante> getParticipantes();
    public List<Evaluador> getEvaluador();
    public List<Administrador> getAdministrador();
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException;
    public void meGusta(MaterialAprovado material);
    public void cargarMaterial();
    public Integer getMeGusta();
    public List<MaterialAprovado> materialAprovados();
    public RepositorioDao getRepositorioDao();


}
