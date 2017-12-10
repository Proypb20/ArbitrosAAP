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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Eventos")
@Proxy(lazy = false)
public class Eventos implements Serializable{

	@Autowired
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Autowired
	@Column( name = "idEvento",nullable=false)
	private int idEvento;
	
	@Autowired
	@Column( name = "nombre")
	private String nombre;

	@Autowired
	@Column( name = "anio")
	private int anio;
	
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
    @ManyToOne(fetch= FetchType.EAGER,optional=true)
	@JoinColumn(name="idTorneo") 
	private Torneos torneo;
    
    
    @Autowired
    @OneToMany (mappedBy = "evento", fetch= FetchType.LAZY) 
    private List<Presupuestos> presupuesto = new ArrayList<>();
    
    @Autowired
	public List<Presupuestos> getHonorario() {
		return presupuesto;
	}

    @Autowired
	public void setHonorario(List<Presupuestos> presupuesto) {
		this.presupuesto = presupuesto;
	}

    @Autowired
	public Torneos getTorneo() {
		return torneo;
	}

    @Autowired
	public void setTorneo(Torneos torneo) {
		this.torneo = torneo;
	}
    
    @Autowired
    public Eventos()
    {
    	estado = "A";
    	fechaCreado = Otros.GetSysdate();
    }

    @Autowired
	public int getIdEvento() {
		return idEvento;
	}

    @Autowired
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
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
	public int getAnio() {
		return anio;
	}

    @Autowired
	public void setAnio(int anio) {
		this.anio = anio;
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
    
}
