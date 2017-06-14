package org.foobarspam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ClienteController {
	
//	@GetMapping("/")
//	public String redireccionarAlLogin(){
//		return "redirect:/login";
//	}
//	
	@GetMapping("/login")
	public String muestraLogin(Model model,
						@RequestParam(name="error",required=false)String error,
						@RequestParam(name="logout",required=false)String logout){
		
		
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
//		model.addAttribute("cliente",new Cliente());
		return "login";
	}
	
	@GetMapping({"/loginsuccess","/"})
	public String checkearLogin(){
		
			return "redirect:/contacts/muestraclientes";
		
	}

}
