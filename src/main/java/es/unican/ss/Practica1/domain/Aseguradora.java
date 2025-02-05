package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@SuppressWarnings({ "serial" })
public class Aseguradora implements Serializable{
	@JsonProperty("cliente")
	@JsonUnwrapped
	private List<Cliente> clientes=new LinkedList<Cliente>();
	
	public Aseguradora(){}
	
	public List<Cliente> getClientes(){
		return clientes;
	}


}