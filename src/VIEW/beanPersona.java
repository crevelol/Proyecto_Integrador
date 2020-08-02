package VIEW;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import CONTROLLER.Persona;
import MODEL.PERSONA;

@ManagedBean
@RequestScoped
public class beanPersona implements Serializable{

	private static final long serialVersionUID = 1L;
	private PERSONA person = new PERSONA();
	private List lista = new ArrayList<Persona>();
	private Persona personaRegistro = new Persona();
	private ManageUtil mu = new ManageUtil();
	private boolean mBotonGuardar = true;
	private boolean mBotonActualizar = false;
	private boolean mBotonVolver = false;
	private boolean session = false;
	private String login, user;
	
	public List getLista() {
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}

	public Persona getPersonaRegistro() {
		return personaRegistro;
	}

	public void setPersonaRegistro(Persona personaRegistro) {
		this.personaRegistro = personaRegistro;
	}
	
	public void listarPersonas() {
		lista = person.listaPersonas();
	}
	
	public List listarPersona() {
		lista = person.listaPersonas();
		return lista;
	}
	
	public void admincrearUsuario() {
		user = person.insertaPersona(personaRegistro);
		mu.agregarMensaje(user);
		System.err.println(user);
		limpiarFormulario();
	}
	
	public void adminactulizarUsuario() {
		System.err.println(personaRegistro.getNombre());
		user = person.actualizaPersona(personaRegistro);
		
		System.err.println(user);
		mu.agregarMensaje(user);
		limpiarFormulario();
	}
	
	public void admineliminarUsuario(Integer id) {
		PERSONA perso = new PERSONA();
		user = perso.eliminarPersona(id);
		mu.agregarMensaje(user);
		limpiarFormulario();
	}
	
	public boolean ismBotonGuardar() {
		return mBotonGuardar;
	}

	public void setmBotonGuardar(boolean mBotonGuardar) {
		this.mBotonGuardar = mBotonGuardar;
	}

	public boolean ismBotonActualizar() {
		return mBotonActualizar;
	}

	public void setmBotonActualizar(boolean mBotonActualizar) {
		this.mBotonActualizar = mBotonActualizar;
	}

	public boolean ismBotonVolver() {
		return mBotonVolver;
	}

	public void setmBotonVolver(boolean mBotonVolver) {
		this.mBotonVolver = mBotonVolver;
	}

	public void limpiarFormulario() {
		personaRegistro = new Persona();
		mBotonGuardar = true;
		mBotonActualizar = false;
		mBotonVolver = false;
	}
	
	public void llenarFormulario(Persona p) {
		personaRegistro.setIdPersona(p.getIdPersona());
		personaRegistro.setNombre(p.getNombre());
		personaRegistro.setCedula(p.getCedula());
		personaRegistro.setEdad(p.getEdad());
		personaRegistro.setCorreo(p.getCorreo());
		personaRegistro.setContraseña(p.getContraseña());
		personaRegistro.setPais(p.getPais());
		personaRegistro.setTelefono(p.getTelefono());
		personaRegistro.setECivil(p.getECivil());
		personaRegistro.setTipo(p.getTipo());
		mBotonGuardar = false;
		mBotonActualizar = true;
		mBotonVolver = true;
	}
	
	public void volverPersona() {
		limpiarFormulario();
	}
	
	public String loginVerificar() {
		System.err.println("El bean");
		Vector vec;
		vec = person.verificarLogin(personaRegistro);
		
		personaRegistro.setNombre(vec.elementAt(0).toString());
		personaRegistro.setPais(vec.elementAt(1).toString());
		personaRegistro.setTipo(Integer.parseInt(vec.elementAt(2).toString()));
		
		String res;
		if (vec != null) {
			res = "logeado";
			session = true;
		}else{
			res = "index";
			session = false;
		}
		return res;
		//mu.agregarMensaje(res);
	}
	
	public String crearUsuario() {
		String res="";
		user = person.insertaPersona(personaRegistro);
		System.err.println(user);
		if (user == "Persona Registrada") {
			System.err.println(user+"Correcto");
			res = "validarCuenta";
			System.err.println(res);
		}else {
			res = "index";
			System.err.println(user+"Negado");
			/*
			res = "Error al crear el usuario";
			mu.agregarMensaje(res);
			*/
		}
		return res;
	}

	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}
	
}
