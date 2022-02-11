package com.pilotos.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Monoplaza {

	@Id @GeneratedValue
	private long id;
	private String fabricante;
	private String modelo;
	private int potencia;
	@ManyToOne
	private Piloto piloto;
	
	public Monoplaza() {}

	public Monoplaza(String fabricante, String modelo, int potencia, Piloto piloto) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.potencia = potencia;
		this.piloto = piloto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
		return "Monoplaza [id=" + id + ", fabricante=" + fabricante + ", modelo=" + modelo + ", potencia=" + potencia
				+ ", piloto=" + piloto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fabricante, id, modelo, piloto, potencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monoplaza other = (Monoplaza) obj;
		return Objects.equals(fabricante, other.fabricante) && id == other.id && Objects.equals(modelo, other.modelo)
				&& Objects.equals(piloto, other.piloto) && potencia == other.potencia;
	}	
}
