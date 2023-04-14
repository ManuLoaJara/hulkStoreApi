package com.mlj.hulkStore.model;

public class Producto {

	private int id;
	private String referencia;
	private int idTipo;
	private int precio;
	private int stock;
	private int cantidad;
	private String nombreTipo;
	private String imagenBase64;
	private Boolean esNuevo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public String getImagenBase64() {
		return imagenBase64;
	}

	public void setImagenBase64(String imagenBase64) {
		this.imagenBase64 = imagenBase64;
	}
	
	public Boolean getEsNuevo() {
		return esNuevo;
	}
	
	public void setEsNuevo(Boolean esNuevo) {
		this.esNuevo = esNuevo;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", referencia=" + referencia + ", idTipo=" + idTipo + ", precio=" + precio
				+ ", stock=" + stock + ", cantidad=" + cantidad + ", nombreTipo=" + nombreTipo + "]";
	}

}
