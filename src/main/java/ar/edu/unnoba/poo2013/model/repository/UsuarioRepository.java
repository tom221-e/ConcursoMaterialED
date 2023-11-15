package ar.edu.unnoba.poo2013.model.repository;

import ar.edu.unnoba.poo2013.model.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query
    Usuario findOneByUsername(String nombreUsuario);
    Usuario getById(Long id);
}
