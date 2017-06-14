package org.foobarspam.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="valoraciones")
public class Valoraciones {
	
	@Id
	@GeneratedValue
	private double idValoracion;
	
	private double valoracion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nombre", nullable= false)
	private Conductor conductor;
	
	public Valoraciones(){
		
	}
	@Autowired
	public Valoraciones(double valoracion,  Conductor conductor){
		this.conductor = conductor;
	
		this.valoracion = valoracion;
	}
	
	public double getValoracion(){
		return valoracion;
	}
	
	public void setValoracion(double valoracion){
		this.valoracion = valoracion;
	}
	
	

}
