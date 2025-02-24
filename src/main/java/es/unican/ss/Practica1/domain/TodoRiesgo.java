package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="TodoRiesgo")
@SuppressWarnings({ "serial" })
public class TodoRiesgo extends Seguro implements Serializable{
	
	private static final int PRECIO_BASE_TODO_RIESGO = 600;
	
	
	public TodoRiesgo() {
		super(PRECIO_BASE_TODO_RIESGO);
	}
	
	public TodoRiesgo(String id, LocalDate fechaInicio, Vehiculo vehiculo) {
		super(id, fechaInicio, vehiculo, PRECIO_BASE_TODO_RIESGO);
	}
	
	@Override
	public double calculaPrecio() {
		double precio= getPrecioBase()+getVehiculo().getCv()*Seguro.MULTIPLICADOR_POTENCIA;
		if(getVehiculo().esProfesional()){
			precio+=Seguro.AUMENTO_PROFESIONAL;
		}
		return precio;
	}
}
