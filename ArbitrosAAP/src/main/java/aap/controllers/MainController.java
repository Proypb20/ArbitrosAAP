package aap.controllers;

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
	@RequestMapping("inicio.html")
	public ModelAndView redireccionin(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("inicio");
		return MV;
	}

}
