package CONTROLLER;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p"),
@NamedQuery(name="Persona.findLogin", query="SELECT p.nombre FROM Persona p WHERE p.correo= :email")
})
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="PERSONA_IDPERSONA_GENERATOR", sequenceName="PERSONA_ID_PERSONA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_IDPERSONA_GENERATOR")
	@Column(name="id_persona")
	private Integer idPersona;
	@Column(name="cedula")
	private String cedula;
	@Column(name="contraseña")
	private String contraseña;
	@Column(name="correo")
	private String correo;
	@Column(name="e_civil")
	private String eCivil;
	@Column(name="edad")
	private Integer edad;
	@Column(name="nombre")
	private String nombre;
	@Column(name="pais")
	private String pais;
	@Column(name="telefono")
	private String telefono;
	@Column(name="tipo")
	private Integer tipo;

	public Persona() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getECivil() {
		return this.eCivil;
	}

	public void setECivil(String eCivil) {
		this.eCivil = eCivil;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}