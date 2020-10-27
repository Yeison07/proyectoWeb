package co.ufps.edu.webclothes.model;

import java.io.Serializable;

public class Admin implements Serializable {

	
	private String user, contrasena;

	public Admin (String user,String contra) {
		this.user=user;
		this.contrasena=contra;
		
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
