package es.unican.ss.Practica1.main;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.Practica1.domain.Aseguradora;
import es.unican.ss.Practica1.domain.Cliente;
import es.unican.ss.Practica1.domain.Parte;
import es.unican.ss.Practica1.domain.Seguro;
import es.unican.ss.Practica1.domain.TRFranquicia;
import es.unican.ss.Practica1.domain.Terceros;
import es.unican.ss.Practica1.domain.TodoRiesgo;
import es.unican.ss.Practica1.domain.Vehiculo;

public class AseguradoraMainXML {

	public static void main(String[] args) {
		Aseguradora aseguradora1 = null;
		double importe = 0.0;
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(Aseguradora.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Marshaller marshaller;
		try {
			
			Aseguradora aseguradora;

			// Deserialización desde XML
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			aseguradora1 = (Aseguradora) unmarshaller.unmarshal(new File("C:\\Users\\lucia\\OneDrive\\Escritorio\\SERVICIOS\\Practica1\\src\\main\\resources\\datos\\segurosUCF.xml"));


		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Obtengo el nombre, el dni y el importe a pagar de todos sus seguros.
		for (Cliente c : aseguradora1.getClientes()) {
			importe = 0.0;
			for (Seguro s : c.getSeguros()) {
				importe += s.calculaPrecio();
			}
			System.out.println("El cliente es " + c.getNombre() + ", el dni: " + c.getDni() + " y el importe total será " + importe +"€");
		}
		
		//Creo el seguro y los clientes.
		Vehiculo v1 = new Vehiculo("KKY2233", 90, true);
		Vehiculo v2 = new Vehiculo("LSC1233", 110, false);
		
		Terceros s1 = new Terceros("23", LocalDate.of(2024, 9, 10), v1);
        TRFranquicia s2 = new TRFranquicia("24", LocalDate.of(2022, 12, 1), v2, 123.00);
        
		Cliente c5 = new Cliente("76522112L", "Jorge Garrido G", "jgg@unican.es");
		
		Parte p1 = new Parte(s1.getId(), 1000.0, LocalDate.of(2024, 12, 30), 2);
		List<Parte> partes = new ArrayList<Parte>();
		partes.add(p1);
		c5.anadeSeguro(s1);
		c5.anadeSeguro(s2);
		c5.setPartes(partes);
		
		aseguradora1.getClientes().add(c5);

		// Serialización a XML
		try {
			marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(aseguradora1, new File("aseguradoraXML.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
