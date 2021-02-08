package lecturaEscrituraFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeeFicheroTexto {

	public static void main(String[] args) {
		
		final String RUTA_FICHERO = "H:\\Cursos Actuales\\Curso Java\\Proyectos Eclipse\\ExportarImportarProyectoEclipse.txt";
		
		File archivo = null;
		
			archivo = new File(RUTA_FICHERO);
			
			
			
			System.out.println("INFORMACIÓN DEL FICHERO:");
			System.out.println("Nombre Fichero: " + archivo.getName() );
			System.out.println("Directorio del fichero: " + archivo.getParent());
			
			// Lectura de fichero de texto usando objetos Filereader y BufferedReader
			// Forma tradicional de hacerlo en jdk anteriores al JDK 5

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
			
			// Si queremos indicar tipo de codificación del fichero
			 // br = new BufferedReader( new InputStreamReader( new FileInputStream(fichero), "UTF8"));

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
	
	
    /* Versiones de los métodos anteriores con bloque try() special para objetos 
	   que implementan interface Autocloseable.
	   Al abrir así recursos que implementan esta interface, no es necesario que
	   nosotros los cerremos luego con close. Tanto si se produce una excepción como
	   si no, se ejecutará automáticamente el close al salir del bloque try.
	*/
	 
	
	static void leeFicheroTradicionalV2(File fichero){
		

		// Utilizamos try ()
		try(FileReader fr = new FileReader(fichero); BufferedReader br = new BufferedReader(fr)) {

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero:\n" + fichero.getAbsolutePath());
			
		} catch (IOException e) {
			e.printStackTrace();		
		} 
		
		// No es necesaria bloque fynally
	}
	
	static void leeFicheroConScannerV2(File fichero) {
		
		
		try (Scanner scnr = new Scanner(fichero); ){
			// Leyendo líneas del fichero con Scanner
			
			while (scnr.hasNextLine()) { 		// Mientras queden líneas por leer
				String linea = scnr.nextLine(); //Lee linea
				
				System.out.println(linea);

			}
			
			//scnr.close(); no cecesario, se cierra automaticamente al terminar el try

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero:\n" + fichero.getAbsolutePath());
		}	
		
		// No es necesario controlar IOexception lo gestiona Scanner.
	}

}
