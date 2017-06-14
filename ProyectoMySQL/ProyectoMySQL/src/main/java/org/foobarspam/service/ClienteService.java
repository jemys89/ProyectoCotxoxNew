package org.foobarspam.service;

import java.util.List;

import org.foobarspam.entity.Cliente;
import org.foobarspam.model.ClienteModel;

public interface ClienteService {
	
	ClienteModel añadirCliente(ClienteModel clienteModel);
	
	List<ClienteModel> listaCompletaClientes();
	
	Cliente findClienteById(int id);
	
	void removeCliente(int id);
	
	ClienteModel findClienteByIdModel(int id);

}
