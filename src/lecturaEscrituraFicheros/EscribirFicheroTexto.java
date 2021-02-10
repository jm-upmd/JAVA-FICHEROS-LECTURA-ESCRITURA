package lecturaEscrituraFicheros;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirFicheroTexto {

	public static void main(String[] args) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("D:\\ficheroOut.txt");

			/*
			 * Para añadir al final de un fichero ya existente FileWriter fichero = new
			 * FileWriter("c:/fichero.txt",true);
			 */
			pw = new PrintWriter(fichero);

			// Escribimos 10 líneas en fichero.
			for (int i = 0; i < 10; i++)
				pw.println("Escribiendo en el fichero la línea " + i);
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // finally siempre se ejecuta tras el try haya o no excepción
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	// Como FileWriter implementa la interface Autocloseable podemos
	// usar el bloque try como aquí abajo.
	// De esta forma no es necesario que nosotros nos preocupemos por cerrar
	// el recurso si se produce una excepción ya que se hace automáticamente.

	static void escribeFicheroV2(String nombre, String texto, int veces) {

		try (FileWriter fichero = new FileWriter(nombre); PrintWriter pw = new PrintWriter(fichero)) {


			// Escribimos líneas en fichero.
			for (int i = 1; i <= veces; i++) {
				pw.println(texto);
			}

			// *** fichero.close(); No hace falta, se cierra solo al terminar el catch

		} catch (Exception e) {

			e.printStackTrace();

		}

		// *** No hace falta el fynally para cerrar Filewriter ya que se cierra
		// automáticamente tras la ejecución del try, haya error o no.
	}

}
