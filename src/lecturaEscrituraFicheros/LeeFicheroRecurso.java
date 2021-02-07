package lecturaEscrituraFicheros;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Scanner;


public class LeeFicheroRecurso {

	public static void main(String[] args)  {
		
		leeFicheroRecurso("ejemplo_fichero_recurso.txt");
	}
	
	static void leeFicheroRecurso(String nombre) {
		
	String fichRecurso = "/" + nombre; 	
		
	// Obtenemos referencia al fichero de recurso
	InputStream is = LeeFicheroRecurso.class.getResourceAsStream(fichRecurso);

	/*
	 * Otra forma de obtener referencia al fichero de recurso. 
	 * Es decir, de hacer lo mismo de arriba 
	 * 
	 * ClassLoader loader = JuegoAhorcado.class.getClassLoader();
	 * InputStream is=null; 
	 * try { 
	 * 	is = loader.getResource("palabras.txt").openStream(); 
	 * } catch (IOException e) { 
	 * 	e.printStackTrace(); 
	 * }
	 */
	if (is == null) 
		throw new MissingResourceException("No se encuentra fichero de recurso","LeeFicheroRecurso",fichRecurso);
	
	Scanner sc = new Scanner(is);
	
	System.out.println("** Leyendo fichero de recurso:");
	while (sc.hasNextLine()) {
		System.out.println(sc.nextLine());
	}
	
	sc.close();
	
	}
}
