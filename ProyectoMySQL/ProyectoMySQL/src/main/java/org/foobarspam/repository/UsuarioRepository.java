package org.foobarspam.repository;

import java.io.Serializable;

import org.foobarspam.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	Usuario findByNombre(String nombre);
}
