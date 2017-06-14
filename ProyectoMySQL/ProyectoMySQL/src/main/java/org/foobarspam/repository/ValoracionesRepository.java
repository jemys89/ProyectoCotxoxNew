package org.foobarspam.repository;

import java.io.Serializable;

import org.foobarspam.entity.Valoraciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("valoracionesRepository")
public interface ValoracionesRepository extends JpaRepository<Valoraciones, Serializable>{

}
