package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@SuppressWarnings({ "serial" })
public class Cliente implements Serializable {
	
	@JsonProperty("dni")
	private String dni;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("email")
	private String email;
	@JsonProperty("seguros")
	private List<Seguro> seguros = new LinkedList<Seguro>();
	@JsonProperty("partes")
	private List<Parte> partes = new LinkedList<Parte>();

	public Cliente() {
	}

	public Cliente(String dni, String nombre, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	public boolean anadeSeguro(Seguro s) {
		seguros.add(s);
		return true;
	}

	public double totalSeguros() {
		double deuda = 0;
		for (Seguro s : seguros) {
			deuda += s.calculaPrecio();
		}
		return deuda;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getDni() {
		return dni;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}
	

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
}
