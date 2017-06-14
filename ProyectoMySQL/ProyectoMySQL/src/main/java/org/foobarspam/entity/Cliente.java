package org.foobarspam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="origen")
	private String origen;
	
	@Column(name="destino")
	private String destino;
	
	@Column(name="distancia")
	private double distancia;
	
	@Column(name="tiempo")
	private double tiempo;
	
	@Column(name="total")
	private double total;
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente(String origen, String destino, double distancia, double tiempo) {
		super();
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return this.distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public Cliente(){
		
	}
	
	public Cliente(String nombre, String dni){
		this.origen = nombre;
		this.destino = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return origen;
	}

	public void setNombre(String nombre) {
		this.origen = nombre;
	}

	public String getDni() {
		return destino;
	}

	public void setDni(String dni) {
		this.destino = dni;
	}

}
