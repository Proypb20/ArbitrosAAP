package aap.servicio.impl;

import java.util.ArrayList;

import aap.dataccess.DataAccess;
import aap.servicio.Service;
import aap.dominio.*;

public class ServiceBasico implements Service {

	private DataAccess dataAccess = null;

	public DataAccess getDataAccess() {
		return dataAccess;
	}

	public void setDataAccess(DataAccess dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public ArrayList<Usuarios> obtenerUsuarios() {
		return this.dataAccess.obtenerUsuarios();
	}


	@Override
	public ArrayList<Usuarios> obtenerArbitros() {
		return this.dataAccess.obtenerArbitros();
	}
	
	@Override
	public Usuarios obtenerUsuario(Integer idU) {
		return dataAccess.obtenerUsuario(idU);
	}

	@Override
	public Integer obteneridArbitro(Integer IdU){
		return dataAccess.obteneridArbitro(IdU);
	}
	
	@Override
	public Usuarios LoginUsuario(String query) {
		return dataAccess.LoginUsuario(query);
	}
	/*
	public Integer ProximoArbitro(String query) {
		return dataAccess.ProximoArbitro(query);
	}*/

	public void insertarUsuario(Usuarios usuario) {
		dataAccess.insertarUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(Integer idU) {
		dataAccess.eliminarUsuario(idU);
	}

	@Override
	public void actualizarUsuario(Usuarios usuario) {
		dataAccess.actualizarUsuario(usuario);
	}
	
	@Override
	public void inactivarUsuario(Usuarios usuario) {
		dataAccess.inactivarUsuario(usuario);
	}

	@Override
	public ArrayList<Eventos> obtenerEventos() {
		return this.dataAccess.obtenerEventos();
	}
	
	@Override
	public ArrayList<Eventos> obtenerEventosT(Integer idTorneo) {
		return this.dataAccess.obtenerEventosT(idTorneo);
	}

	@Override
	public Eventos obtenerEvento(Integer idEvento) {
		return dataAccess.obtenerEvento(idEvento);
	}

	@Override
	public void insertarEvento(Eventos evento) {
		dataAccess.insertarEvento(evento);
	}

	@Override
	public void eliminarEvento(Integer idEvento) {
		dataAccess.eliminarEvento(idEvento);
	}

	@Override
	public void actualizarEvento(Eventos evento) {
		dataAccess.actualizarEvento(evento);
		
	}

	@Override
	public ArrayList<Torneos> obtenerTorneos() {
		return this.dataAccess.obtenerTorneos();
	}

	@Override
	public Torneos obtenerTorneo(Integer idTorneo) {
		return dataAccess.obtenerTorneo(idTorneo);
	}

	@Override
	public void insertarTorneo(Torneos torneo) {
		dataAccess.insertarTorneo(torneo);
	}

	@Override
	public void eliminarTorneo(Integer idTorneo) {
		dataAccess.eliminarTorneo(idTorneo);
	}

	@Override
	public void actualizarTorneo(Torneos torneo) {
		dataAccess.actualizarTorneo(torneo);
	}
	

	@Override
	public ArrayList<Categorias> obtenerCategorias() {
		return this.dataAccess.obtenerCategorias();
	}
	
	@Override
	public Categorias obtenerCategoria(Integer idCategoria) {
		return this.dataAccess.obtenerCategoria(idCategoria);
	}
	
	@Override
	public void insertarCategoria(Categorias categoria) {
		dataAccess.insertarCategoria(categoria);
	}
	
	@Override
	public void eliminarCategoria(Integer idCategoria) {
		dataAccess.eliminarCategoria(idCategoria);
	}

	@Override
	public void actualizarCategoria(Categorias categoria) {
		dataAccess.actualizarCategoria(categoria);
	}
	
	@Override
	public ArrayList<TiposUsuario> obtenerTipoUsuario() {
		return this.dataAccess.obtenerTiposUsuario();
	}
	
	@Override
	public TiposUsuario obtenerTiposUsuario(Integer idTipoUsuario) {
		return this.dataAccess.obtenerTipoUsuario(idTipoUsuario);
	}
	
	@Override
	public void insertarTiposUsuario(TiposUsuario tipousuario) {
		dataAccess.insertarTiposUsuario(tipousuario);
	}
	
	@Override
	public void eliminarTiposUsuario(Integer idTipoUsuario) {
		dataAccess.eliminarTiposUsuario(idTipoUsuario);
	}
	@Override
	public void actualizarTiposUsuario(TiposUsuario tipousuario) {
		dataAccess.actualizarTiposUsuario(tipousuario);
	}
	
	@Override
	public ArrayList<Presupuestos> obtenerPresupuestos(Integer idUsuario)
	{
		return this.dataAccess.obtenerPresupuestos(idUsuario);
	}
	
	@Override
	public ArrayList<Presupuestos> obtenerPresupuestosEA(Integer idEvento,Integer idArbitro)
	{
		return this.dataAccess.obtenerPresupuestosEA(idEvento,idArbitro);
	}
	
	@Override
	public ArrayList<Presupuestos> obtenerPresupuestosEv(Integer idEvento)
	{
		return this.dataAccess.obtenerPresupuestosEv(idEvento);
	}
	@Override
	public ArrayList<Presupuestos> obtenerPresupuestosA(Integer idArbitro)
	{
		return this.dataAccess.obtenerPresupuestosA(idArbitro);
	}
	
	@Override
	public ArrayList<Presupuestos> obtenerPresupuestosE(String estado)
	{
		return this.dataAccess.obtenerPresupuestosE(estado);
	}
	
	@Override
	public Presupuestos obtenerPresupuesto(Integer idPresupuesto)
	{
		return this.dataAccess.obtenerPresupuesto(idPresupuesto);
	}
	
	@Override
	public void insertarPresupuesto(Presupuestos presupuesto)
	{
		dataAccess.insertarPresupuesto(presupuesto);
	}
	
	@Override
	public void actualizarPresupuesto(Presupuestos presupuesto)
	{
		dataAccess.actualizarPresupuesto(presupuesto);
	}
	
	@Override
	public void eliminarPresupuesto(Integer idPresupuesto) {
		dataAccess.eliminarPresupuesto(idPresupuesto);
	}
}
