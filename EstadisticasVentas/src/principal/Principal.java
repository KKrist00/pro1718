package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import auxiliar.Practicas;

public class Principal {
	// metodo por el que debe empezar la ejecución ..
	public static void main(String[] args) {
		
		HashMap<String, ArrayList<Float>> hm = Practicas.resumenVentasVendedor("ficheros/ventas.txt");

	}
}