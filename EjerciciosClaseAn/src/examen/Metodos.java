package examen;

import java.util.Random;

import modelo.Libro;
import modelo.Vehiculo;

public class Metodos {
	
//ejercicio 1	
	
public boolean metodo1(String[] nifs) {
	
	char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
			'V', 'H', 'L', 'C', 'K', 'E' };

	if (nifs.length != 9)
		
		return false;
	
	String numeros = nifs.toString();
	
	int numerosOK;
	
	try {
		
		numerosOK = Integer.parseInt(numeros);
		
	} catch (NumberFormatException e) {
		
		return false;
	}
	
	int resto = numerosOK % 23;
	
	if (letrasValidas[resto] != nifs.length)
		
		return false;
	
	return true;

}

	// ejercicio 2

public Vehiculo[] metodo2(String[] vehiculos) {
	
	 Vehiculo[] resultado = new Vehiculo[vehiculos.length];
	 
	 for (int i = 0; i < resultado.length; i++) {
		 
			try {
				String[] VehiculosCadena = vehiculos[i].split("@");
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setId(Integer.parseInt(VehiculosCadena[0]));
				vehiculo.setMarca(VehiculosCadena[1]);
				vehiculo.setModelo(VehiculosCadena[2]);
				vehiculo.setPrecio(Float.parseFloat(VehiculosCadena[3]));
				resultado[i]=vehiculo;
				
			} catch (NumberFormatException e) {
				
				return null;
				
			}
		}
	 
	 return resultado;
}
	
	// ejercicio 3
	

	public int[][] metodo3(int partidas, int jugadores){
		
		int[][] resultado = new int[jugadores][partidas];
		Random rnd = new Random();
		
		for (int j = 0; j < jugadores; j++) {
			for (int i = 0; i < resultado.length; i++) {
				resultado[i][j]=1 + rnd.nextInt(6);
			}
		}
		
		
		return resultado;
	}
		
	
}
