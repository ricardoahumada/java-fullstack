package com.banana.models;

import java.util.Date;

public class Foto {
	private String formato;
	private String medidas;
	private String coleres;
	private String titulo;
	private String[] etiquetas;
	private Date fecha;
	private Usuario autor;
	private String[] comentarios;
	private int likes;
	
	public Foto(String formato, String medidas, String coleres, String titulo, String[] etiquetas, Date fecha,
			Usuario autor, String[] comentarios, int likes) {
		this.formato = formato;
		this.medidas = medidas;
		this.coleres = coleres;
		this.titulo = titulo;
		this.etiquetas = etiquetas;
		this.fecha = fecha;
		this.autor = autor;
		this.comentarios = comentarios;
		this.likes = likes;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}
	public String getColeres() {
		return coleres;
	}
	public void setColeres(String coleres) {
		this.coleres = coleres;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String[] getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(String[] etiquetas) {
		this.etiquetas = etiquetas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public String[] getComentarios() {
		return comentarios;
	}
	public void setComentarios(String[] comentarios) {
		this.comentarios = comentarios;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
}
