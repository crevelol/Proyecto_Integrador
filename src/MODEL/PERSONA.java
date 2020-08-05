package MODEL;

import java.util.List;
import java.util.Vector;

import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import CONTROLLER.Persona;
import CONTROLLER.entityManager;

import java.util.ArrayList;

public class PERSONA {
	private List personas = new ArrayList<>();
	private List personas2 = new ArrayList<>();
	private List personas3 = new ArrayList<>();
	private entityManager manager;
	private String respuesta = "";
	
	public List listaPersonas(){
		manager = new entityManager();
		EntityManager em = manager.getEm();
		try {
			personas = em.createNamedQuery("Persona.findAll").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return personas;
		
	}
	
	public Vector verificarLogin(Persona p){
		System.err.println("Vamos a ver que pedo");
		manager = new entityManager();
		EntityManager em = manager.getEm();
		String por,por2,por3;
		Vector vec = new Vector();
		personas=null;
		try {
			personas = em.createNamedQuery("Persona.findNombre").setParameter("email", p.getCorreo()).setParameter("contra", p.getContraseña()).getResultList();
			personas2 = em.createNamedQuery("Persona.findPais").setParameter("email", p.getCorreo()).setParameter("contra", p.getContraseña()).getResultList();
			personas3 = em.createNamedQuery("Persona.findTipo").setParameter("email", p.getCorreo()).setParameter("contra", p.getContraseña()).getResultList();
			if (personas.toString() != "[]") {
				por = personas.get(0).toString();
				por2 = personas2.get(0).toString();
				por3 = personas3.get(0).toString();
				vec.addElement(por);
				vec.addElement(por2);
				vec.addElement(por3);
			}
		}catch (NoResultException e) {
			e.printStackTrace();
			vec = null;
		}
		return vec;
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
	
	public List getPersonas() {
		return personas;
	}

	public void setPersonas(List personas) {
		this.personas = personas;
	}

	public String actualizaPersona(Persona person) {
		manager = new entityManager();
		EntityManager em = manager.getEm();
		try {
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
			respuesta = "Persona Actualizar";
			System.err.println(respuesta);
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = "Error al actualizar persona";	
		}
		return respuesta;
	}
	
	public String eliminarPersona(Integer id) {
		manager = new entityManager();
		EntityManager em = manager.getEm();
		Persona pe = new Persona();
		try {
			pe = em.find(Persona.class, id);
			em.getTransaction().begin();
			em.remove(pe);
			em.getTransaction().commit();
			respuesta = "Persona Eliminada";
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = "Error al eliminar persona";	
		}
		return respuesta;
	}
}
