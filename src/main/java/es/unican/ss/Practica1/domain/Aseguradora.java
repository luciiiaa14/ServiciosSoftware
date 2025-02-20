package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@XmlRootElement(name = "aseguradora")
@SuppressWarnings({ "serial" })
public class Aseguradora implements Serializable{
	@XmlElement(name = "cliente", required = true)
	@JsonProperty("clientes")
	private List<Cliente> clientes=new LinkedList<Cliente>();
	
	public Aseguradora(){}
	
	public List<Cliente> getClientes(){
		return clientes;
	}


}