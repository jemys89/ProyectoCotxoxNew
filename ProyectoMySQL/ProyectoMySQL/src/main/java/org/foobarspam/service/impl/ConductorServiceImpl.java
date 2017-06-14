package org.foobarspam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.foobarspam.converter.ConductorConverter;
import org.foobarspam.entity.Conductor;
import org.foobarspam.model.ConductorModel;
import org.foobarspam.repository.ConductorRepository;
import org.foobarspam.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("conductorServiceImpl")
public class ConductorServiceImpl implements ConductorService{
	
	@Autowired
	@Qualifier("conductorRepository")
	private ConductorRepository conductorRepository;
	
	@Autowired
	@Qualifier("conductorConverter")
	private ConductorConverter conductorConverter;

	@Override
	public List<Conductor> bancoDeConductores() {
		
		return conductorRepository.findAll();
	}

	@Override
	public Conductor añadirConductor(Conductor conductor) {
		
		return conductorRepository.save(conductor);
	}

	@Override
	public int eliminarConductor(int id) {
		conductorRepository.delete(id);
		return 0;
	}

	@Override
	public Conductor modificarConductor(Conductor conductor) {
		
		return conductorRepository.save(conductor);
	}






	@Override
	public boolean existe(String nombre) {
		if(conductorRepository.findByNombre(nombre) == null){
			return false;
		}
		else
			return true;
	
	}

	@Override
	public Conductor conductorLibre() {
		
		return conductorRepository.findFirstByOcupado(false);
	}
	
	@Override
	public Conductor conductorLibreLista() {
		int random = generarConductor();
		bancoDeConductores().get(random).setOcupado(true);
		return bancoDeConductores().get(random);
	}
	
	public int generarConductor(){
		int random = ThreadLocalRandom.current().nextInt(0,bancoDeConductores().size());
		while(bancoDeConductores().get(random).isOcupado()){
			random = ThreadLocalRandom.current().nextInt(0,bancoDeConductores().size());
		}
		return random;
	}


	
	
	public void almacenarValoracion(int id,int valoracion){
		for(Conductor conductor : bancoDeConductores()){
			if(conductor.getId() == id){
				conductor.setValoracion(valoracion);
			}
		}
	}

	@Override
	public Conductor findConductorById(int id) {
		
		return conductorRepository.findById(id);
	}
	
	public ConductorModel findConductorIdModel(int id){
		return conductorConverter.entityAmodel(findConductorById(id));
	}

	@Override
	public void añadirValoracionConductor(ConductorModel conductorModel) {
		// TODO Auto-generated method stub
		
		Conductor conductor = conductorConverter.modelAentity(conductorModel);
		conductorRepository.save(conductor);
		
	}

	
	



	

	
}
	
	
