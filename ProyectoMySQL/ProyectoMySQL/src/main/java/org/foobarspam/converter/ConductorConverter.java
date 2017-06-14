package org.foobarspam.converter;

import org.foobarspam.entity.Conductor;
import org.foobarspam.model.ConductorModel;
import org.springframework.stereotype.Component;

@Component("conductorConverter")
public class ConductorConverter {
	
	public ConductorModel entityAmodel(Conductor conductor){
		ConductorModel conductorModel = new ConductorModel();
		conductorModel.setNombre(conductor.getNombre());
		conductorModel.setMatricula(conductor.getMatricula());
		conductorModel.setModelo(conductor.getMatricula());
		conductorModel.setValoracionmedia(conductor.getValoracion());
		conductorModel.setValoracionesConductor(conductor.getValoracionesConductor());
		
		return conductorModel;
	}
	
	public Conductor modelAentity(ConductorModel conductorModel){
		Conductor conductor = new Conductor();
		conductor.setNombre(conductorModel.getNombre());
		conductor.setMatricula(conductorModel.getMatricula());
		conductor.setModelo(conductorModel.getModelo());
		conductor.setValoracionmedia(conductorModel.getValoracionmedia());
		conductor.setValoracionesConductor(conductorModel.getValoracionesConductor());
		
		return conductor;
	}

}
