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

    public List<MaterialAprovado> materialAprovados(){
        repositorioDao.getMaterialAprovado();
    }


    @Override
    public List<Participante> getParticipantes() {
        return repositorioDao.getParticipante();
    }

    @Override
    public List<Evaluador> getEvaluador() {
        return repositorioDao.getEvaluador();
    }

    @Override
    public List<Administrador> getAdministrador() {
        return repositorioDao.getAdministrador();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for(UserDetails User : repositorioDao.getParticipante()){
            if (User.getUsername().equals(username)) {
                return User;
            }
        }
        for(UserDetails User : repositorioDao.getAdministrador()){
            if (User.getUsername().equals(username)) {
                return User;
            }
        }
        for(UserDetails User : repositorioDao.getEvaluador()){
            if (User.getUsername().equals(username)) {
                return User;
            }
        }
        throw new UsernameNotFoundException("El usuario denominado " + username + "no a sido encontrado");
    }

    @Override
    public void meGusta(MaterialAprovado material) {
        repositorioDao.buscar(material).meGusta();
    }

    @Override
    public void cargarMaterial() {

    }

    @Override
    public Integer getMeGusta() {
        return null;
    }
}
