package MODEL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import CONTROLLER.entityManager;

public class AUDITORIA {
	private List auditorias = new ArrayList<>();
	
	private entityManager manager;
	private String respuesta = "";
	
	public List listaAuditorias(){
		manager = new entityManager();
		EntityManager em = manager.getEm();
		try {
			auditorias = em.createNamedQuery("Auditoria.findAll").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return auditorias;
	}

	public List getAuditorias() {
		return auditorias;
	}

	public void setAuditorias(List auditorias) {
		this.auditorias = auditorias;
	}
	
	
}
