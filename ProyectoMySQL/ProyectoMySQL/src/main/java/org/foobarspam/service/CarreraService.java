package org.foobarspam.service;

import org.foobarspam.component.TarifaComponent;
import org.foobarspam.entity.Cliente;
import org.foobarspam.entity.Conductor;
import org.foobarspam.model.ClienteModel;
import org.foobarspam.repository.ConductorRepository;
import org.foobarspam.repository.ValoracionesRepository;
import org.foobarspam.service.impl.ConductorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("carreraService")
public class CarreraService {

	private ConductorRepository conductorRepository;
	private ValoracionesRepository valoraciones;
	
	private ConductorService conductorService;
	private ConductorServiceImpl conductorServiceImpl;

	private TarifaComponent tarifaComponent;
	private Cliente cliente;
	private ClienteModel clienteModel;
	private Conductor conductor;

	private String origen;
	private String destino;

	private String tarjetaCredito = null;

	private double costeTotal;

	@Autowired
	public CarreraService(ConductorRepository poolConductores, ValoracionesRepository valoraciones) {
		this.conductorRepository = conductorRepository;
		this.valoraciones = valoraciones;
	}

	@Autowired
	public void setTarifa(TarifaComponent tarifa) {
		this.tarifaComponent = tarifa;
	}

	public double getCosteEsperado() {
		return tarifaComponent.getCosteEsperado();
	}

	public double getDistancia() {
		return tarifaComponent.getDistancia();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDistancia(Cliente cliente) {

		tarifaComponent.setDistancia(cliente.getDistancia());
	}

	/* Sobrecarga de Cliente */
	public void setDistancia(ClienteModel clienteModel) {

		tarifaComponent.setDistancia(clienteModel.getDistancia());
	}

	public void setTiempoEsperado(Cliente cliente) {
		this.tarifaComponent.setMinutos(cliente.getTiempo());
	}

	public void setTiempoEsperado(ClienteModel clienteModel) {
		this.tarifaComponent.setMinutos(clienteModel.getTiempo());
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

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public void setCliente(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public ConductorRepository getConductorRepository() {
		return this.conductorRepository;
	}

	public ValoracionesRepository getValoracionesRepository() {
		return this.valoraciones;
	}

	/* Asignar un Conductor libre */
	public Conductor asignarConductor() {
		this.conductor = conductorServiceImpl.conductorLibreLista();
		setConductor(conductor);
		return conductor;

	}
	
	

}
