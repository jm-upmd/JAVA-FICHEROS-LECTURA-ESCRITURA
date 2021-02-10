package lecturaEscrituraFicheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaFicherosBinario {

	public static void main(String[] args) {
		final String F_ORIGEN = "H:\\Plano Aula.xlsx";
		final String F_DESTINO = "H:\\Copia del Fiechero.xlsx";
		copia (F_ORIGEN,F_DESTINO );
	}
	
	public static void copia (String ficheroOriginal, String ficheroCopia) 
	{
		FileInputStream fileInput;
		BufferedInputStream bufferedInput = null;
		FileOutputStream fileOutput;
		BufferedOutputStream bufferedOutput = null; 
		
		try
		{
            // Se abre el fichero original para lectura.
			
			// FileInputStream se usa para leer ficheros binarios (imagenes, ejecutables, etc.)
			// También puede usarse para leer ficheros de texto byte a byte, pero para estos es
			// mejor usar la clase  FileReader
			
			fileInput = new FileInputStream(ficheroOriginal);
			bufferedInput = new BufferedInputStream(fileInput);
			
			// Se abre el fichero donde se hará la copia
			 fileOutput = new FileOutputStream (ficheroCopia);
			 bufferedOutput = new BufferedOutputStream(fileOutput);
			
			
			 System.out.println("Copiando fichero...");
			 // Bucle para leer de un fichero y escribir en el otro.
			// Utilizamos un array de bytes donde se irán depositando los datos del fichero origen
			// por bufferredInput.read() y de donde serán leídos por burreredOutput.write
			
			byte [] array = new byte[1000];
			
			int leidos = bufferedInput.read(array); // leidos es el numro de bytes leidos y depositados en array
			while (leidos > 0)
			{
				bufferedOutput.write(array,0,leidos); // Lee desde posición 0 tantos elementos como indica leidos
				leidos=bufferedInput.read(array);
			}
			
			System.out.println("Copia realizada");

		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} finally {
			
		}	// Cierre de los ficheros OJO

			try {
				bufferedInput.close();
				bufferedOutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
