package ar.edu.unnoba.poo2013.model.repository;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialEducativoRepository extends JpaRepository<MaterialEducativo, Long> {
}