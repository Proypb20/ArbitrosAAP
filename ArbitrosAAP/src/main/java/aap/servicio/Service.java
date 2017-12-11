package aap.servicio;

import java.util.ArrayList;

import aap.dominio.Usuarios;
import aap.dominio.Torneos;
import aap.dominio.Categorias;
import aap.dominio.Eventos;
import aap.dominio.Presupuestos;
import aap.dominio.TiposUsuario;

public interface Service {

	ArrayList<Usuarios> obtenerUsuarios();
	
	ArrayList<Usuarios> obtenerArbitros(); /*Usuarios que son Arbitros*/

	Usuarios obtenerUsuario(Integer idU);
	
	Usuarios LoginUsuario(String query);
	
	/*public Integer ProximoArbitro(String query);*/

	void insertarUsuario(Usuarios usuario);

	void eliminarUsuario(Integer idU);

	void actualizarUsuario(Usuarios usuario);
	
	void inactivarUsuario(Usuarios usuario);
	
	/**/
	
	ArrayList<Eventos> obtenerEventos();
	
	Eventos obtenerEvento(Integer idEvento);
	
	void insertarEvento(Eventos evento);
	
	void eliminarEvento(Integer idEvento);
	
	void actualizarEvento(Eventos evento);
	
	/**/
	
    ArrayList<Torneos> obtenerTorneos();
	
	Torneos obtenerTorneo(Integer idTorneo);
	
	void insertarTorneo(Torneos torneo);
	
	void eliminarTorneo(Integer idTorneo);
	
	void actualizarTorneo(Torneos torneo);
	
    /**/
	
	ArrayList<Categorias> obtenerCategorias();
	
	Categorias obtenerCategoria(Integer idCategoria);
	
	void insertarCategoria(Categorias categoria);
	
	void eliminarCategoria(Integer idCategoria);
	
	void actualizarCategoria(Categorias categoria);
	
	/**/
	
	ArrayList<TiposUsuario> obtenerTipoUsuario();
	
	TiposUsuario obtenerTiposUsuario(Integer idTipoUsuario);
	
	void insertarTiposUsuario(TiposUsuario tipousuario);
	
	void eliminarTiposUsuario(Integer idTipoUsuario);
	
	void actualizarTiposUsuario(TiposUsuario tipousuario);
	
	/**/
	
	ArrayList<Presupuestos> obtenerPresupuestos(String Estado);
	
	Presupuestos obtenerPresupuesto(Integer idPresupuesto);
	
	void insertarPresupuesto(Presupuestos presupuesto);
	
	void actualizarPresupuesto(Presupuestos presupuesto);
	
	void eliminarPresupuesto(Integer idPresupuesto);
	
}
