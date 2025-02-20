package es.unican.ss.Practica1.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "vehiculo")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings({ "serial" })
public class Vehiculo implements Serializable{
	@XmlAttribute(required = true)
	@JsonProperty("matricula")
	private String matricula;
	@XmlAttribute(required = true)
	@JsonProperty("cv")
	private int cv;
	@XmlAttribute(required = true)
	@JsonProperty("profesional")
	private boolean esProfesional;
	
	public Vehiculo(String mat, int cv, boolean esPro){
		this.matricula=mat;
		this.cv=cv;
		this.esProfesional=esPro;
	}
	
	public Vehiculo(){	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public boolean esProfesional() {
		return esProfesional;
	}

	public void setEsProfesional(boolean esProfesional) {
		this.esProfesional = esProfesional;
	}

	public String getMatricula() {
		return matricula;
	}
		
	public boolean isEsProfesional() {
		return esProfesional;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
