package org.foobarspam.repository;

import java.io.Serializable;

import org.foobarspam.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{
	
	Cliente findById(int id);

}
