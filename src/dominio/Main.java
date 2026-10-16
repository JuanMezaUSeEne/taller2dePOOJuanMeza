//Juan Meza - 21297106-5 - icci
package dominio;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Main  {
	public static void main (String[] args) throws IOException{
		
		
		//RUTAS: son variables que se usan para determinar la ruta de los archivos que se leeran, asi cuando esten probando con distintas entradas solo tengan que cambiar la ruta en estas 2 variables
		//ruta1:la ruta del archivo de Participantes.txt
		//ruta2: la ruta de los registros Consumidos.txt
		String ruta1 = "C:/Users/Juan/Documents/taller 2/registro manual/Participantes.txt";
		String ruta2 = "C:/Users/Juan/Documents/taller 2/registro manual/Consumido.txt";
		
		
		
		File arch = new File(ruta1); //el archivo de las personas que participan
		Scanner lectura = new Scanner(arch);
		String linea = lectura.nextLine(); 
		persona[] amigos = new persona[200];
		int aux = 0;
		while (lectura.hasNextLine()) {
			amigos[aux] = new persona(linea);
			linea = lectura.nextLine(); 
			
		}//algoritmo para crear instancia de los amigos y almacenarlos en un vector
		
		
		
		choripan pruebaChoripan = new choripan("nose", 1, 1);
		
		amigos[0].setChoripanes(pruebaChoripan, 0);
		
		System.out.println("aqui deberia haber un choripan"+ amigos[0].getChoripanes(0).getFecha());
		
		
		
		
		
		
		
		
		
		//for (int i = 0; i<aux; i++) {
		//	System.out.println(amigos[i].getNombre()); //probando si el algoritmo creo y almaceno los nombres de las instancias de amigos
		//}
		
		
		//aqui se leen los registros por primera vez para tener los registros cargados
		File arch2 = new File(ruta2);//SEGUNDO ARCHIVO CON LOS REGISTROS DE LOS CHORIPANES Y TERREMOTOS
		Scanner lectura2 = new Scanner(arch2);
		String linea2 = lectura2.nextLine();
		aux = 1;
		while (lectura2.hasNextLine()) {
			aux++;
			linea2 = lectura2.nextLine();
		}
		
		
		String opcion;
		int valorRegistros = aux;
		
		
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
			opcion = key.nextLine();
			
			
			if(opcion.equals("1")) {
				aux = 0;
				//aqui se inicia denuevo el proceso de lectura
				
				System.out.println();
				
				System.out.print("aqui se ve si es choripan o terremoto");
				opcion = key.nextLine();
				
				arch2 = new File(ruta2);//SEGUNDO ARCHIVO CON LOS REGISTROS DE LOS CHORIPANES Y TERREMOTOS
				lectura2 = new Scanner(arch2);
				linea2 = lectura2.nextLine();
				String[] partes = linea2.split(";");
				while (lectura2.hasNextLine()) {
					
					linea2 = lectura2.nextLine(); 
					partes = linea2.split(";");
					if(opcion.equals("1")) {
						if(partes[0].equals("Choripan")) {
							aux++;
							System.out.println(linea2);
							System.out.println(partes[0] + partes[1] + " "+ partes[4]);
							
						}
					}
					
					
				}//ingreso de datos de completos y terremotos comidos
				System.out.println("choripanes comidos"+ aux);
				System.out.println();
				
			}else if (opcion.equals("2")) {
				
				System.out.println();
				System.out.println("se escogio 2");
				System.out.println();
				
			}else if (opcion.equals("3")) {
				
				System.out.println();
				System.out.println("se escogio 3");
				System.out.println();
				
			}else if (opcion.equals("4")) {
				
				System.out.println();
				System.out.println("se escogio [4] Salir");
				System.out.println();
				
			}else {
				System.out.println();
				System.out.println("opcion invalida, por favor ingrese de nuevo");
				System.out.println();
			}

		}while(!opcion.equals("4"));
		
	}	

}
