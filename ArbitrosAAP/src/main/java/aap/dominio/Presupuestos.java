package aap.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Presupuestos")
@Proxy(lazy =false)
public class Presupuestos implements Serializable{

	@Autowired
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Autowired
	@Column( name = "idPresupuesto",nullable=false)
	private int idPresupuesto;
	
	@Autowired
	@Column( name = "dia")
	private int dia;
	
	@Autowired
	@Column( name = "mayor")
	private String mayor;
	
	@Autowired
	@Column( name = "viatico")
	private String viatico;
	
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
    @ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="idEvento") 
    private Eventos evento;
    
    @Autowired
    @ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="idArbitro") 
    private Arbitros arbitro;
    
    @Autowired
	public Presupuestos ()
	{
    	estado = "N";
    	fechaCreado = Otros.GetSysdate();
	}
    
    @Autowired
	public int getIdPresupuesto() {
		return idPresupuesto;
	}

    @Autowired
	public void setIdPresupuesto(int idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

    @Autowired
	public int getDia() {
		return dia;
	}

    @Autowired
	public void setDia(int dia) {
		this.dia = dia;
	}

    @Autowired
	public String getMayor() {
		return mayor;
	}

    @Autowired
	public void setMayor(String mayor) {
		this.mayor = mayor;
	}

    @Autowired
	public String getViatico() {
		return viatico;
	}
    
    @Autowired
	public void setViatico(String viatico) {
		this.viatico = viatico;
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
	public Eventos getEvento() {
		return evento;
	}

    @Autowired
	public void setEvento(Eventos evento) {
		this.evento = evento;
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
