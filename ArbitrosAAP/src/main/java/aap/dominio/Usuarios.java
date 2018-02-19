package aap.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Usuarios")
@Proxy(lazy = false)
public class Usuarios implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Autowired
	@Column( name = "idUsuario")
	private int idUsuario;
	
	@Autowired
	@Column( name = "nombre")
	private String nombre;
	
	@Autowired
	@Column( name = "apellido")
	private String apellido;

	@Autowired
	@Column( name = "usuario")
	private String usuario;
	
	@Autowired
	@Column( name = "contrasena")
	private String contrasena;

	@Autowired
	@Column( name = "tipoDocumento")
	private String tipoDocumento;
	
	@Autowired
	@Column( name = "nroDocumento")
	private String nroDocumento;
	
	@Autowired
	@Column( name = "direccion")
	private String direccion;
	
	@Autowired
	@Column( name = "localidad")
	private String localidad;
	
	@Autowired
	@Column( name = "provincia")
	private String provincia;
	
	@Autowired
	@Column( name = "pais")
	private String pais;
	
	@Autowired
	@Column( name = "telefono")
	private String telefono;
	
	@Autowired
	@Column( name = "email")
	private String email;

	@Autowired
	@Column( name = "estado")
	private String estado;
	
	@Autowired
	@Column( name = "idCreado")
	private int idCreado;
	
	@Autowired
    @Column( name = "fechaCreado")
	private Date  fechaCreado;
    
	@Autowired
    @OneToOne (cascade={CascadeType.ALL},fetch= FetchType.EAGER)
  	@JoinColumn (name="idArbitro")
  	private Arbitros arbitro;
    
	@Autowired
    @ManyToOne(fetch= FetchType.EAGER,optional=true)
	@JoinColumn(name="idTipoUsuario") 
	private TiposUsuario tipousuario;
	
	@Autowired
	public Usuarios()
    {
    	estado = "A";
		fechaCreado = Otros.GetSysdate();
    }
	@Autowired
	public int getIdUsuario() {
		return idUsuario;
	}
	@Autowired
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getApellido() {
		return apellido;
	}
	@Autowired
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Autowired
	public String getUsuario() {
		return usuario;
	}
	@Autowired
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Autowired
	public String getContrasena() {
		return contrasena;
	}
	@Autowired
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Autowired
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	@Autowired
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	@Autowired
	public String getNroDocumento() {
		return nroDocumento;
	}
	@Autowired
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	@Autowired
	public String getDireccion() {
		return direccion;
	}
	@Autowired
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Autowired
	public String getLocalidad() {
		return localidad;
	}
	@Autowired
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	@Autowired
	public String getProvincia() {
		return provincia;
	}
	@Autowired
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Autowired
	public String getPais() {
		return pais;
	}
	@Autowired
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Autowired
	public String getTelefono() {
		return telefono;
	}
	@Autowired
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Autowired
	public String getEmail() {
		return email;
	}
	@Autowired
	public void setEmail(String email) {
		this.email = email;
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
	public int getIdCreado() {
		return idCreado;
	}
	@Autowired
	public void setIdCreado(int idCreado) {
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
    public Arbitros getArbitro() {
		return arbitro;
	}
	@Autowired
	public void setArbitro(Arbitros arbitro) {
		this.arbitro = arbitro;
	}   
	@Autowired
	public TiposUsuario getTipousuario() {
		return tipousuario;
	}
	@Autowired
	public void setTipousuario(TiposUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}
	@Autowired
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
