package aap.controllers;

import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import aap.dominio.*;
import aap.servicio.Service;

@Controller
public class MainController {
	
	public MainController(){}
	@Autowired
	public Service service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (Service) ctx.getBean("serviceBean");
	}

	@RequestMapping("index.html")
	public ModelAndView redireccion(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Usuarios());
		MV.setViewName("index");
		return MV;
	}
	@RequestMapping("CrearUsuario.html")
	public ModelAndView redireccionus(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Usuarios());
		MV.setViewName("crearuser");
		return MV;
	}
	@RequestMapping("CrearTorneo.html")
	public ModelAndView redirecciontor(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Torneos());
		MV.setViewName("creartorneo");
		return MV;
	}
	@RequestMapping("CrearEvento.html")
	public ModelAndView redireccionev(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Eventos());
		List<Torneos> torneos = service.obtenerTorneos();
		MV.addObject("TorneoList", torneos);
		MV.setViewName("crearevento");
		return MV;
	}
	@RequestMapping("CrearCategorias.html")
	public ModelAndView redireccioncat(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Categorias());
		MV.setViewName("crearcategorias");
		return MV;
	}
	@RequestMapping("CrearTiposUsuario.html")
	public ModelAndView redirecciontu(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new TiposUsuario());
		MV.setViewName("creartipousuarios");
		return MV;
	}
	@RequestMapping("inicio.html")
	public ModelAndView redireccionin(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("inicio");
		return MV;
	}
	@RequestMapping("Inscribirse.html")
	public ModelAndView redireccionins(){
		ModelAndView MV = new ModelAndView();
		List<Torneos> torneo = service.obtenerTorneos();
		MV.addObject("TorneoList", torneo);
		List<Eventos> evento = service.obtenerEventos();
		MV.addObject("EventoList", evento);
		MV.addObject("command",new Presupuestos());
		MV.setViewName("inscripcion");
		return MV;
	}
}
