package org.foobarspam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Constraint;

@Entity
@Table(name="usuariorol", uniqueConstraints = @UniqueConstraint(
		columnNames = {"rol", "nombre"}))
public class UsuarioRol {
	@Id
	@GeneratedValue
	@Column(name="userrolid" , unique=true, nullable = false)
	private Integer usuarioRolId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nombre", nullable= false)
	private Usuario usuario;
	@Column(name="rol", nullable = false, length = 45)
	private String rol;
	
	public UsuarioRol(){
		
	}

	public Integer getUsuarioRolId() {
		return usuarioRolId;
	}

	public void setUsuarioRolId(Integer usuarioRolId) {
		this.usuarioRolId = usuarioRolId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public UsuarioRol(Integer usuarioRolId, Usuario usuario, String rol) {
		super();
		this.usuarioRolId = usuarioRolId;
		this.usuario = usuario;
		this.rol = rol;
	}

}
