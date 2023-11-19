package ar.edu.unnoba.poo2013.model.service;

import ar.edu.unnoba.poo2013.model.model.*;
import ar.edu.unnoba.poo2013.model.repository.MaterialEducativoRepository;
import ar.edu.unnoba.poo2013.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MaterialEducativoRepository materialEducativoRepository;

    public MaterialEducativoRepository getMaterialEducativoRepository(){
        return materialEducativoRepository;
    }
    public  UsuarioRepository getUsuarioRepository(){
        return usuarioRepository;
    }

    @Override
    public void create(Usuario usuario){
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        /*System.out.println(new BCryptPasswordEncoder().encode("12345"));*/
        return (Usuario) usuarioRepository.findOneByUsername(username);

    }

    public List<MaterialEducativo> materialesEducativos(){
        return materialEducativoRepository.findAll();
    }
    public List<MaterialEducativo> materialesEducativosEnRevision(){
        List<MaterialEducativo> matED = new ArrayList<MaterialEducativo>();
        for(MaterialEducativo me : materialEducativoRepository.findAll()){
            if (me.getEstado().equals("Revision")){
                matED.add(me);
            }
        }
        return matED;
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
    public void updateAprobado(Long id){
        MaterialEducativo materialEducativo1=getMaterialEducativoRepository().getById(id);
        materialEducativo1.setAprobado();
        getMaterialEducativoRepository().save(materialEducativo1);
    }
    public void updateRechazado(Long id){
        MaterialEducativo materialEducativo1=getMaterialEducativoRepository().getById(id);
        materialEducativo1.setRechazado();
        getMaterialEducativoRepository().save(materialEducativo1);
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
    public void cargarMaterial(MaterialEducativo material, Usuario usuario) {
        MaterialEducativo nuevoMaterial = materialEducativoRepository.save(material);
        usuario.setMaterialEducativo(nuevoMaterial);
        usuarioRepository.save(usuario);
    }

}

