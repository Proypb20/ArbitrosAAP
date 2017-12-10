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
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="TiposUsuario")
public class TiposUsuario implements Serializable{

	@Autowired
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Autowired
	@Column( name = "idTipoUsuario")
	private Integer idTipoUsuario;
	
	@Autowired
	@Column( name = "nombre")
	private String nombre;
	
	@Autowired
	@Column( name = "arbitra")
	private String arbitra;
	
	@Autowired
	@Column( name = "idCreado")
	private Integer idCreado;
	
	@Autowired
    @Column( name = "fechaCreado")
	private Date  fechaCreado;
	
	@Autowired
	@OneToMany( mappedBy = "tipousuario", fetch= FetchType.LAZY) 
	private List<Usuarios> usuario = new ArrayList<>();
	
	@Autowired
    public List<Usuarios> getUsuario() {
		return usuario;
	}
	
	@Autowired
	public void setUsuario(List<Usuarios> usuario) {
		this.usuario = usuario;
	}
	
	@Autowired
	public TiposUsuario ()
	{
		fechaCreado = Otros.GetSysdate();
	}
	
	@Autowired
	public void setArbitra(String arbitra) {
		this.arbitra = arbitra;
	}
	
	@Autowired
	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}
	
	@Autowired
	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
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
	public String getArbitra() {
		return arbitra;
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