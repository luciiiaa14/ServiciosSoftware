package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings({ "serial" })
public abstract class Seguro implements Serializable {
	
	public static final double AUMENTO_PROFESIONAL = 100.0;
	public static final double MULTIPLICADOR_POTENCIA = 1.5;
	
	private String id;
	private LocalDate fechaInicio;
	private Vehiculo vehiculo;
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
