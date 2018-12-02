package lecturaEscrituraFicheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopiaFicherosBinario {

	public static void main(String[] args) {
		final String F_ORIGEN = "F:\\\\Curso Java\\\\Proyectos Eclipse\\\\ficheroOut.txt";
		final String F_DESTINO = "F:\\Curso Java\\Proyectos Eclipse\\ficheroOut.copia.txt";
		copia (F_ORIGEN,F_DESTINO );
	}
	
	public static void copia (String ficheroOriginal, String ficheroCopia)
	{
		try
		{
            // Se abre el fichero original para lectura.
			
			// FileInputStream se usa para leer ficheros binarios (imagenes, ejecutables, etc.)
			// También puede usarse para leer ficheros de texto byte a byte, pero para estos es
			// mejor usar la clase  FileReader
			
			FileInputStream fileInput = new FileInputStream(ficheroOriginal);
			BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
			
			// Se abre el fichero donde se hará la copia
			FileOutputStream fileOutput = new FileOutputStream (ficheroCopia);
			BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
			
			// Bucle para leer de un fichero y escribir en el otro.
			byte [] array = new byte[1000];
			int leidos = bufferedInput.read(array);
			while (leidos > 0)
			{
				bufferedOutput.write(array,0,leidos);
				leidos=bufferedInput.read(array);
			}

			// Cierre de los ficheros
			bufferedInput.close();
			bufferedOutput.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
