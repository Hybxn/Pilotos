package com.pilotos.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Piloto {
	
	@Id @GeneratedValue
	private long id;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	
	public Piloto() {}
	
	public Piloto(String email, String password, String nombre, String apellido) {
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Piloto [id=" + id + ", email=" + email + ", nombre=" + nombre + ", apellido="
				+ apellido + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, email, id, nombre, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
	}
}
