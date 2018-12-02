package lecturaEscrituraFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeeFicheroTexto {

	public static void main(String[] args) {
		
		final String RUTA_FICHERO = "O:\\Curso Java\\Proyectos Eclipse\\ExportarImportarProyectoEclipse.txt";
		File archivo = null;
		
			archivo = new File(RUTA_FICHERO);
			
			// Lectura de fichero de texto usando objetos Filereader y BufferedReader
			// Forma tradicional de hacerlo en jdk anteriores al JDK 5
			
			System.out.println("INFORMACIÓN DEL FICHERO:");
			System.out.println("Nombre Fichero: " + archivo.getName() );
			System.out.println("Directorio del fichero: " + archivo.getParent());
			
			

			System.out.println("\n***** Fichero leido con objetos Filereader y BufferedReader.");
			leeFicheroTradicional(archivo);
			
			
			
			// Lectura del fichero con Scanner (disponible a partir de jdk 5)
			System.out.println("\n***** Fichero leido con objeto Scanner");

			leeFicheroConScanner(archivo);


	}
	
	static void leeFicheroTradicional(File fichero){
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero:\n" + fichero.getAbsolutePath());
			
		} catch (IOException e) {
			e.printStackTrace();		
		} finally { // finally siempre se ejecuta tras el try{...}  haya o no excepción
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {  // si se produce error al intentar cerrar fichero.
				e2.printStackTrace();
			}
		}
	}
	
	// Lectura de un fichero de texto usando objeto Scaner. 
	
	
	static void leeFicheroConScanner(File fichero) {
		Scanner scnr = null;
		
		try {
			scnr = new Scanner(fichero); //Se le pasa como parametro el objeto File

			// Leyendo líneas del fichero con Scanner
			
			while (scnr.hasNextLine()) { 		// Mientras queden líneas por leer
				String linea = scnr.nextLine(); //Lee linea
				
				System.out.println(linea);

			}
			
			scnr.close();

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero:\n" + fichero.getAbsolutePath());
		}	
		// No es necesario controlar IOexception.
	}

}
