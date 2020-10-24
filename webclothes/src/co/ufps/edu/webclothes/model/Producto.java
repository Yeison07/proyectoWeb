package co.ufps.edu.webclothes.model;

import java.io.Serializable;

public class Producto implements Serializable {
	
	private int id;
	private String referencia, nombre, descripcion, detalle, palabrasC, estado;
	private Double valor;
	private int categoria_id, marca_id;
	
	

	public Producto(int id,String referencia, String nombre, String descripcion, String detalle, String palabrasC,
			String estado,Double valor, int categoria_id, int marca_id) {
		super();
		this.id=id;
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.palabrasC = palabrasC;
		this.estado = estado;
		this.categoria_id = categoria_id;
		this.marca_id = marca_id;
		this.valor=valor;
		
	}
	
	public Producto(String referencia, String nombre, String descripcion, String detalle, String palabrasC,
			String estado,Double valor, int categoria_id, int marca_id) {
		super();
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.detalle = detalle;
		this.palabrasC = palabrasC;
		this.estado = estado;
		this.categoria_id = categoria_id;
		this.marca_id = marca_id;
		this.valor=valor;
		
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getPalabrasC() {
		return palabrasC;
	}

	public void setPalabrasC(String palabrasC) {
		this.palabrasC = palabrasC;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	public int getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(int marca_id) {
		this.marca_id = marca_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Double getValor() {
		return this.valor;
		
	}
	
	public void setValor(Double valor) {
		this.valor=valor;
	}

}
