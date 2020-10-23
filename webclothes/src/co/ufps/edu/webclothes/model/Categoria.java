package co.ufps.edu.webclothes.model;

import java.io.Serializable;

public class Categoria implements Serializable {

	int id;
	String descripcion, estado;

	public Categoria() {
		super();
	}

	public Categoria(int id,String descripcion, String estado) {
		super();
		this.id=id;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	
}
