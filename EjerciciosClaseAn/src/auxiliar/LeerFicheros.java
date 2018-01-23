package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class LeerFicheros {
	
public void leerFicheroTexto() {
		
		try {
			// Abrir el fichero
			
			FileReader fr = new FileReader("ficheros/personas.txt");
			
			BufferedReader br = new BufferedReader(fr);
			
			String linea;
			
			LocalDate fechaHoy;
			
			System.out.println(LocalDate.now());
			
			// Leer el fichero linea a linea
		
			while ((linea = br.readLine()) != null) {
				
				//linea = br.readLine();
				
				// while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("&&");

				System.out.println(calculaEdad(campos[2]));

			}

			// Cerrar fichero
			 fr.close();
			 br.close();
			 
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		} catch (NullPointerException e) {
			
			System.out.println("EOF");
			
		}
	}

	public int calculaEdad(String fechaNacimiento) { // ddmmaaaa
		
		Calendar cal = Calendar.getInstance();

		int year = Integer.parseInt(fechaNacimiento.substring(4, 8));
		
		int mes = Integer.parseInt(fechaNacimiento.substring(2, 4));
		
		int dia = Integer.parseInt(fechaNacimiento.substring(0, 2));
		
		System.out.println(dia + "," + mes + "," + year);
		
		cal.set(year, mes, dia);
		
		Date hoy = cal.getTime();
		
		// cal.set(1985, Calendar.JANUARY, 30);

		Date birthday = cal.getTime();

		long diferenciaMilisegundos = hoy.getTime() - birthday.getTime();
		
		long time = 1000 * 60 * 60 * 24;
		
		return (int) (diferenciaMilisegundos / time);
	}

}
