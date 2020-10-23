package co.ufps.edu.webclothes.model;

import java.io.Serializable;

public class Marca implements Serializable {

	int id;
	String nombre, descripcion;

	public Marca() {
		super();
	}

	public Marca(int id,String nombre, String descripcion) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
