package org.foobarspam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Conductor {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="valoracion")
	private double valoracion;
	
	
	@Column(name="ocupado",nullable = false, columnDefinition = "TINYINT(1)")
	private boolean ocupado;
	
	@Column(name="valoracionmedia")
	private double valoracionmedia;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="valoraciones", nullable= false)
	private List<Valoraciones> valoraciones;
	
	
	private ArrayList<Integer> valoracionesConductor = new ArrayList<>();
	
	public ArrayList<Integer> getValoracionesConductor() {
		return valoracionesConductor;
	}

	public void setValoracionesConductor(ArrayList<Integer> valoracionesConductor) {
		this.valoracionesConductor = valoracionesConductor;
	}

	public double getValoracionmedia() {
		return valoracionmedia;
	}

	public void setValoracionmedia(double valoracionmedia) {
		this.valoracionmedia = valoracionmedia;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
		actualizarMedia();
	}


	public Conductor(){
		
	}
	
	public Conductor(String nombre, String matricula, String modelo, double valoracion){
		this.nombre = nombre;
		this.matricula = matricula;
		this.modelo = modelo;
		this.valoracion = valoracion;
		this.valoraciones = new ArrayList<>();
	}
	
	public Conductor(int id, String nombre, String matricula, String modelo, double valoracion) {
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
	public double getValoracionMedia() {
		return valoracion;
	}
	public void setValoracionMedia(double valoracion) {
		this.valoracion = valoracion;
	}
	
	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public void actualizarMedia() {

		double suma = 0.0;

		for (Integer valoracion : this.getValoracionesConductor()) {
			suma += valoracion;
		}
		
		double media = suma / this.getValoracionesConductor().size();
		this.setValoracionMedia(media);
	}



}
