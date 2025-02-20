package es.unican.ss.Practica1.domain;

import java.io.Serializable;


import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@XmlRootElement(name = "cliente")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings({ "serial" })
public class Cliente implements Serializable {
	@XmlAttribute(required = true)
	@JsonProperty("dni")
	private String dni;
	@XmlAttribute(required = true)
	@JsonProperty("nombre")
	private String nombre;
	@XmlAttribute(required = true)
	@JsonProperty("email")
	private String email;
	@XmlElements({
		@XmlElement(name="Terceros", type = Terceros.class),
		@XmlElement(name="TodoRiesgo", type = TodoRiesgo.class),
		@XmlElement(name="TRFranquicia", type = TRFranquicia.class)
	})
	@JsonProperty("seguros")
	private List<Seguro> seguros = new LinkedList<Seguro>();
	@JsonInclude(value=Include.NON_EMPTY)
	@JsonProperty("partes")
	@XmlElement(name = "parte", required = false)
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
