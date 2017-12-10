package aap.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Torneos")
@Proxy(lazy = false)
public class Torneos implements Serializable{
	
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Autowired
	@Column( name = "idTorneo",nullable=false)
	private Integer idTorneo;
	
	@Autowired
	@Column( name = "nombre")
	private String nombre;
	
	@Autowired
	@Column( name = "estado")
	private String estado;
	
	@Autowired
	@Column( name = "idCreado")
	private Integer idCreado;
	
	@Autowired
    @Column( name = "fechaCreado")
	private Date  fechaCreado;

	@Autowired
    @OneToMany(mappedBy = "torneo", fetch= FetchType.EAGER)
	private List<Eventos> evento = new ArrayList<>();
    
	@Autowired
	public Torneos ()
	{
		estado = "A";
		fechaCreado = Otros.GetSysdate();
	}
	
	@Autowired
	public Integer getIdTorneo() {
		return idTorneo;
	}
	
	@Autowired
	public void setIdTorneo(Integer idTorneo) {
		this.idTorneo = idTorneo;
	}

	@Autowired
	public String getNombre() {
		return nombre;
	}
	
	@Autowired
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Autowired
	public String getEstado() {
		return estado;
	}
@Autowired
	public void setEstado(String estado) {
		this.estado = estado;
	}
@Autowired
	public Integer getIdCreado() {
		return idCreado;
	}
@Autowired
	public void setIdCreado(Integer idCreado) {
		this.idCreado = idCreado;
	}
@Autowired
	public Date getFechaCreado() {
		return fechaCreado;
	}
@Autowired
	public void setFechaCreado(Date fechaCreado) {
		this.fechaCreado = fechaCreado;
	}
@Autowired
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
@Autowired
	public List<Eventos> getEvento() {
		return evento;
	}
@Autowired
	public void setEvento(List<Eventos> evento) {
		this.evento = evento;
	}
	
}
