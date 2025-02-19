package es.unican.ss.Practica1.main;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.unican.ss.Practica1.domain.Aseguradora;

public class AseguradoraMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			//Deseralización de un fichero
			Aseguradora aseguradora = mapper.readValue(new File("C:\\Users\\lucia\\OneDrive\\Escritorio\\SERVICIOS\\Practica1\\src\\main\\resources\\datos\\segurosUC.json"), Aseguradora.class);
			//Seralización de un fichero.
			mapper.writeValue(new File("C:\\Users\\lucia\\OneDrive\\Escritorio\\SERVICIOS\\Practica1\\src\\main\\resources\\datos\\aseguradoraUC.json"), aseguradora);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
