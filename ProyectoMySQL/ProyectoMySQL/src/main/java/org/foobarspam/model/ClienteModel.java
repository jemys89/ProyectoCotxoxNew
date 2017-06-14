package org.foobarspam.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ClienteModel {
	
	
	
	private int id;
	
	
	private String origen;
	
	
	private String destino;
	
	
	private double distancia;
	
	
	private double tiempo;
	
	private double total;
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ClienteModel(String origen, String destino, double distancia, double tiempo) {
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
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public ClienteModel(){
		
	}
	
	public ClienteModel(String nombre, String dni){
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