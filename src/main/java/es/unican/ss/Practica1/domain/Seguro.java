package es.unican.ss.Practica1.domain;

import java.io.Serializable;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.unican.ss.Practica1.seralizacion.CustomLocalDateDeserializer;
import es.unican.ss.Practica1.seralizacion.CustomLocalDateSerializer;
import es.unican.ss.Practica1.seralizacion.LocalDateAdapterXML;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@XmlType(name="Seguro")
@XmlSeeAlso({Terceros.class, TodoRiesgo.class, TRFranquicia.class})
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, 
				include= JsonTypeInfo.As.PROPERTY,
				property = "type")
@JsonSubTypes({
	@Type(value=Terceros.class, name="terceros"),
	@Type(value=TodoRiesgo.class, name="todoRiesgo"),
	@Type(value=TRFranquicia.class, name="franquicia"),

})
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@SuppressWarnings({ "serial" })
public abstract class Seguro implements Serializable {
	
	public static final double AUMENTO_PROFESIONAL = 100.0;
	public static final double MULTIPLICADOR_POTENCIA = 1.5;
	@JsonProperty("id")
	@XmlID
	@XmlAttribute(required = true)
	private String id;
	@XmlJavaTypeAdapter(LocalDateAdapterXML.class)
	@XmlAttribute(name = "fecha",required = true)
	@JsonProperty("fecha")
	@JsonSerialize(using=CustomLocalDateSerializer.class)
	@JsonDeserialize(using=CustomLocalDateDeserializer.class)
	private LocalDate fechaInicio;

	@XmlElement(name = "vehiculo", required = true)
	@JsonProperty("vehiculo")
	private Vehiculo vehiculo;
	@XmlAttribute(name="precioBase", required = true)
	@JsonIgnore
	private double precioBase;
	
	public Seguro(){
	}
	
	public Seguro(String id, LocalDate fechaInicio, Vehiculo vehiculo, double precioBase) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.vehiculo = vehiculo;
		this.precioBase = precioBase;
	}

	public Seguro (double precioBase) {
		this.precioBase = precioBase;
	}
	
	public String getId() {
		return id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public double getPrecioBase() {
		return precioBase;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public abstract double calculaPrecio();
	
}
