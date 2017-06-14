package org.foobarspam.model;

import java.util.ArrayList;

import javax.persistence.Column;

public class ConductorModel {
	
private int id;
	
	
	private String nombre;
	
	private ArrayList<Integer> valoracionesConductor = new ArrayList<>();
	public ArrayList<Integer> getValoracionesConductor() {
		return valoracionesConductor;
	}

	public void setValoracionesConductor(ArrayList<Integer> valoracionesConductor) {
		this.valoracionesConductor = valoracionesConductor;
	}
	private String matricula;
	
	
	private String modelo;
	

	private double valoracion;
	
	private boolean ocupado;
	
	private double valoracionmedia;
	

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public ConductorModel(){
		
	}
	
	public ConductorModel(int id, String nombre, String matricula, String modelo, double valoracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.matricula = matricula;
		this.modelo = modelo;
		this.valoracion = valoracion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getValoracionmedia() {
		return valoracion;
	}
	public void setValoracionmedia(double valoracion) {
		this.valoracion = valoracion;
	}
}
