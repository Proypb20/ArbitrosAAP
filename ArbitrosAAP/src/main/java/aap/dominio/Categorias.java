package aap.dominio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Categorias")
public class Categorias implements Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column( name = "idCategoria",nullable=false)
	private Integer idCategoria;
	@Autowired
	@Column( name = "nombre")
	private String nombre;
	@Autowired
	@Column( name = "honorarios")
	private Integer honorarios;
	
	@Autowired
    @Column( name = "idCreado")
	private Integer idCreado;
	
	@Autowired
    @Column( name = "fechaCreado")
	private Date  fechaCreado;
	
	@Autowired
    @OneToMany( mappedBy = "categoria", fetch= FetchType.EAGER) 
	private List<Arbitros> arbitro = new ArrayList<>();
	
	public Integer getIdCreado() {
		return idCreado;
	}

	public void setIdCreado(Integer idCreado) {
		this.idCreado = idCreado;
	}

	@Autowired
	public Categorias()
	{
		fechaCreado = Otros.GetSysdate();
	}
	
	@Autowired
	public Integer getIdCategoria() {
		return idCategoria;
	}
	@Autowired
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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
	public Integer getHonorarios() {
		return honorarios;
	}
	@Autowired
	public void setHonorarios(Integer honorarios) {
		this.honorarios = honorarios;
	}
	
	@Autowired
	public Integer getidCreado() {
		return idCreado;
	}
	@Autowired
	public void setidCreado(Integer idCreado) {
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
