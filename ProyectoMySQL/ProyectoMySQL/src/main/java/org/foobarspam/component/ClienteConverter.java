package org.foobarspam.component;

import org.foobarspam.entity.Cliente;
import org.foobarspam.model.ClienteModel;
import org.springframework.stereotype.Component;

@Component("clienteConverter")
public class ClienteConverter {
	
	public Cliente modelAentity(ClienteModel clienteModel){
		Cliente cliente = new Cliente();
		cliente.setDni(clienteModel.getDni());
		cliente.setNombre(clienteModel.getNombre());
		cliente.setDestino(clienteModel.getDestino());
		cliente.setDistancia(clienteModel.getDistancia());
		cliente.setTiempo(clienteModel.getTiempo());
		cliente.setTotal(clienteModel.getTotal());
		
		return cliente;
	}
	
	public ClienteModel entityAmodel(Cliente cliente){
		ClienteModel clienteModel = new ClienteModel();
		clienteModel.setNombre(cliente.getNombre());
		clienteModel.setDni(cliente.getDni());
		clienteModel.setDestino(cliente.getDestino());
		clienteModel.setDistancia(cliente.getDistancia());
		clienteModel.setTiempo(cliente.getTiempo());
		clienteModel.setTotal(cliente.getTotal());
		
		return clienteModel;
	}

}
