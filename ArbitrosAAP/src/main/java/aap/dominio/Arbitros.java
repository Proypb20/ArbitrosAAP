package aap.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Arbitros")
public class Arbitros implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Autowired
	@Column( name = "idArbitro",nullable=false)
	private Integer idArbitro;
	
	@Autowired
	@Column( name = "nroArbitro")
	private Integer nroArbitro;

	@Autowired
	@Column( name = "fechaAlta")
	private Date  fechaAlta;
	
	@Autowired
	@Column( name = "fechaBaja")
	private Date  fechaBaja;
	
	@Autowired
    @Column( name = "fechaCreado")
	private Date  fechaCreado;
    
    @OneToOne 
  	@JoinColumn (name="idArbitro")
    @Autowired
  	private Usuarios usuario;
	
    @Autowired
    @ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn (name="idCategoria")
	private Categorias categoria;
    
    @Autowired
    @OneToMany (mappedBy = "arbitro", fetch= FetchType.LAZY, cascade = CascadeType.ALL) 
    private List<Presupuestos> presupuesto = new ArrayList<>();
    
    @Autowired
    public Categorias getCategoria() {
		return categoria;
	}
    
    @Autowired
	public Arbitros ()
    {
    	fechaAlta = Otros.GetSysdate();
		fechaCreado = Otros.GetSysdate();
    }
    
    @Autowired
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	@Autowired
	public Integer getIdArbitro() {
		return idArbitro;
	}
	@Autowired
	public void setIdArbitro(Integer idArbitro) {
		this.idArbitro = idArbitro;
	}
	@Autowired
	public Integer getNroArbitro() {
		return nroArbitro;
	}
	@Autowired
	public void setNroArbitro(Integer nroArbitro) {
		this.nroArbitro = nroArbitro;
	}
	@Autowired
	public Date getFechaAlta() {
		return fechaAlta;
	}
	@Autowired
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	@Autowired
	public Date getFechaBaja() {
		return fechaBaja;
	}
	@Autowired
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
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
	public List<Presupuestos> getHonorario() {
		return presupuesto;
	}
	@Autowired
	public void setHonorario(List<Presupuestos> presupuesto) {
		this.presupuesto = presupuesto;
	}
}
