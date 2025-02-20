package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.unican.ss.Practica1.seralizacion.CustomLocalDateDeserializer;
import es.unican.ss.Practica1.seralizacion.CustomLocalDateSerializer;
import es.unican.ss.Practica1.seralizacion.LocalDateAdapterXML;

@XmlRootElement(name = "parte")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings({ "serial" })
public class Parte implements Serializable {
	@XmlAttribute(name = "id", required = true)
	@JsonProperty("id")
	private Integer idParte;
	
	@XmlElement(name = "seguroRef", required = true)
	@JsonProperty("seguro")
	private String seguro;
	@XmlAttribute(required = true)
	@JsonProperty("importe")
	private double importe;
	@XmlJavaTypeAdapter(LocalDateAdapterXML.class)
	@XmlAttribute(required = true)
	@JsonSerialize(using=CustomLocalDateSerializer.class)
	@JsonDeserialize(using=CustomLocalDateDeserializer.class)
	@JsonProperty("fecha")
	private LocalDate fecha;
	
	public Parte () {
	}

	public Parte(String seguro, double importe, LocalDate fecha, Integer idParte) {
		super();
		this.seguro = seguro;
		this.importe = importe;
		this.fecha = fecha;
		this.idParte = idParte;
	}

	public double getImporte() {
		return importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Integer getIdParte() {
		return idParte;
	}
	
	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setIdParte(Integer idParte) {
		this.idParte = idParte;
	}

}
