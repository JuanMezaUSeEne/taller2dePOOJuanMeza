package logica;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Main  {
	public static void main (String[] args) throws IOException{
		//File arch = new File();
		//Scanner lectura = new Scanner(arch);
		int opcion = 0;
		do {
			Scanner key = new Scanner(System.in);
			System.out.println("==============================");
			System.out.println("LA FONDA DEL PAPU");
			System.out.println("==============================");
			int valorRegistros = 0;
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
