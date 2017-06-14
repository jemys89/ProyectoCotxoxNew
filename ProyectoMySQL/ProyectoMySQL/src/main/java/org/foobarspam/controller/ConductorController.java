package org.foobarspam.controller;

import org.foobarspam.entity.Conductor;
import org.foobarspam.model.ConductorModel;
import org.foobarspam.service.CarreraService;
import org.foobarspam.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/conductor")
public class ConductorController {
	
	private final static String CONDUCTOR_VISTA = "conductor";
	private final static String CONDUCTOR_LIBRE_VISTA = "conductorlibre";
	private final static String CONDUCTOR_VALORACION_VISTA = "conductorvaloracion";
	private final static String CONDUCTOR_PROPINA_VISTA = "conductorpropina";
	
	
	private CarreraService carreraService;
	
	@Autowired
	@Qualifier("conductorServiceImpl")
	private ConductorService conductorService;
	
	
	
	@GetMapping("/conductores")
	public ModelAndView bancoDeConductores(){
		ModelAndView model = new ModelAndView(CONDUCTOR_VISTA);
		model.addObject("conductor",new Conductor());
		model.addObject("conductores",conductorService.bancoDeConductores());
		return model;
	}
	@PostMapping("/añadir")
	public String añadirConductor(@ModelAttribute("conductor")Conductor conductor){
		conductorService.añadirConductor(conductor);
		
		return "redirect:/conductor/conductores";
		
	}
	
	@GetMapping("/libre")
	public ModelAndView conductorLibre(){
		ModelAndView model = new ModelAndView(CONDUCTOR_LIBRE_VISTA);
		
		model.addObject("conductor",conductorService.conductorLibreLista());
		return model;
		
	}
	
	@GetMapping("/valoracion")
	public ModelAndView conductorValoracion(@RequestParam(name="id",required=true)int id){
		ModelAndView model = new ModelAndView(CONDUCTOR_VALORACION_VISTA);
		 
	
		model.addObject("conductor",conductorService.findConductorById(id));
		return model;
		
	}
	
//	/@ModelAttribute("conductor")Conductor conductor
	
	@GetMapping("/propina")
	public ModelAndView conductorPropina(@RequestParam(name="id",required=true)int id){
		ModelAndView model = new ModelAndView(CONDUCTOR_PROPINA_VISTA);
		 ConductorModel conductor = conductorService.findConductorIdModel(id);
		 conductor.setValoracion(conductor.getValoracion());
	
		model.addObject("conductor",conductor);
		return model;
		
	}

}
