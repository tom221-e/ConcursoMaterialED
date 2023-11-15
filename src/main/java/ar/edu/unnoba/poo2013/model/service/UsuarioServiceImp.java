package ar.edu.unnoba.poo2013.model.service;

import ar.edu.unnoba.poo2013.model.model.*;
import ar.edu.unnoba.poo2013.model.repository.MaterialEducativoRepository;
import ar.edu.unnoba.poo2013.model.repository.RepositorioDao;
import ar.edu.unnoba.poo2013.model.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class UsuarioServiceImp implements UsuarioService{
    private UsuarioRepository usuarioRepository;
    private MaterialEducativoRepository materialEducativoRepository;

    @Override
    public void create(Usuario usuario){
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*System.out.println(new BCryptPasswordEncoder().encode("12345"));*/
        return usuarioRepository.findOneByUsername(username);
    }

    public List<MaterialEducativo> materialesEducativos(){
        return materialEducativoRepository.findAll();
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    @Override
    public List<Usuario> getParticipantes() {
        List<Usuario> usuario=new ArrayList<Usuario>();
        for (Usuario User : this.getAllUsuarios()){
            if(User.getTipo().equals("Participante")){
                usuario.add(User);
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> getEvaluador() {
        List<Usuario> usuario=new ArrayList<Usuario>();
        for (Usuario User : this.getAllUsuarios()){
            if(User.getTipo().equals("Evaluador")){
                usuario.add(User);
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> getAdministrador() {
        List<Usuario> usuario=new ArrayList<Usuario>();
        for (Usuario User : this.getAllUsuarios()){
            if(User.getTipo().equals("Administrador")){
                usuario.add(User);
            }
        }
        return usuario;
    }

    @Override
    public void cargarMaterial(MaterialEducativo material) {
        materialEducativoRepository.save(material);
    }


}
