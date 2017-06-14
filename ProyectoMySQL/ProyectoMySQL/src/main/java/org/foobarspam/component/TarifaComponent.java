package org.foobarspam.component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("tarifaComponent")
public class TarifaComponent {
	
	private final double COSTEMILLA = 1.35;
	private final double COSTEMINUTO = 0.35;
	private final double COSTEMINIMO = 5;
	private double distancia;
	private double minutos;
	

	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getMinutos() {
		return minutos;
	}

	public void setMinutos(double minutos) {
		this.minutos = minutos;
	}

	public double getCOSTEMILLA() {
		return COSTEMILLA;
	}

	public double getCOSTEMINUTO() {
		return COSTEMINUTO;
	}

	public double getCOSTEMINIMO() {
		return COSTEMINIMO;
	}
	
	public double getCosteDistancia(double distancia){
		return distancia * COSTEMILLA;
	}
	
	public double getCosteTiempo(double minutos){
		return minutos * COSTEMINUTO;
	}
	
	public double getCosteEsperado(){
		double esperado = getCosteDistancia(distancia) + getCosteTiempo(minutos);
		if (esperado > COSTEMINIMO){
			return esperado;
		}else{
			return COSTEMINIMO;
		}
		
	}

	
	
	

}
