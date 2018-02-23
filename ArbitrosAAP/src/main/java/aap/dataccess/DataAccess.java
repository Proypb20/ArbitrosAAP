package aap.dataccess;

import java.util.ArrayList;

import aap.dominio.*;

public interface DataAccess {
	
	public Usuarios LoginUsuario(String query);
	
	public Integer ProximoArbitro(String query);

	public void insertarUsuario(Usuarios usuario);
	
	public Integer obteneridArbitro(Integer IdU);
	
	public Usuarios obtenerUsuario(Integer IdU);

	public ArrayList<Usuarios> obtenerUsuarios();
	
	public ArrayList<Usuarios> obtenerArbitros();

	public void eliminarUsuario(Integer IdU);

	public void actualizarUsuario(Usuarios usuario);
	
	public void inactivarUsuario(Usuarios usuario);
	
    /**/
	
	ArrayList<Eventos> obtenerEventos();
	
	ArrayList<Eventos> obtenerEventosT(Integer idTorneo);
	
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
	
	ArrayList<TiposUsuario> obtenerTiposUsuario();
	
	TiposUsuario obtenerTipoUsuario(Integer idTipoUsuario);
	
	void insertarTiposUsuario(TiposUsuario tipousuario);
	
	void eliminarTiposUsuario(Integer idTipoUsuario);
	
	void actualizarTiposUsuario(TiposUsuario tipousuario);
	
	/**/
	
	ArrayList<Presupuestos> obtenerPresupuestosE(String Estado);
	
	ArrayList<Presupuestos> obtenerPresupuestosEA(Integer idEvento,Integer idArbitro);
	
	ArrayList<Presupuestos> obtenerPresupuestosEv(Integer idEvento);
	
	ArrayList<Presupuestos> obtenerPresupuestosA(Integer idArbitro);
	
	ArrayList<Presupuestos> obtenerPresupuestos(Integer idEvento);
	
	Presupuestos obtenerPresupuesto(Integer idPresupuesto);
	
	void insertarPresupuesto(Presupuestos presupuesto);
	
	void actualizarPresupuesto(Presupuestos presupuesto);
	
	void eliminarPresupuesto(Integer idPresupuesto);
}