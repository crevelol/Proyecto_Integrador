package MODEL;

import java.util.List;

import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import CONTROLLER.Persona;
import CONTROLLER.entityManager;

import java.util.ArrayList;

public class PERSONA {
	private List personas = new ArrayList<>(6);
	private entityManager manager;
	private String respuesta = "";
	
	public List listaPersonas(){
		manager = new entityManager();
		EntityManager em = manager.getEm();
		try {
			personas = em.createNamedQuery("Persona.findAll").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return personas;
		
	}
	
	public String verificarLogin(Persona p){
		System.err.println("Vamos a ver que pedo");
		manager = new entityManager();
		EntityManager em = manager.getEm();
		String per="";
		try {
			System.err.println("El eror esta aqui");
			Query query = em.createNamedQuery("Persona.findLogin").setParameter("email", p.getCorreo());
			per= query.getSingleResult().toString();
			per="Correcto";
			System.err.println(per);
		}catch (NoResultException e) {
			//e.printStackTrace();
			per = "";
		}
		return per;
	}
	
	public String imprimirNombre(String correo){
		System.err.println("Vamos a ver que pedo");
		manager = new entityManager();
		EntityManager em = manager.getEm();
		String per="";
		try {
			System.err.println("El eror esta aqui");
			per = em.createNamedQuery("Persona.findLogin").setParameter("email", correo).getSingleResult().toString();
			System.err.println("El eror esta aqui"+ per + " hola");
		}catch (NoResultException e) {
			//e.printStackTrace();
			per = "";
		}
		return per;
	}
	
	public String insertaPersona(Persona person) {
		manager = new entityManager();
		EntityManager em = manager.getEm();
		
		try {
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
			respuesta = "Persona Registrada";
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = "Error al registrar persona";	
		}
		return respuesta;
	}
	
	public String actualizaPersona(Persona person) {
		manager = new entityManager();
		EntityManager em = manager.getEm();
		
		try {
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
			respuesta = "Persona Actualizar";
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = "Error al actualizar persona";	
		}
		return respuesta;
	}
	
	public String eliminarPersona(Persona person) {
		manager = new entityManager();
		EntityManager em = manager.getEm();
		
		try {
			em.getTransaction().begin();
			Persona borrarPersona = em.merge(person);
			em.remove(borrarPersona);
			em.getTransaction().commit();
			respuesta = "Persona Eliminada";
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = "Error al eliminar persona";	
		}
		return respuesta;
	}
}
