package org.foobarspam.service;

import java.util.List;

import org.foobarspam.entity.Conductor;
import org.foobarspam.model.ConductorModel;


public interface ConductorService {
	
	
	List<Conductor> bancoDeConductores();
	
	Conductor añadirConductor(Conductor conductor);
	
	int eliminarConductor(int id);
	
	Conductor modificarConductor(Conductor conductor);
	
	Conductor findConductorById(int id);
	
	
	 boolean existe(String nombre);
	 
	 Conductor conductorLibre();

	Conductor conductorLibreLista();
	
	ConductorModel findConductorIdModel(int id);
	
	void añadirValoracionConductor(ConductorModel conductorModel);
	
	 
}
