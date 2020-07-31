package CONTROLLER;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class entityManager {
	
	private EntityManagerFactory factory;
	
	private EntityManager em;
	
	public entityManager() {
		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("Proyecto_Integrador_Final");
			}
			if (em == null) {
				em = factory.createEntityManager();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print("Se activa el catch");
		}
	}

	public EntityManager getEm() {
		return em;
	}
	
}
