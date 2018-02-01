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
	
	@RequestMapping("CrearCategorias.html")
	public ModelAndView redireccioncat(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Categorias());
		MV.setViewName("crearcategorias");
		return MV;
	}
	
	@RequestMapping("/ListarCategorias.html")
	public ModelAndView ListarCategorias(){

		ModelAndView MV = new ModelAndView();
		List<Categorias> categorias = service.obtenerCategorias(); 
		MV.addObject("categorialist", categorias); 
		MV.setViewName("mostrarcategorias");
		return MV;
	}
	@RequestMapping( value="ModifCategorias.html")
	public ModelAndView ModificarCategorias(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("command",new Categorias());
		List<Categorias> categoria = service.obtenerCategorias();
		Categorias categoria2 = new Categorias();
		categoria2.setNombre("Seleccione una categoria");
		categoria.add(0,categoria2);
		MV.addObject("CategoriaList", categoria);
		MV.setViewName("modificarcategoria");
		return MV;
	}
	@RequestMapping( value="ModificarCategoria")
	public ModelAndView ModificarCategoria(Categorias categoria
			                              ,HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		String mensaje = new String();
		service.actualizarCategoria(categoria);
		mensaje = "Categoria Actualizado con Exito";	
		MV.addObject("Mensaje",mensaje);
		MV.setViewName("inicio");
	    return MV;
	}
	@RequestMapping( value="AsignarCategorias.html")
	public ModelAndView AsignarCategorias(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("command",new Usuarios());
		List<Usuarios> usuario = service.obtenerArbitros();
		List<Categorias> categoria = service.obtenerCategorias();
		MV.addObject("UsuarioList", usuario); 
		MV.addObject("CategoriaList", categoria);
		MV.setViewName("asignarcategoria");
		return MV;
	}
	@RequestMapping(value ="/GuardarCategoria" , method= {RequestMethod.POST})
	public ModelAndView GuardarTorneo(Categorias categoria,HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession session = request.getSession();
		categoria.setidCreado((Integer) session.getAttribute("IdU"));
		service.insertarCategoria(categoria);
		MV.addObject("Mensaje", "Categoria Guardada Exitosamente");
		MV.setViewName("inicio");
		return MV;
	}
	
	@RequestMapping(value="/AsignaCategUsuario" ,method= {RequestMethod.POST})
	public ModelAndView AsignaCategUsuario(Usuarios usuario)
	{
		ModelAndView MV = new ModelAndView();
		Usuarios usuario2 = service.obtenerUsuario(usuario.getIdUsuario());
		Categorias categoria = service.obtenerCategoria(usuario.getArbitro().getCategoria().getIdCategoria());
		usuario2.getArbitro().setCategoria(categoria);
		service.actualizarUsuario(usuario2);
		MV.addObject("Mensaje", "Categoria Asignada Exitosamente");
		MV.setViewName("inicio");
		return MV;
	}
}
