package org.foobarspam.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="nombre", unique = true, nullable = false, length=45)
	private String nombre;
	
	@Column(name="contraseña", nullable = false, length= 60)
	private String contraseña;
	
	@Column(name="disponible", nullable = false)
	private boolean disponible;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="usuario")
	private Set <UsuarioRol> usuarioRol = new HashSet<UsuarioRol>();
	
	public Usuario(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Set<UsuarioRol> getUsuarioRol() {
		return usuarioRol;
	}

	public void setUsuarioRol(Set<UsuarioRol> usuarioRol) {
		this.usuarioRol = usuarioRol;
	}

	public Usuario(String nombre, String contraseña, boolean disponible) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.disponible = disponible;
	}

	public Usuario(String nombre, String contraseña, boolean disponible, Set<UsuarioRol> usuarioRol) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.disponible = disponible;
		this.usuarioRol = usuarioRol;
	} 

}
