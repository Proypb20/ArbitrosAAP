package aap.controllers;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value ="/GuardarTorneo" , method= {RequestMethod.POST})
	public ModelAndView GuardarTorneo(Torneos torneo,HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession session = request.getSession();
		torneo.setIdCreado((Integer) session.getAttribute("IdU"));
		service.insertarTorneo(torneo);
		MV.addObject("Mensaje", "Torneo Guardado Exitosamente");
		MV.addObject("command", new Torneos());
		MV.setViewName("inicio");
		return MV;
	}
	@RequestMapping(value ="/GuardarEvento" , method= {RequestMethod.POST})
	public ModelAndView GuardarEvento(Eventos evento,HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession session = request.getSession();
		evento.setIdCreado((Integer) session.getAttribute("IdU"));
		service.insertarEvento(evento);
		MV.setViewName("inicio");
		MV.addObject("Mensaje", "Evento Guardado Exitosamente");
		return MV;
	}
}
