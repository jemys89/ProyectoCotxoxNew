package org.foobarspam.repository;

import java.io.Serializable;

import org.foobarspam.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("conductorRepository")
public interface ConductorRepository extends JpaRepository<Conductor, Serializable>{

	double findByValoracion(Conductor conductor);
	
	boolean findByOcupado(Boolean f);
	
	String findByNombre(String nombre);
	
	Conductor findFirstByOcupado(Boolean f);
	Conductor findById(int id);
}
