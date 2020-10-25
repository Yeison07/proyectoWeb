package co.ufps.edu.webclothes.model;

import java.io.Serializable;

public class Imagen implements Serializable{

	private int id;
	private String ruta;
	
	public Imagen() {
		super();
		
	}
	
	public Imagen(int id, String ruta) {
		super();
		this.id = id;
		this.ruta = ruta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	
}
