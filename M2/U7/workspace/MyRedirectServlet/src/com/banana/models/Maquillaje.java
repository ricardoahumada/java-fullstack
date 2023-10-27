package com.banana.models;

public class Maquillaje {
	private String codigo;
	private String marca;
	private String tipo;
	private int precio;
	
	public Maquillaje(String marca, String tipo,int precio) {
		this.codigo = ""+Math.random();
		this.marca=marca;
		this.tipo = tipo;
		this.precio = precio;
	}

	public int comprar(){
		return this.precio;
	}

	public String showData() {
		return this.marca +":"+this.tipo+":"+this.precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
	
}
