package aap.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Aprobaciones")
public class Aprobaciones implements Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column( name = "idAprobacion",nullable=false)
	private int idAprobacion;
	@Autowired
	@Column( name = "estado")
	private String estado;
	@Autowired
    @Column( name = "fechaCreado")
	private Date  fechaCreado;
	@Autowired
    @ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idAprobador") 
	private Usuarios usuario;
	@Autowired
    @ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idPresupuesto") 
	private Presupuestos presupuesto;
	@Autowired
    @ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idArbitro") 
	private Arbitros arbitro;
	@Autowired
	public int getIdAprobacion() {
		return idAprobacion;
	}
	@Autowired
	public void setIdAprobacion(int idAprobacion) {
		this.idAprobacion = idAprobacion;
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
	public Usuarios getUsuario() {
		return usuario;
	}
	@Autowired
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	@Autowired
	public Presupuestos getPresupuesto() {
		return presupuesto;
	}
	@Autowired
	public void setPresupuesto(Presupuestos presupuesto) {
		this.presupuesto = presupuesto;
	}
	@Autowired
	public Arbitros getArbitro() {
		return arbitro;
	}
	@Autowired
	public void setArbitro(Arbitros arbitro) {
		this.arbitro = arbitro;
	}
}
