package CONTROLLER;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="AUDITORIA_IDAUDITORIA_GENERATOR", sequenceName="AUDITORIA_ID_AUDITORA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUDITORIA_IDAUDITORIA_GENERATOR")
	@Column(name="id_auditoria")
	private Integer idAuditoria;
	@Column(name="activar")
	private Integer activar;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name="operacion")
	private String operacion;
	@Column(name="tabla")
	private String tabla;
	@Column(name="trigger")
	private Integer trigger;
	@Column(name="usuario")
	private String usuario;
	@Column(name="valoranterior")
	private String valoranterior;
	@Column(name="valornuevo")
	private String valornuevo;

	public Auditoria() {
	}

	public Integer getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(Integer idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public Integer getActivar() {
		return this.activar;
	}

	public void setActivar(Integer activar) {
		this.activar = activar;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public Integer getTrigger() {
		return this.trigger;
	}

	public void setTrigger(Integer trigger) {
		this.trigger = trigger;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getValoranterior() {
		return this.valoranterior;
	}

	public void setValoranterior(String valoranterior) {
		this.valoranterior = valoranterior;
	}

	public String getValornuevo() {
		return this.valornuevo;
	}

	public void setValornuevo(String valornuevo) {
		this.valornuevo = valornuevo;
	}

}