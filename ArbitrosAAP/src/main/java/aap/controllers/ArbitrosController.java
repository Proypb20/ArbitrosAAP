package aap.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import aap.dominio.Arbitros;
import aap.dominio.Usuarios;
import aap.servicio.Service;

@Controller
public class ArbitrosController {
	
	public ArbitrosController(){}
	@Autowired
	public Service service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (Service) ctx.getBean("serviceBean");
	}

	@RequestMapping("/ListarArbitros.html")
	public ModelAndView ListarArbitros(){

		ModelAndView MV = new ModelAndView();
		List<Usuarios> arbitros = service.obtenerArbitros(); 
		MV.addObject("arbitrolist", arbitros); 
		MV.setViewName("mostrararbitros");
		return MV;
	}
	
	@RequestMapping("/Inscribir.html")
	public ModelAndView InscribirArbitros(){

		ModelAndView MV = new ModelAndView();
		
		List<Arbitros> arbitros = new ArrayList<Arbitros>();
		
		MV.addObject("arbitros", arbitros); 
		MV.setViewName("mostrararbitros"); // Redirige a la vista Productos.jsp
		return MV;
	}
}
