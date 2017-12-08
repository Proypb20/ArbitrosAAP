package aap.controllers;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import aap.dominio.Torneos;
import aap.dominio.Eventos;
import aap.servicio.Service;

@Controller
public class TournamentController {
	
	public TournamentController(){}
	@Autowired
	public Service service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (Service) ctx.getBean("serviceBean");
	}
	
	@RequestMapping(value ="/GuardarTorneo" , method= {RequestMethod.POST})
	public ModelAndView GuardarTorneo(Torneos torneo)
	{
		ModelAndView MV = new ModelAndView();
		service.insertarTorneo(torneo);
		MV.addObject("Mensaje", "Torneo Guardado Exitosamente");
		MV.addObject("command", new Torneos());
		MV.setViewName("inicio");
		return MV;
	}
	@RequestMapping(value ="/GuardarEvento" , method= {RequestMethod.POST})
	public ModelAndView GuardarEvento(Eventos evento)
	{
		ModelAndView MV = new ModelAndView();
		service.insertarEvento(evento);
		MV.setViewName("inicio");
		MV.addObject("Mensaje", "Evento Guardado Exitosamente");
		return MV;
	}
}
