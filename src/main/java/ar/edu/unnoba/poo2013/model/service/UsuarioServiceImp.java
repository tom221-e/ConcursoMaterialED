package ar.edu.unnoba.poo2013.model.service;

import ar.edu.unnoba.poo2013.model.model.*;
import ar.edu.unnoba.poo2013.model.repository.RepositorioDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UsuarioServiceImp implements UsuarioService{
    private RepositorioDao repositorioDao=new RepositorioDao();

    @Override
    public void create(Usuario usuario) {

    }


    public RepositorioDao getRepositorioDao() {
        return repositorioDao;
    }

    public void setRepositorioDao(RepositorioDao repositorioDao) {
        this.repositorioDao = repositorioDao;
    }

    public List<MaterialEducativo> materialAprovados(){
        return repositorioDao.getMaterialEducativo();
    }

    public List<Usuario> getAllUsuarios() {
        return repositorioDao.getUsuarios();
    }
    @Override
    public List<Usuario> getParticipantes() {
        return repositorioDao.getParticipantes();
    }

    @Override
    public List<Usuario> getEvaluador() {
        return repositorioDao.getEvaluador();
    }

    @Override
    public List<Usuario> getAdministrador() {
        return repositorioDao.getAdministrador();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for(UserDetails User : repositorioDao.getUsuarios()) {
            if (User.getUsername().equals(username)) {
                return User;
            }
        }
        throw new UsernameNotFoundException("El usuario denominado " + username + "no a sido encontrado");
    }

    @Override
    public void cargarMaterial(MaterialEducativo material) {
        repositorioDao.getMaterialEducativo().add(material);
    }
}
