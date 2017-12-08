package aap.controllers;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import aap.dominio.Categorias;
import aap.dominio.Usuarios;
import aap.servicio.Service;

@Controller
public class CategoryController {
	
	public CategoryController(){}
	@Autowired
	public Service service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (Service) ctx.getBean("serviceBean");
	}
	
	@RequestMapping("/ListarCategorias.html")
	public ModelAndView ListarCategorias(){

		ModelAndView MV = new ModelAndView();
		List<Categorias> categorias = service.obtenerCategorias(); 
		MV.addObject("categorialist", categorias); 
		MV.setViewName("mostrarcategorias");
		return MV;
	}
	@RequestMapping( value="modificarcategorias.html")
	public ModelAndView ModificarCategorias(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		List<Usuarios> usuario = service.obtenerUsuarios();
		List<Categorias> categoria = service.obtenerCategorias();
		MV.addObject("usuariom", usuario); 
		MV.addObject("categoriam", categoria);
		MV.setViewName("modificarcategoria");
		return MV;
	}
}
