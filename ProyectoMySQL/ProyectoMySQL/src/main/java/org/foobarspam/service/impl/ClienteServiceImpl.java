package org.foobarspam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.foobarspam.component.ClienteConverter;
import org.foobarspam.entity.Cliente;
import org.foobarspam.model.ClienteModel;
import org.foobarspam.repository.ClienteRepository;
import org.foobarspam.service.CarreraService;
import org.foobarspam.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	@Autowired
	@Qualifier("carreraService")
	private CarreraService carreraService;

	@Override
	public ClienteModel añadirCliente(ClienteModel clienteModel) {
		// TODO Auto-generated method stub
		carreraService.setCliente(clienteModel);
		carreraService.setDistancia(clienteModel);
		carreraService.setTiempoEsperado(clienteModel);
		double total = carreraService.getCosteEsperado();
		clienteModel.setTotal(total);
		Cliente cliente = clienteRepository.save(clienteConverter.modelAentity(clienteModel));

		return clienteConverter.entityAmodel(cliente);
	}

	@Override
	public List<ClienteModel> listaCompletaClientes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteModel> clientesModel = new ArrayList<ClienteModel>();
		for(Cliente cliente : clientes){
			clientesModel.add(clienteConverter.entityAmodel(cliente));
		}
		return clientesModel;
	}

	@Override
	public Cliente findClienteById(int id) {
		// TODO Auto-generated method stub
		
		
		return clienteRepository.findById(id);
	}
	
	public ClienteModel findClienteByIdModel(int id){
		return clienteConverter.entityAmodel(findClienteById( id));
	}

	@Override
	public void removeCliente(int id) {
		// TODO Auto-generated method stub
		Cliente cliente = findClienteById(id);
		if(cliente != null){
			clienteRepository.delete(cliente);
		}
		
		
	}

}
