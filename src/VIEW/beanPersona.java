package VIEW;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	public String loginVerificar() {
		System.err.println("El bean");
		login = person.verificarLogin(personaRegistro);
		String res;
		if (login != "") {
			res = "logeado";
		}else {
			res = "index";
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
	
	public void listar() {
		lista = person.listaPersonas();
	}
	
	

}
