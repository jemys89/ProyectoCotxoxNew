package org.foobarspam.controller;

import org.foobarspam.entity.Cliente;
import org.foobarspam.model.ClienteModel;
import org.foobarspam.service.CarreraService;
import org.foobarspam.service.ClienteService;
import org.foobarspam.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/contacts")
public class RegistrarController {
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	
	private CarreraService carreraService;
	
	@GetMapping("/cancel")
	public String cancelarRegistro(){
		return "redirect:/contacts/muestraclientes";
	}
	
//	@PreAuthorize("permitAll()")
	@GetMapping("/contactform")
	public String redirectRegistrar(@RequestParam (name="id",required = true)int id,
			Model model){
		ClienteModel cliente = new ClienteModel();
		if(id != 0){
			cliente = clienteService.findClienteByIdModel( id);
		}
		model.addAttribute("clienteModel",cliente);
		return "contactform";
	}
	
	@PostMapping("/añadircliente")
	public String añadirCliente(@ModelAttribute(name="clienteModel") ClienteModel clienteModel,
	Model model){
		
		
		if(null != clienteService.añadirCliente(clienteModel)){
			model.addAttribute("result",1);
		}else{
			model.addAttribute("result",0);
		}
		
		return "redirect:/contacts/muestraclientes";
	}
	@GetMapping("/muestraclientes")
	public ModelAndView muestraClientes(){
		ModelAndView model = new ModelAndView("contacts");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addObject("username",user.getUsername());
		
		model.addObject("clientes", clienteService.listaCompletaClientes());
		
		return model;
	}
	
	@GetMapping("/eliminarcliente")
	public ModelAndView eliminarContacto(@RequestParam (name="id",required = true)int id){
		clienteService.removeCliente(id);
		
		return muestraClientes();
	}

	

}
