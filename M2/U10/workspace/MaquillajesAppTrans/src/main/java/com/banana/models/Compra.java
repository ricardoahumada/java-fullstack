package com.banana.models;

import java.util.Date;

public class Compra {
	private int cid;
	private int usuario;
	private int cosmetico;
	private int cantidad;
	private Date fecha;
	
	public Compra(int cid, int usuario, int cosmetico, int cantidad, Date fecha) {
		super();
		this.cid = cid;
		this.usuario = usuario;
		this.cosmetico = cosmetico;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getCosmetico() {
		return cosmetico;
	}
	public void setCosmetico(int cosmetico) {
		this.cosmetico = cosmetico;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
