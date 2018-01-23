package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Practicas {

		public static HashMap<String, ArrayList<Float>> resumenVentasVendedor(String ficheroVentas) {
			
			HashMap<String, ArrayList<Float>> resultado = new HashMap<String, ArrayList<Float>>();
		
				try {
		
					// Abrir el fichero
					
					FileReader fr = new FileReader(ficheroVentas);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					
					int acumulado = 0;
					int contador = 0;
					
					while ((linea = br.readLine()) != null) {
		 				String[] campos = linea.split("%");
		 				
						if (resultado.get(campos[1]) == null)
							resultado.put(campos[1], new ArrayList<Float>());
						resultado.get(campos[1]).add(Float.parseFloat((campos[2])));
				}
		
					fr.close();
					
				br.close();
				
		   	} catch (FileNotFoundException e) {
		   		
				System.out.println(e.getMessage());
				
				} catch (IOException e) {
					
					System.out.println(e.getMessage());
					
				}
				
				return resultado;
			}
		
	public HashMap<String,Float> resumenVentasPorVendedor( HashMap<String, ArrayList<Float>> ventas){
		
			HashMap<String, Float> resultado = new HashMap<String,Float>();
			
			// recorrer hm de entrada creando el de salida
		
			
			return resultado;	
		}
	
}
