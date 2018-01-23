package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;


public class Practicas {
	// private static String[] diasSemana = { "lunes", "martes", "miercoles",
	// "jueves", "viernes", "sábado", "domingo" };
	
	// SEGUNDA EVALUACION

	public ArrayList<Estudiante> introListas() {
		
		ArrayList<Estudiante> listaE;
		
		listaE = new ArrayList<Estudiante>();
		
		Estudiante est1 = new Estudiante(123);
		
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		
		Estudiante est2 = new Estudiante(321);
		
		listaE.add(0, est2);
		
		listaE.remove(listaE.size() - 1);
		
		// listaE.set(0, est1);
		
		for (Estudiante estudiante : listaE) {
			
			// System.out.println(estudiante.getCodGrupo());
		}
		
		for (int i = 0; i < listaE.size(); i++) {
			
			// System.out.println(listaE.get(i).getCodGrupo());
		}

		// System.out.println("fin introListas");
		return listaE;

	}

	// Mapas, clase HashMap

public ArrayList<ArrayList<Integer>> convierteMatrizArrayLista(ArrayList<ArrayList<Integer>> matriz){
	
	ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();
	
	int JMAX = 0;
	
	//for(int[] fila : matriz) {
		
		//for(Integer numero : fila) {

	
	// obtenemos el numero maximo de columnas
	for (int i = 0; i < matriz.size(); i++) {
		
		if (matriz.get(i).size() > JMAX)
			
			JMAX = matriz.get(i).size();
	}
	
	for (int j = 0; j < JMAX; j++) {
		
		for (int i = 0; i < matriz.size(); i++) {
			
			try {
				
				System.out.println("[" + i + "][" + j + "]: " + matriz.get(i).get(j).byteValue());
				
			} catch (ArrayIndexOutOfBoundsException e) {
				
				continue;
			}
			
			catch (NullPointerException e) {
				continue;
			}

		}
	}
	
	return resultado;
}
	

// Mapas, clase HashMap

public HashMap<String, Estudiante> introMAPAS(){
	
	//la clave representa el nif del estudiante
	
	HashMap<String, Estudiante> resultado = new HashMap<String, Estudiante>();
	
	 Estudiante est = new Estudiante (123,"435G", "Paco",'M', null,182,null,null);
	
	 resultado.put(est.getNif(), est);
	 resultado.put("123T",new Estudiante(123, "123T", "Pepe", 'M', null, 180, null, null));
	 
	 Estudiante estudiante =resultado.get("435G");
	 
	return null;
	
}
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
				
				linea = br.readLine();
				
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
	
	


public ArrayList<ArrayList<Integer>> convierteMatrizArrayLista(int [][] matriz){
	
	ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();
	
	for(int[] filamatriz : matriz) {
		
		ArrayList<Integer>filalista = new ArrayList<Integer>();
	
	
			for(Integer numero : filamatriz) 
			
				filalista.add (numero);
			
		resultado.add(filalista);

	}
	
	return resultado;
}
	
	public boolean esPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}

		return true;
	}

	public int[] numerosPrimos(int cuantos) {
		int[] primos = new int[cuantos];
		int i = 0;
		int j = 1;
		while (i < cuantos) {
			if (esPrimo(j))
				primos[i++] = j;
			j++;
		}
		return primos;
	}

	public ArrayList<Integer> numerosPrimos(Integer cuantos) {

	 ArrayList<Integer> primos = new ArrayList<Integer>();
	 
		int i = 0;
		
		int j = 1;
		
		while (i < cuantos) {
			
			if (esPrimo(j))
				
				i++;
			
				primos.add(i);
				
				primos.add(j);
			j++;
		}
		
		return primos;
	}

	public int[] numerosFibonacci(int cuantos) {
		int[] numeros = new int[cuantos];
		int x = 0;
		int y = 1;
		int z;
		numeros[0] = x;
		numeros[1] = y;
		for (int i = 2; i < cuantos; i++) {
			z = x + y;
			numeros[i] = z;
			x = y;
			y = z;
		}
		return numeros;
	}

public ArrayList<Integer> numerosFibonacci(Integer cuantos) {
		
		ArrayList<Integer> numeros =  new ArrayList<Integer>();
		
		int x = 0;
		int y = 1;
		int z;
		
		numeros.add(x);
		numeros.add(y);
		
		for (int i = 2; i < cuantos; i++) {
			
			z = x + y;
			
			numeros.add(z);
			
			x = y;
			y = z;
		}
	
		return numeros;
	}

	
	// LIGA: Obtener clasificación a partir de resultados
	public int[] obtenerClasificacion(String[][] goles) {
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int i = 0; i < goles.length; i++)
			for (int j = 0; j < goles[i].length; j++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public int[] obtenerClasificacion2(String[][] goles) {
		// la diferencia con el anterior es que recorre la
		// matriz por columnas
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int j = 0; j < goles[0].length; j++)
			for (int i = 0; i < goles.length; i++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public Equipo[] obtenerClasificacion3(int[][] puntosJornadas) {
		Equipo[] clasificacion = new Equipo[5];
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < puntosJornadas[0].length; j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.length; i++)
				e.setPuntos(e.getPuntos() + puntosJornadas[i][j]);
			clasificacion[j] = e;
		}

		return clasificacion;
	}

	public boolean validarNif(String nif) {
		char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		if (nif.length() != 9)
			return false;
		String numeros = nif.substring(0, 8);
		// System.out.println(numeros);
		int numerosOK;
		try {
			numerosOK = Integer.parseInt(numeros);
		} catch (NumberFormatException e) {
			return false;
		}
		int resto = numerosOK % 23;
		if (letrasValidas[resto] != nif.charAt(8))
			return false;
		return true;
	}

	// ORDENACION
	public void ordenaEnteros(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] > numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
	}

	public void ordenaClasificacion(int[] numeros, String[] equipos) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] < numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
					String aux2 = equipos[i];
					equipos[i] = equipos[j];
					equipos[j] = aux2;
				}
	}
	// mezcla dos arrays ordenados

	public int[] mezclaArrays(int[] l1, int[] l2) {
		int i = 0, j = 0, k = 0;
		int[] resultado = new int[l1.length + l2.length];

		while (l1[i] != Integer.MAX_VALUE || l2[j] != Integer.MAX_VALUE) {
			if (l1[i] < l2[j])
				resultado[k] = l1[i++];
			else
				resultado[k] = l2[j++];
			k++;

			if (i == l1.length)
				l1[--i] = Integer.MAX_VALUE;

			if (j == l2.length)
				l2[--j] = Integer.MAX_VALUE;
		}
		return resultado;
	}

	public void ordenaCadenas(String[] cadenas) {
		for (int i = 0; i < cadenas.length - 1; i++)
			for (int j = i + 1; j < cadenas.length; j++)
				if (cadenas[i].compareTo(cadenas[j]) > 0) {
					String aux = cadenas[i];
					cadenas[i] = cadenas[j];
					cadenas[j] = aux;
				}

	}

	public void ordenaEstudiantes(Estudiante[] estudiantes) {
		// ejemplo de uso de la interfaz Comparable
		// debe implementarse el método compareTo

		for (int i = 0; i < estudiantes.length - 1; i++)
			for (int j = i + 1; j < estudiantes.length; j++)
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					Estudiante aux = estudiantes[i];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}
	}

	public float calculaSaldo(float saldoInicial, float[] movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.length; i++)
			saldoFinal += movimientos[i];
		return saldoFinal;
	}

	public int[] convierteCadenasANumeros(String[] cadenas) {
		
		int[] resultado = new int[cadenas.length];
		
		for (int i = 0; i < resultado.length; i++) {

			try {

				resultado[i] = Integer.parseInt(cadenas[i]);
				
			} catch (NumberFormatException e) {

				resultado[i] = -1;
			}
		}
		return resultado;
	}

	public ArrayList<Integer> convierteCadenasANumeros(ArrayList<String> cadenas) {
		
		
		 ArrayList <Integer> resultados;
		 
		 resultados=new ArrayList<Integer>();
		 
		 for (String cadena: cadenas) {

				try {

					resultados.add( Integer.parseInt(cadena));
					
				} catch (NumberFormatException e) {

					resultados.add(-1);
				}
			}
			return resultados;
		}
		 
	public void muestraNumeros() {

		int x = 0;
		
		while (x <= 1000) {
			
			System.out.println("x: " + x);
			
			x++;
		}
	}

	public void muestraNumeros(int min, int max) {

		if (min <= max) {
			int x = min;
			while (x <= max) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros2(int min, int max) {

		if (min <= max) {
			int x = min;
			do {
				System.out.println("x: " + x);
				x++;
			} while (x <= max);
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros3(int min, int max) {
		int x = min;
		if (min <= max) {
			// for (int x = min; x < max; x++) {
			// for (;;) {
			while (true) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void generaAleatorios(int cuantos, int inferior, int superior) // max 30, min 10
	{

		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + (int) (Math.random() * (superior - inferior + 1)));

	}

	public void generaAleatorios2(int cuantos, int inferior, int superior) // max 30, min 10
	{

		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
	}

	public int[] generaAleatorios3(int cuantos, int inferior, int superior) // max 30, min 10
	{
		int[] resultado = new int[cuantos];
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			// System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
			resultado[i] = inferior + rnd.nextInt(superior - inferior + 1);
		return resultado;
	}

	public int[] frecuenciaAparicion(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamientos = this.generaAleatorios3(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.length; i++) {
			resultado[lanzamientos[i] - 1]++;
		}
		return resultado;

	}

	public void estadisticaCadena(String cadena) {
		int contadorVocales = 0;
		int contadorMayusculas = 0;
		int contadorEspeciales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o'
					|| cadena.charAt(i) == 'u' || cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E'
					|| cadena.charAt(i) == 'I' || cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U')
				contadorVocales++;
			if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z')
				contadorMayusculas++;
			int caracterAscii = cadena.charAt(i);
			if ((caracterAscii >= 0 && caracterAscii <= 47) || (caracterAscii >= 58 && caracterAscii <= 64) ||

					(caracterAscii >= 91) && (caracterAscii <= 96))

				contadorEspeciales++;
		}
		// System.out.println("Hay " + contadorVocales + " vocales en " + cadena);
		System.out.println("Hay " + contadorEspeciales + " caracteres especiales en " + cadena);

	}

	public void listaDiasSemana() {
		Datos datos = new Datos();
		// String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes",
		// "sábado", "domingo" };
		// for (int i = 0; i < datos.getDiasSemana().length; i++)
		for (String dia : datos.getDiasSemana())
			// System.out.println(datos.getDiasSemana()[i]);
			System.out.println(dia);
	}

	public void listaEstudiantes(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public int visitantesIslaYear(int isla, int[][] v) {
		int acu = 0;
		for (int j = 0; j < v[0].length; j++)
			acu += v[isla][j];
		return acu;
	}

	public 	Integer visitantesIslaYear(Integer isla,  ArrayList<ArrayList<Integer>> v) {
		int acu = 0;
		for (int j = 0; j < v.get(0).size(); j++)
			acu += v.get(isla).get(j);
		return acu;
	}
	
	public int visitantesMesYear(int mes, int[][] v) {
		int acu = 0;
		for (int i = 0; i < v.length; i++)
			acu += v[i][mes];
		return acu;
	}
	
	public Integer visitantesMesYear(Integer mes, ArrayList<ArrayList<Integer>> v) {
		int acu = 0;
		for (int i = 0; i < v.size(); i++)
			acu += v.get(i).get(mes);
		return acu;
	}
	
	public int visitantesMesYear(int mes, ArrayList<ArrayList<Integer>> v) {
		int acu = 0;
		for (int i = 0; i < v.size(); i++)
			acu += v.get(i).get(mes);
		return acu;
	}

	public void recorrerMatrizIrregularPorColumnas(int[][] matriz) {
		
		int JMAX = 0;
		
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			
			if (matriz[i].length > JMAX)
				
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			
			for (int i = 0; i < matriz.length; i++) {
				
				try {
					
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j]);
					
				} catch (ArrayIndexOutOfBoundsException e) {
					
					continue;
				}

			}
		}
	}
	
	public void recorrerMatrizIrregularPorColumnas(ArrayList<ArrayList<Integer>> matriz) {
		
		int JMAX = 0;
		
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.size(); i++) {
			
			if (matriz.get(i).size() > JMAX)
				
				JMAX = matriz.get(i).size();
		}

		for (int j = 0; j < JMAX; j++) {
			
			for (int i = 0; i < matriz.size(); i++) {
				
				try {
					
					System.out.println("[" + i + "][" + j + "]: " + matriz.get(i).get(j));
					
				} catch (ArrayIndexOutOfBoundsException e) {
					
					continue;
				}

			}
		}
	}

	
	public void recorrerMatrizIrregularPorColumnas2(Integer[][] matriz) {
		
		int JMAX = 0;
		
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			
			if (matriz[i].length > JMAX)
				
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			
			for (int i = 0; i < matriz.length; i++) {
				
				try {
					
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j].byteValue());
					
				} catch (ArrayIndexOutOfBoundsException e) {
					
					continue;
				}
				
				catch (NullPointerException e) {
					continue;
				}

			}
		}
	}
	
public void recorrerMatrizIrregularPorColumnas2(ArrayList<ArrayList<Integer>> matriz) {
		
		int JMAX = 0;
		
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.size(); i++) {
			
			if (matriz.get(i).size() > JMAX)
				
				JMAX = matriz.get(i).size();
		}
		for (int j = 0; j < JMAX; j++) {
			
			for (int i = 0; i < matriz.size(); i++) {
				
				try {
					
					System.out.println("[" + i + "][" + j + "]: " + matriz.get(i).get(j).byteValue());
					
				} catch (ArrayIndexOutOfBoundsException e) {
					
					continue;
				}
				
				catch (NullPointerException e) {
					continue;
				}

			}
		}
	}
	
}
