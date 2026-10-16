//Juan Meza - 21297106-5 - icci
package dominio;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Main  {
	public static void main (String[] args) throws IOException{
		File arch = new File("C:/Users/Juan/Documents/taller 2/registro manual/Participantes.txt");
		Scanner lectura = new Scanner(arch);
		String linea = lectura.nextLine(); 
		persona[] amigos = new persona[20];
		int aux = 0;
		while (lectura.hasNextLine()) {
			amigos[aux] = new persona(linea);
			linea = lectura.nextLine(); 
			aux++;
		}
		int opcion = 0;
		int valorRegistros = 0;
		do {
			Scanner key = new Scanner(System.in); //lectura de teclado
			System.out.println("==============================");
			System.out.println("LA FONDA DEL PAPU");
			System.out.println("==============================");
			
			System.out.println("Registros cargados: "+ valorRegistros);
			System.out.println("-------------------------------");
			System.out.println("[1] Ver registros");
			System.out.println("[2] Actualizar registros");
			System.out.println("[3] Calcular metricas");
			System.out.println("[4] Salir");
			System.out.println("==============================");
			System.out.print("Seleccione una opcion: ");
			opcion = key.nextInt();
			if(opcion == 1) {
				System.out.println("se escogio 1");
			}else if (opcion == 2) {
				System.out.println("se escogio 2");
			}else if (opcion == 3) {
				System.out.println("se escogio 3");
			}else if (opcion == 4) {
				System.out.println("se escogio [4] Salir");
			}
		}while(opcion != 4);
	}	

}