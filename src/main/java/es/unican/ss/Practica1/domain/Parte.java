package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings({ "serial" })
public class Parte implements Serializable {
	
	private Integer idParte;
	private Seguro seguro;
	private double importe;
	private LocalDate fecha;
	
	public Parte () {
	}

	public Parte(Seguro seguro, double importe, LocalDate fecha, Integer idParte) {
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
	
	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
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
