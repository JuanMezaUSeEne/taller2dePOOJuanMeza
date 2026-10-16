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
		String ruta1 = "Participantes.txt";
		String ruta2 = "a.txt";
		
		
		
		File arch = new File(ruta1); //el archivo de las personas que participan
		Scanner lectura = new Scanner(arch);
		String linea = lectura.nextLine(); 
		persona[] amigos = new persona[200];
		int aux = 0;
		if(!linea.equals("")){
		    amigos[aux] = new persona(linea);
		}
		while (lectura.hasNextLine()) {
			aux++;
			linea = lectura.nextLine(); 
			amigos[aux] = new persona(linea);
			
			
			
		}//algoritmo para crear instancia de los amigos y almacenarlos en un vector
		
		

		
		//System.out.println("aqui deberia haber un choripan"+ amigos[0].getChoripanes(0).getFecha());
		
		
		
		
		
		
		
		
		//for (int i = 0; i<aux; i++) {
		//	System.out.println(amigos[i].getNombre()); //probando si el algoritmo creo y almaceno los nombres de las instancias de amigos
		//}
		
		
		//aqui se leen los registros por primera vez para tener los registros cargados
		File arch2 = new File(ruta2);//SEGUNDO ARCHIVO CON LOS REGISTROS DE LOS CHORIPANES Y TERREMOTOS
		Scanner lectura2 = new Scanner(arch2);
		String linea2 = lectura2.nextLine();
		String[] partes = linea2.split(";");
		
		String tipo ;
		String nombre;
		String valor1;
		
		int ancho;
		int largo;
		
		
		
		aux = 0;
		int index;
		
		//aqui se inicia el while donde se ingresan los datos
		while (lectura2.hasNextLine()) {
		    System.out.println(linea2);
			if(partes.length == 4 || partes.length == 5 ) {
				tipo = partes[0];
				nombre = partes[1];
				valor1 = partes[2];
				
				if(tipo.equals("Choripan")) {
					largo = Integer.valueOf(valor1);
					ancho = Integer.valueOf(partes[3]);
					choripan pruebaChoripan = new choripan(partes[4],largo ,ancho);
					//index va a ser el indice para ubicar en que parte de la lista amigos se encuentra la persona actual
					index = buscarNombre(nombre, amigos);
					amigos[index].setChoripanes(pruebaChoripan, amigos[index].getIndexContadorChoripanTerremoto(0));
					amigos[index].sumarChoripanTerremoto(0);
					System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(0)+ " choripanes");
					
				}else if((tipo.equals("Terremoto"))){
				    float LT = Float.valueOf(valor1);
				    Terremotos elterremoto = new Terremotos(LT, partes[3]);
					index = buscarNombre(nombre, amigos);
					amigos[index].setTerremotos(elterremoto, amigos[index].getIndexContadorChoripanTerremoto(1));
					amigos[index].sumarChoripanTerremoto(1);
					System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(1)+ " terremotos");
				}
			}
			aux++;
			linea2 = lectura2.nextLine();
			partes = linea2.split(";");
			
			
			System.out.println(aux);
			
			
		}//aqui termina el while donde se ingresan los datos
		
		
		
		//inicia el if para ingresar los datos de la ultima linea que no se ingresaron dentro del while
		if(partes.length == 4 || partes.length == 5 ) {
				tipo = partes[0];
				nombre = partes[1];
				valor1 = partes[2];
				
				if(tipo.equals("Choripan")) {
					largo = Integer.valueOf(valor1);
					ancho = Integer.valueOf(partes[3]);
					choripan pruebaChoripan = new choripan(partes[4],largo ,ancho);
					//index va a ser el indice para ubicar en que parte de la lista amigos se encuentra la persona actual
					index = buscarNombre(nombre, amigos);
					amigos[index].setChoripanes(pruebaChoripan, amigos[index].getIndexContadorChoripanTerremoto(0));
					amigos[index].sumarChoripanTerremoto(0);
					System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(0)+ " choripanes");
					
				}else if((tipo.equals("Terremoto"))){
				    float LT = Float.valueOf(valor1);
				    Terremotos elterremoto = new Terremotos(LT, partes[3]);
					index = buscarNombre(nombre, amigos);
					amigos[index].setTerremotos(elterremoto, amigos[index].getIndexContadorChoripanTerremoto(1));
					amigos[index].sumarChoripanTerremoto(1);
					System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(1)+ " terremotos");
				}
			}// termina el if
		
		
		
		
		
		
		System.out.println(amigos[0].getNombre()+ " se comio "+ amigos[0].getIndexContadorChoripanTerremoto(0)+ " choripanes y "+ amigos[0].getIndexContadorChoripanTerremoto(1)+ " terremotos");
		String opcion;
		int valorRegistros = aux+1;
		
		
		
		
		//la interfaz de usuario
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
				System.out.println();
				System.out.println("se escogio 1");
				System.out.println();
				
				System.out.println("estas son las kcal "+amigos[0].getChoripanes(0).getKcal());							
				
					
					
					

				
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

	
	
	
	//una funcion para buscar el indice del nombre del participante en el vector amigos[]
	public static int buscarNombre( String objetivo, persona[] lista) {
		
		int a = 0;
		for(a = 0; a<200; a++) {
			
			if(lista[a].getNombre().equals(objetivo)) {
				break;
			}
		}
		return a;
	}
	
}
