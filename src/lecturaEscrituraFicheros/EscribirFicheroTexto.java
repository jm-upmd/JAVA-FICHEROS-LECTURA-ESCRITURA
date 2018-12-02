package lecturaEscrituraFicheros;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirFicheroTexto {

	public static void main(String[] args) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("F:\\Curso Java\\Proyectos Eclipse\\ficheroOut.txt");
            
            /* Para añadir al final de un fichero ya existente
             * FileWriter fichero = new FileWriter("c:/fichero.txt",true);
             */
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Escribiendo en el fichero la línea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {  // finally siempre se ejecuta tras el try haya o no excepción
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

}
