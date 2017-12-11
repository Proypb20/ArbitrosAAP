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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import aap.dominio.Usuarios;
import aap.dominio.Arbitros;
import aap.dominio.TiposUsuario;
import aap.servicio.Service;

@Controller
public class UserController {
	
	public UserController(){}
	@Autowired
	public Service service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (Service) ctx.getBean("serviceBean");
	}
	
	@RequestMapping("CrearUsuario.html")
	public ModelAndView redireccionus(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Usuarios());
		List<TiposUsuario> tipousuarios = service.obtenerTipoUsuario();
		MV.addObject("TipoUsuarioList", tipousuarios);
		MV.setViewName("crearuser");
		return MV;
	}
	@RequestMapping("EliminarUsuarios.html")
	public ModelAndView redireccioneus(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("command", new Usuarios());
		List<Usuarios> usuario = service.obtenerUsuarios();
		MV.addObject("UsuarioList", usuario);
		MV.setViewName("eliminaruser");
		return MV;
	}
	
	@RequestMapping(value ="/BuscarUsuario" , method= {RequestMethod.POST})
	public ModelAndView BuscarUsuario(HttpServletRequest request,Usuarios user)
	{
		ModelAndView MV = new ModelAndView();
		
		String nombre = "";
		try
		{
		Usuarios usuario = service.LoginUsuario("from Usuarios where usuario = '"+user.getUsuario()+"' and contrasena = '"+user.getContrasena()+"' and estado = 'A'");
		
		if ( usuario != null)
		{
			MV.setViewName("inicio");			 
			HttpSession session = request.getSession();
			session.setAttribute("IdU", usuario.getIdUsuario());
			session.setAttribute("idTu", usuario.getTipousuario().getIdTipoUsuario());
			session.setAttribute("IdName", usuario.getApellido() + ", " + usuario.getNombre());
		}
		else
		{
			MV.setViewName("index");
			MV.addObject("Mensaje", "Usuario y/o Contrasena incorrecta");
			MV.addObject("command", new Usuarios());
		}
		return MV;
		
		}
		catch (Exception e)
		{
			nombre = e.getMessage();
			MV.setViewName("index");
			MV.addObject("Mensaje", nombre);
			MV.addObject("command", new Usuarios());
			return MV;
		}
	}
	
	public boolean ValidarUsuario(Usuarios user)
	{
		Integer Iu = 0;
		try
		{
			Usuarios usuario = service.LoginUsuario("from Usuarios where usuario = '"+user.getUsuario()+"' and contrasena = '"+user.getContrasena()+"'");
			Iu = usuario.getIdUsuario();
			if (Iu!=0)
				return true;
			else
				return false;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	@RequestMapping(value ="/ActualizarUsuario" , method= {RequestMethod.POST})
	public ModelAndView ActualizarUsuario(Usuarios user,
			       HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		String mensaje = new String();
		HttpSession session = request.getSession();
		if ((Integer)session.getAttribute("IdU") != null)
		{
			user.setIdUsuario((Integer)session.getAttribute("IdU"));
			service.actualizarUsuario(user);
		    mensaje = "Usuario Actualizado con Exito";
			MV.addObject("command", new Usuarios());
			MV.addObject("Mensaje",mensaje);
			MV.setViewName("inicio");
			return MV;
		}
		return MV;
	}
	@RequestMapping(value ="/GuardarUsuario" , method= {RequestMethod.POST})
	public ModelAndView GuardarUsuario(Usuarios user,
			       @RequestParam(value="arbitra", required=false) String arbitra,
			       @RequestParam(value="nroarb", required=false) String NroArbitro,
			       HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		String mensaje = new String();
		HttpSession session = request.getSession();
		
		 if (!ValidarUsuario(user))
		 {
			 if (user.getTipousuario().getIdTipoUsuario() == 0)
					 {
				 		mensaje = "Debe Ingresar un tipo de Usuario";
				 		MV.addObject("Mensaje",mensaje);
						MV.setViewName("crearuser");
						return MV;
					 }
			 else
			 {
				if (arbitra!="N")
				{
					Arbitros arbitro = new Arbitros();
					arbitro.setNroArbitro(Integer.parseInt(NroArbitro));
					user.setArbitro(arbitro);
					mensaje = "Arbitro creado con Exito";
				}
				service.insertarUsuario(user);
			    mensaje = "Usuario creado con Exito";
				MV.addObject("command", new Usuarios());
				MV.addObject("Mensaje",mensaje);
				if ((Integer)session.getAttribute("IdU") == null)
				MV.setViewName("index");
				else
					MV.setViewName("inicio");
				return MV;
			 }
		 }
		 else
		 {
			    MV.addObject("command", new Usuarios());
			    mensaje = "El usuario ya existe";
				MV.addObject("Mensaje",mensaje);
				MV.setViewName("crearuser");
				return MV;
		 }
	}
	@RequestMapping("MostrarUsuarios.html")
	public ModelAndView ListarUsuarios()
	{
		ModelAndView MV = new ModelAndView();
		List<Usuarios> listausuarios = service.obtenerUsuarios(); 
		MV.addObject("usuariolist", listausuarios); 
		MV.setViewName("mostrarusuarios");
		return MV;
	}
	
	@RequestMapping( value="Modusuario.html", method = {RequestMethod.GET})
	public ModelAndView ModificarUsuario(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession session = request.getSession();
		Usuarios usuario = service.obtenerUsuario((Integer) session.getAttribute("IdU"));
		MV.addObject("usuariom", usuario); 
		MV.setViewName("modificarusuario");
		return MV;
	}
	
	@RequestMapping ( value="EliminarUsuario.html", method = {RequestMethod.POST})
	public ModelAndView EliminarUsuario(Usuarios usuario)
	{
		ModelAndView MV = new ModelAndView();
		String mensaje = new String();
		Usuarios usuario2 = new Usuarios();
		usuario2 = service.obtenerUsuario(usuario.getIdUsuario());
		usuario2.setEstado("I");
		service.inactivarUsuario(usuario2);
	    mensaje = "Usuario Dado de Baja con Exito";
		MV.addObject("Mensaje",mensaje);
		MV.setViewName("inicio");
		return MV;
	}
	
	@RequestMapping("/listarArbitros.html")
	public ModelAndView ListarArbitros(){

		ModelAndView MV = new ModelAndView();
		List<Usuarios> arbitros = service.obtenerArbitros(); 
		MV.addObject("arbitrolist", arbitros); 
		MV.setViewName("mostrararbitros");
		return MV;
	}
}
