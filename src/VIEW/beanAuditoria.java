package VIEW;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import CONTROLLER.Auditoria;
import MODEL.AUDITORIA;

@ManagedBean
@RequestScoped
public class beanAuditoria implements Serializable{

	private static final long serialVersionUID = 1L;
	private List lista = new ArrayList<Auditoria>();
	private AUDITORIA audito = new AUDITORIA();
	private Auditoria auditorias = new Auditoria();
	
	public void listarAuditorias() {
		lista = audito.listaAuditorias();
	}
	
	public List listarAuditoria() {
		lista = audito.listaAuditorias();
		return lista;
	}

	public List getLista() {
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}

	public AUDITORIA getAudito() {
		return audito;
	}

	public void setAudito(AUDITORIA audito) {
		this.audito = audito;
	}

	public Auditoria getAuditorias() {
		return auditorias;
	}

	public void setAuditorias(Auditoria auditorias) {
		this.auditorias = auditorias;
	}
	
	
}
