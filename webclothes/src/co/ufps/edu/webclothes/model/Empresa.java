package co.ufps.edu.webclothes.model;

import java.io.Serializable;

public class Empresa implements Serializable {

	int id;
	String nombre, quienesS, emailC, direccion, telefonoC, face, twitt, insta;

	public Empresa() {
		super();
	}

	public Empresa(String nombre, String quienesS, String emailC, String direccion, String telefonoC,
			String face, String twitt, String insta) {
		super();
		this.nombre = nombre;
		this.quienesS = quienesS;
		this.emailC = emailC;
		this.direccion = direccion;
		this.telefonoC = telefonoC;
		this.face = face;
		this.twitt = twitt;
		this.insta = insta;
	}
	public Empresa(int id,String nombre, String quienesS, String emailC, String direccion, String telefonoC,
			String face, String twitt, String insta) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.quienesS = quienesS;
		this.emailC = emailC;
		this.direccion = direccion;
		this.telefonoC = telefonoC;
		this.face = face;
		this.twitt = twitt;
		this.insta = insta;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getQuienesS() {
		return quienesS;
	}

	public void setQuienesS(String quienesS) {
		this.quienesS = quienesS;
	}

	public String getEmailC() {
		return emailC;
	}

	public void setEmailC(String emailC) {
		this.emailC = emailC;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoC() {
		return telefonoC;
	}

	public void setTelefonoC(String telefonoC) {
		this.telefonoC = telefonoC;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getTwitt() {
		return twitt;
	}

	public void setTwitt(String twitt) {
		this.twitt = twitt;
	}

	public String getInsta() {
		return insta;
	}

	public void setInsta(String insta) {
		this.insta = insta;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", quienesS=" + quienesS + ", emailC=" + emailC
				+ ", direccion=" + direccion + ", telefonoC=" + telefonoC + ", face=" + face + ", twitt=" + twitt
				+ ", insta=" + insta + "]";
	}
	
	

}
