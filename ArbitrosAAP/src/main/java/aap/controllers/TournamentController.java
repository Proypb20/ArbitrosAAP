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

import aap.dominio.Eventos;
import aap.dominio.Presupuestos;
import aap.dominio.Torneos;
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
	@RequestMapping("Inscribirse.html")
	public ModelAndView redireccionins(HttpServletRequest request){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command",new Presupuestos());
		List<Torneos> torneo = service.obtenerTorneos();
		MV.addObject("TorneoList", torneo);
		List<Eventos> evento = service.obtenerEventos();
		MV.addObject("EventoList", evento);
		HttpSession session = request.getSession();
		MV.addObject("idArbitro",service.obteneridArbitro((Integer) session.getAttribute("IdU")));
		MV.setViewName("inscripcion");
		return MV;
	}

	@RequestMapping(value ="Inscribir.html" , method= {RequestMethod.POST})
	public ModelAndView InscribirArbitros(Presupuestos presupuesto,HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession session = request.getSession();
		presupuesto.setIdCreado((Integer) session.getAttribute("IdU"));
		service.insertarPresupuesto(presupuesto);
		MV.addObject("Mensaje","Inscripcion realizada correctamente");
		MV.setViewName("inicio");
		return MV;
	}
	
	@RequestMapping(value = "MostrarPresupuestosN.html")
	public ModelAndView ListarPresupuestosN(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("command",new Presupuestos());
		List<Eventos> eventos = service.obtenerEventos();
		MV.addObject("EventoList", eventos);
		HttpSession session = request.getSession();
		MV.addObject("idArbitro",service.obteneridArbitro((Integer) session.getAttribute("IdU")));
		MV.setViewName("mostrarpresupuestoE");
		return MV;
	}
	
	@RequestMapping(value = "MostrarPresupuestosT.html")
	public ModelAndView ListarPresupuestosT(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession session = request.getSession();
		List<Presupuestos> presupuesto = service.obtenerPresupuestosA(service.obteneridArbitro((Integer) session.getAttribute("IdU")));
		MV.addObject("PresupuestoList", presupuesto);
		MV.setViewName("mostrarpresupuesto");
		return MV;
	}
	
	@RequestMapping(value = "ListarPres.html")
	public ModelAndView ListarPresupuestos(Presupuestos presu)
	{
		ModelAndView MV = new ModelAndView();
		List<Presupuestos> presupuesto = service.obtenerPresupuestosEv(presu.getEvento().getIdEvento()
				                                                      ,presu.getArbitro().getIdArbitro());
		MV.addObject("PresupuestoList", presupuesto);
		MV.setViewName("mostrarpresupuesto");
		return MV;
	}
	
	@RequestMapping(value = "ModificarPresupuesto.html")
	public ModelAndView ModificarPresupuesto()
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("command",new Presupuestos());
		List<Presupuestos> presupuesto = service.obtenerPresupuestosE("N"); 
		MV.addObject("PresupuestoList", presupuesto); 
		MV.setViewName("modificarpresupuesto");
		return MV;
	}
	
	@RequestMapping(value = "EliminarPresupuesto.html")
	public ModelAndView EliminarPresupuesto(Presupuestos presupuesto)
	{
		ModelAndView MV = new ModelAndView();
		service.eliminarPresupuesto(presupuesto.getIdPresupuesto()); 
		MV.addObject("Mensaje", "Presupuesto Modificado correctamente"); 
		MV.setViewName("inicio");
		return MV;
	}
}
