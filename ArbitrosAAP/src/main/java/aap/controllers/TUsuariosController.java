package aap.controllers;

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

import aap.dominio.TiposUsuario;
import aap.servicio.Service;

@Controller
public class TUsuariosController {

	public TUsuariosController(){}
	
	@Autowired
	public Service service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (Service) ctx.getBean("serviceBean");
	}
	
	@RequestMapping("CrearTiposUsuario.html")
	public ModelAndView redirecciontu(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new TiposUsuario());
		MV.setViewName("creartipousuarios");
		return MV;
	}
	
	@RequestMapping(value ="/GuardarTUsuarios" , method= {RequestMethod.POST})
	public ModelAndView GuardarTorneo(TiposUsuario tipousuario,HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession session = request.getSession();
		tipousuario.setidCreado((Integer) session.getAttribute("IdU"));
		service.insertarTiposUsuario(tipousuario);
		MV.addObject("Mensaje", "Categoria Guardada Exitosamente");
		MV.setViewName("inicio");
		return MV;
	}
}