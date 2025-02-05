package es.unican.ss.Practica1.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({ "serial" })
public class Aseguradora implements Serializable{
	
	private List<Cliente> clientes=new LinkedList<Cliente>();
	
	public Aseguradora(){}
	
	public List<Cliente> getClientes(){
		return clientes;
	}


}