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
@Table(name="Honorarios")
@Proxy(lazy =false)
public class Honorarios implements Serializable{

	@Autowired
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Autowired
	@Column( name = "idHonorario",nullable=false)
	private int idHonorario;
	
	@Autowired
	@Column( name = "dia")
	private int dia;
	
	@Autowired
	@Column( name = "mayor")
	private String mayor;
	
	@Autowired
	@Column( name = "viatico")
	private int viatico;
	
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
    @ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idEvento") 
    private Eventos evento;
    
    @Autowired
    @ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idArbitro") 
    private Arbitros arbitro;
    
    @Autowired
    @OneToMany (mappedBy = "honorario", fetch= FetchType.LAZY) 
    private List<Aprobaciones> aprobacion = new ArrayList<>();
    
    @Autowired
	public int getIdHonorario() {
		return idHonorario;
	}

    @Autowired
	public void setIdHonorario(int idHonorario) {
		this.idHonorario = idHonorario;
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
	public int getViatico() {
		return viatico;
	}
    
    @Autowired
	public void setViatico(int viatico) {
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

    @Autowired
	public List<Aprobaciones> getAprobacion() {
		return aprobacion;
	}

    @Autowired
	public void setAprobacion(List<Aprobaciones> aprobacion) {
		this.aprobacion = aprobacion;
	}

}
