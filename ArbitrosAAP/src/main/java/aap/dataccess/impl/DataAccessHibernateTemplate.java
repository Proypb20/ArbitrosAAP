package aap.dataccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import aap.dataccess.DataAccess;
import aap.dominio.Categorias;
import aap.dominio.Eventos;
import aap.dominio.Presupuestos;
import aap.dominio.TiposUsuario;
import aap.dominio.Torneos;
import aap.dominio.Usuarios;

public class DataAccessHibernateTemplate implements DataAccess {

	@Autowired
	private HibernateTemplate hibernateTemplate = null;

    public DataAccessHibernateTemplate(){}
    
    @Autowired
	public DataAccessHibernateTemplate(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarUsuario(Usuarios usuario) {
		this.hibernateTemplate.save(usuario);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuarios obtenerUsuario(Integer IdU) {
		return this.hibernateTemplate.get(Usuarios.class,IdU);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Integer obteneridArbitro(Integer IdU)
	{
		Usuarios usuario =  this.hibernateTemplate.get(Usuarios.class,IdU);
		return usuario.getArbitro().getIdArbitro();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Usuarios> obtenerUsuarios() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuarios.class);
		criteria.add(Restrictions.eq("estado", "A"));
		return (ArrayList<Usuarios>) this.hibernateTemplate.findByCriteria(criteria);
		
		/*Filtrar por Activos*/
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Usuarios> obtenerArbitros() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuarios.class);
		criteria.add(Restrictions.isNotNull("arbitro"));
		criteria.add(Restrictions.eq("estado", "A"));
		return (ArrayList<Usuarios>) this.hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarUsuario(Integer IdU) {
		Usuarios usuario = new Usuarios();
		usuario.setIdUsuario(IdU);
		this.hibernateTemplate.delete(usuario);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarUsuario(Usuarios usuario) {
		this.hibernateTemplate.update(usuario);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void inactivarUsuario(Usuarios usuario) {
		this.hibernateTemplate.update(usuario);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Eventos> obtenerEventos() {
		return (ArrayList<Eventos>) this.hibernateTemplate.loadAll(Eventos.class);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Eventos> obtenerEventosT(Integer idTorneo) {
//		return (ArrayList<Eventos>) this.hibernateTemplate.get(Eventos.class,idTorneo);
		DetachedCriteria criteria = DetachedCriteria.forClass(Eventos.class);
		criteria.add(Restrictions.eq("torneo.idTorneo", idTorneo));
		return (ArrayList<Eventos>) this.hibernateTemplate.findByCriteria(criteria);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Eventos obtenerEvento(Integer idEvento) {
		return this.hibernateTemplate.get(Eventos.class,idEvento);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarEvento(Eventos evento) {
		this.hibernateTemplate.save(evento);
		
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarEvento(Integer idEvento) {
		Eventos evento = new Eventos();
		evento.setIdEvento(idEvento);
		this.hibernateTemplate.delete(evento);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarEvento(Eventos evento) {
		this.hibernateTemplate.update(evento);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Torneos> obtenerTorneos() {
		return (ArrayList<Torneos>) this.hibernateTemplate.loadAll(Torneos.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Torneos obtenerTorneo(Integer idTorneo) {
		return this.hibernateTemplate.get(Torneos.class,idTorneo);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarTorneo(Torneos torneo) {
		this.hibernateTemplate.save(torneo);
		
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarTorneo(Integer idTorneo) {
		Torneos torneo = new Torneos();
		torneo.setIdTorneo(idTorneo);
		this.hibernateTemplate.delete(torneo);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarTorneo(Torneos torneo) {
		this.hibernateTemplate.update(torneo);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Date GetSysdate()
	{
		Date date = new Date();
		return date;
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuarios LoginUsuario(String query)
	{
		Usuarios usuario = new Usuarios();
		List<Usuarios> listUsuario = (List<Usuarios>) this.hibernateTemplate.find(query);
		if (listUsuario.isEmpty())
			return (null); 
		else
		{
			usuario = listUsuario.get(0);		
		    return (usuario);
		} 
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Categorias> obtenerCategorias() {
		return (ArrayList<Categorias>) this.hibernateTemplate.loadAll(Categorias.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Categorias obtenerCategoria(Integer idCategoria) {
		return this.hibernateTemplate.get(Categorias.class,idCategoria);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarCategoria(Categorias categoria) {
		this.hibernateTemplate.save(categoria);
		
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarCategoria(Integer idCategoria) {
		Categorias categoria = new Categorias();
		categoria.setIdCategoria(idCategoria);
		this.hibernateTemplate.delete(categoria);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarCategoria(Categorias categoria) {
		this.hibernateTemplate.update(categoria);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<TiposUsuario> obtenerTiposUsuario() {
		return (ArrayList<TiposUsuario>) this.hibernateTemplate.loadAll(TiposUsuario.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public TiposUsuario obtenerTipoUsuario(Integer idTipoUsuario) {
		return this.hibernateTemplate.get(TiposUsuario.class,idTipoUsuario);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarTiposUsuario(TiposUsuario tipousuario) {
		this.hibernateTemplate.save(tipousuario);
		
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarTiposUsuario(Integer idTipoUsuario) {
		TiposUsuario tipousuario = new TiposUsuario();
		tipousuario.setIdTipoUsuario(idTipoUsuario);
		this.hibernateTemplate.delete(tipousuario);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarTiposUsuario(TiposUsuario tipousuario) {
		this.hibernateTemplate.update(tipousuario);
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Integer ProximoArbitro(String query)
	{
		Integer numero = 0;
		List<Integer> numeros = (List<Integer>) this.hibernateTemplate.find(query);
		if (numeros.isEmpty())
			return (0); 
		else
		{
			numero = numeros.get(0);		
		    return (numero);
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public ArrayList<Presupuestos> obtenerPresupuestosE(String Estado) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Presupuestos.class);
		criteria.add(Restrictions.eq("estado", Estado));
		return (ArrayList<Presupuestos>) this.hibernateTemplate.findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public ArrayList<Presupuestos> obtenerPresupuestos(Integer idUsuario) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Presupuestos.class);
		criteria.add(Restrictions.eq("arbitro.usuario.idUsuario", idUsuario));
		return (ArrayList<Presupuestos>) this.hibernateTemplate.findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public ArrayList<Presupuestos> obtenerPresupuestosEv(Integer idEvento) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Presupuestos.class);
		criteria.add(Restrictions.eq("evento.idEvento", idEvento));
		return (ArrayList<Presupuestos>) this.hibernateTemplate.findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public ArrayList<Presupuestos> obtenerPresupuestosEA(Integer idEvento,Integer idArbitro) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Presupuestos.class);
		criteria.add(Restrictions.eq("evento.idEvento", idEvento));
		criteria.add(Restrictions.eq("arbitro.idArbitro", idArbitro));
		return (ArrayList<Presupuestos>) this.hibernateTemplate.findByCriteria(criteria);
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public ArrayList<Presupuestos> obtenerPresupuestosA(Integer idArbitro) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Presupuestos.class);
		criteria.add(Restrictions.eq("arbitro.idArbitro", idArbitro));
		return (ArrayList<Presupuestos>) this.hibernateTemplate.findByCriteria(criteria);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Presupuestos obtenerPresupuesto(Integer idPresupuesto) {
		return this.hibernateTemplate.get(Presupuestos.class,idPresupuesto);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarPresupuesto(Presupuestos presupuesto) {
		this.hibernateTemplate.save(presupuesto);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarPresupuesto(Presupuestos presupuesto) {
		this.hibernateTemplate.update(presupuesto);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminarPresupuesto(Integer idPresupuesto) {
		Presupuestos presupuesto = new Presupuestos();
		presupuesto.setIdPresupuesto(idPresupuesto);
		this.hibernateTemplate.delete(presupuesto);
		
	}
}
