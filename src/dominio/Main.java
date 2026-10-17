//Juan Meza - 21297106-5 - icci
package dominio;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main  {
	public static void main (String[] args) throws IOException{
		
		
		//RUTAS: son variables que se usan para determinar la ruta de los archivos que se leeran, asi cuando esten probando con distintas entradas solo tengan que cambiar la ruta en estas 2 variables
		//ruta1:la ruta del archivo de Participantes.txt
		//ruta2: la ruta de los registros Consumidos.txt
		String ruta1 = "C:/Users/Juan/Documents/taller 2/registro manual/Participantes.txt";
		String ruta2 = "C:/Users/Juan/Documents/taller 2/registro manual/Consumidoo.txt";
		
		String opcion;
		
		File arch = new File(ruta1); //el archivo de las personas que participan
		Scanner lectura = new Scanner(arch);
		String linea = lectura.nextLine(); 
		persona[] amigos = new persona[200];
		Consumidos[] listaConsumo = new Consumidos[200];
		
		int aux1 = 0;
		if(!linea.equals("")){
		    amigos[aux1] = new persona(linea);
		}
		while (lectura.hasNextLine()) {
			aux1++;
			linea = lectura.nextLine(); 
			amigos[aux1] = new persona(linea);
			
			
			
		}//algoritmo para crear instancia de los amigos y almacenarlos en un vector
		
		

		
		//System.out.println("aqui deberia haber un choripan"+ amigos[0].getChoripanes(0).getFecha());
		
		
		
		int aux = 0;
		
		
		
		
		//for (int i = 0; i<aux; i++) {
		//	System.out.println(amigos[i].getNombre()); //probando si el algoritmo creo y almaceno los nombres de las instancias de amigos
		//}
		
		
		//aqui se leen los registros por primera vez para tener los registros cargados
		do {			
		File arch2 = new File(ruta2);//SEGUNDO ARCHIVO CON LOS REGISTROS DE LOS CHORIPANES Y TERREMOTOS
		Scanner lectura2 = new Scanner(arch2);
		String linea2 = lectura2.nextLine();
		String[] partes = linea2.split(";");
		
		String tipo ;
		String nombre;
		String valor1;
		String fechaAux;
		
		int ancho;
		float largo = 0;
		int index;
		aux = 0;
		int valorRegistros = 0;
	
		
		
		
		//aqui se inicia el while donde se ingresan los datos
		while (lectura2.hasNextLine()) {
		    //System.out.println(linea2);
			if(partes.length == 4 || partes.length == 5 ) {
				tipo = partes[0];
				nombre = partes[1];
				valor1 = partes[2];
				
				if(tipo.equals("Choripan")) {
				    fechaAux = partes[4];
					largo = Float.valueOf(valor1);
					ancho = Integer.valueOf(partes[3]);
					choripan pruebaChoripan = new choripan(fechaAux,largo ,ancho, aux+1);
					//index va a ser el indice para ubicar en que parte de la lista amigos se encuentra la persona actual
					index = buscarNombre(nombre, amigos);
					amigos[index].setChoripanes(pruebaChoripan, amigos[index].getIndexContadorChoripanTerremoto(0));
					amigos[index].sumarChoripanTerremoto(0);
					//System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(0)+ " choripanes");
					listaConsumo[aux] = new Consumidos(amigos[index], partes[0],largo , ancho, fechaAux);
					
					
				}else if((tipo.equals("Terremoto"))){
				    fechaAux = partes[3];
				    largo = Float.valueOf(valor1);
				    
				    Terremotos elterremoto = new Terremotos(largo, fechaAux, aux+1);
					index = buscarNombre(nombre, amigos);
					amigos[index].setTerremotos(elterremoto, amigos[index].getIndexContadorChoripanTerremoto(1));
					amigos[index].sumarChoripanTerremoto(1);
					//System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(1)+ " terremotos");
					ancho = 0;
					listaConsumo[aux] = new Consumidos(amigos[index], partes[0],largo , ancho, fechaAux);
				}
				
				
			}
			
			
			
			aux++;
			
			linea2 = lectura2.nextLine();
			partes = linea2.split(";");
			
			
			
			
			
		}//aqui termina el while donde se ingresan los datos
		
		
		
		//inicia el if para ingresar los datos de la ultima linea que no se ingresaron dentro del while
		
		//System.out.println(linea2);
		if(partes.length == 4 || partes.length == 5 ) {
				tipo = partes[0];
				nombre = partes[1];
				valor1 = partes[2];
				
				if(tipo.equals("Choripan")) {
				    fechaAux = partes[4];
					largo = Float.valueOf(valor1);
					ancho = Integer.valueOf(partes[3]);
					choripan pruebaChoripan = new choripan(fechaAux,largo ,ancho, aux+1);
					
					//index va a ser el indice para ubicar en que parte de la lista amigos se encuentra la persona actual
					
					index = buscarNombre(nombre, amigos);
					amigos[index].setChoripanes(pruebaChoripan, amigos[index].getIndexContadorChoripanTerremoto(0));
					amigos[index].sumarChoripanTerremoto(0);
					//System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(0)+ " choripanes");
					listaConsumo[aux] = new Consumidos(amigos[index], partes[0],largo , ancho, fechaAux);
					
					
				}else if((tipo.equals("Terremoto"))){
				    fechaAux = partes[3];
				    largo = Float.valueOf(valor1);
				    
				    Terremotos elterremoto = new Terremotos(largo, fechaAux, aux+1);
					index = buscarNombre(nombre, amigos);
					amigos[index].setTerremotos(elterremoto, amigos[index].getIndexContadorChoripanTerremoto(1));
					amigos[index].sumarChoripanTerremoto(1);
					//System.out.println(amigos[0].getNombre()+ " lleva "+ amigos[index].getIndexContadorChoripanTerremoto(1)+ " terremotos");
					ancho = 0;
					listaConsumo[aux] = new Consumidos(amigos[index], partes[0],largo , ancho, fechaAux);
				}
				
				
			}
		
		
		
		// termina el if
		
		
		
		//System.out.println(amigos[0].getNombre()+ " se comio "+ amigos[0].getIndexContadorChoripanTerremoto(0)+ " choripanes y "+ amigos[0].getIndexContadorChoripanTerremoto(1)+ " terremotos");
		
		valorRegistros += aux+1;
		
		
		
		
		//la interfaz de usuario
		
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
			
			
			if(opcion.equals("1")) {//OPCION 1 DEL MENU
			    do{
			        System.out.println("");
			        
    				System.out.println("============ VER REGISTROS =================");
    				System.out.println("  [1] Choripanes");
    				System.out.println("  [2] Terremotos");
    				System.out.println("  [3] Volver al menu principal");
    				System.out.println("============================================");
    				System.out.print("Seleccione una opcion: ");
    				opcion = key.nextLine();
    				if(!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3"))){
    				    System.out.println("mensaje de error no se ingreso una  opcion valida, intentar de nuevo");
    				}
			    }while(!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3")));
			    
										
				System.out.println("");
				
				if(opcion.equals("1")){
				    System.out.println("");
				    System.out.println("=============== CHORIPANES =================");
				    System.out.println("  #   Consumidor    Largo    Ancho   Fecha         KCal");
				    
				    
				    //aqui se muestra el registro
				    int aux2= 1;
				    float maxlitros=0;
				    for(int i = 1; i<=valorRegistros; i++){//aqui se muestra el registro
				        if(listaConsumo[i-1].getTipo().equals("Choripan")){
				            //System.out.println("  " + aux2 + "   " + listaConsumo[i-1].getPersonaConsumo().getNombre() + "   " + listaConsumo[i-1].getDato1() + " L   " + listaConsumo[i-1].getFechaConsumo()+ "    "+ Math.round(listaConsumo[i-1].getKcals() * 100.0) / 100.0);
				        	System.out.print("  "+ aux2);
				        	mostrarOrdenadito(String.valueOf(aux2),listaConsumo[i-1].getPersonaConsumo().getNombre() , 1,4);
				        	mostrarOrdenadito(listaConsumo[i-1].getPersonaConsumo().getNombre(),String.valueOf(listaConsumo[i-1].getDato1())+"  cm",1,14);
				        	mostrarOrdenadito(String.valueOf(listaConsumo[i-1].getDato1())+" cm",String.valueOf(listaConsumo[i-1].getDato2())+" cm",1,8);
				        	mostrarOrdenadito(String.valueOf(listaConsumo[i-1].getDato2()),listaConsumo[i-1].getFechaConsumo(),1 ,5);
				        	mostrarOrdenadito(listaConsumo[i-1].getFechaConsumo(),String.valueOf(listaConsumo[i-1].getKcals()),0,14);
				        	aux2++;
				            maxlitros = maxlitros + listaConsumo[i-1].getDato1();
				        }
				    }
				    
				    
				    System.out.println("--------------------------------------------------");
				    System.out.println("  Total: "+ aux2 +" choripanes registrados");
				    System.out.println("==================================================");
				    System.out.println("");
				    System.out.print("Presione ENTER para continuar...");
				    opcion = key.nextLine();
				    opcion = "";
				    
				    
				}else if(opcion.equals("2")){
				    System.out.println("");
				    System.out.println("=============== TERREMOTOS =================");
				    System.out.println("  #   Consumidor    Litros   Fecha         KCal");
				    
				    
				    
				    int aux2= 1;
				    float maxlitros=0;
				    for(int i = 1; i<=valorRegistros; i++){//aqui se muestra el registro
				        if(listaConsumo[i-1].getTipo().equals("Terremoto")){
				            //System.out.println("  " + aux2 + "   " + listaConsumo[i-1].getPersonaConsumo().getNombre() + "   " + listaConsumo[i-1].getDato1() + " L   " + listaConsumo[i-1].getFechaConsumo()+ "    "+ Math.round(listaConsumo[i-1].getKcals() * 100.0) / 100.0);
				        	System.out.print("  "+ aux2);
				        	mostrarOrdenadito(String.valueOf(aux2), listaConsumo[i-1].getPersonaConsumo().getNombre(), 1, 4);
				        	mostrarOrdenadito(listaConsumo[i-1].getPersonaConsumo().getNombre(), String.valueOf(listaConsumo[i-1].getDato1())+" LT", 1, 14);
				        	mostrarOrdenadito(String.valueOf(listaConsumo[i-1].getDato1())+" LT",listaConsumo[i-1].getFechaConsumo() , 1,9  );
				        	mostrarOrdenadito(listaConsumo[i-1].getFechaConsumo(),String.valueOf(listaConsumo[i-1].getKcals()) , 0,14  );
				            aux2++;
				            maxlitros = maxlitros + listaConsumo[i-1].getDato1();
				        }
				    }
				    System.out.println("--------------------------------------------------");
				    System.out.println("  Total:"+ aux2 +  " terremotos registrados ("+ maxlitros+ " L)");
				    System.out.println("==================================================");
				    System.out.println("");
				    System.out.print("Presione ENTER para continuar...");
				    opcion = key.nextLine();
				    opcion = "";
				}
					
					

				
			}else if (opcion.equals("2")) {//ACTUALIZAR REGISTROS
				
				do {
					System.out.println();
					System.out.println("========== ACTUALIZAR REGISTROS ============");
					System.out.println("  [1] Agregar");
					System.out.println("  [2] Editar");
					System.out.println("  [3] Eliminar");
					System.out.println("  [4] Volver al menu principal");
					System.out.println("============================================");
					System.out.print("Seleccione una opcion: ");
					opcion = key.nextLine();
					if(!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3"))){
					    System.out.println("mensaje de error no se ingreso una  opcion valida, intentar de nuevo");
					}
				}while(!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3")|| opcion.equals("4")));
				
				if(opcion.equals("1")) {//AGREGAR
					
					while(!opcion.equals("3")){
						System.out.println("");
						System.out.println("Tipo de registro:");
						System.out.println("  [1] Choripan");
						System.out.println("  [2] Terremoto");
						System.out.println("  [3] Camcelar");
						System.out.print("Seleccione una opcion: ");
						opcion = key.nextLine();
						
						//AÑADIR CHORIPAN O TERREMOTO
						
						if(opcion.equals("1") ||opcion.equals("2")) {
							String eltipo;
							String ch_te = opcion;
							boolean comprobador = false;
							int i = 0;
							do {
								System.out.println("");
								System.out.println("Consumidores disponibles:");
								for( i = 0; i<aux1;i++) {
									System.out.println("["+(i+1)+"] "+amigos[i].getNombre());
								}
								System.out.print("seleccione el consumidor");
								
								
								
								opcion = key.nextLine();
								for( i = 0; i<aux1;i++) {
									if(opcion.equals(String.valueOf(i))){
										comprobador = true;
										break;
									}
								}
								if(comprobador == false) {
									System.out.println("opcion invalida, intente de nuevo");
								}
							}while(comprobador == false);
							if(ch_te.equals("1")) {
								 eltipo= "Choripan";
								System.out.print("Largo del choripan (cm): ");
								largo = key.nextInt();
								System.out.print("Ancho del choripan (cm): ");
								ancho = key.nextInt();
							}else {
								eltipo = "Terremoto";
								System.out.print("litros del terremoto: ");
								largo = key.nextFloat();
								ancho = 0;
							}
							do {
								System.out.println("Fecha (YYYY-MM-DD): ");
								opcion = key.nextLine();
								if(opcion.split("-").length !=3) {
									System.out.println("fecha invalida, intende de nuevo");
								}
							}while(opcion.split("-").length !=3);
							
							if(valorRegistros >= 200) {
								System.out.println("ERROR NO HAY MAS ESPACIO PARA REGISTROS, INTENTE ELIMINAR");
							} else{
								
								listaConsumo[aux] = new Consumidos(amigos[i], eltipo,largo , ancho, opcion);
								try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta2, true))){
									escribir.newLine();
									escribir.write(listaConsumo[aux].escribirRegistro(ch_te));
									System.out.println("registro añadido con exito");
									
								}catch(IOException e) {
									e.printStackTrace();
								}
								
							}
							
						//AÑADIR TERREMOTO
							

						}else if(opcion.equals("3")) {
							
						}else {
							System.out.println("opcion no valida, intente de nuevo");
						}
						
					}
					
				}else if(opcion.equals("2")) {
					
					System.out.println("no alcance a editar registros DX");
				//ELIMINAR REGISTRO
				}else if(opcion.equals("3")) {
					opcion = "";
					while(!opcion.equals("3")){
						System.out.println("");
						System.out.println("Tipo de registro a eliminar: ");
						System.out.println("  [1] Choripan");
						System.out.println("  [2] Terremoto");
						System.out.println("  [3] Camcelar");
						System.out.print("Seleccione una opcion: ");
						break;
					}
					opcion = key.nextLine();
				System.out.println("sno alcance a borrar registros DX");
			}else if (opcion.equals("3")) {
				
				System.out.println();
				System.out.println("no alcance a hacer las metricas DX");
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
	public static void mostrarOrdenadito(String nombreAnterior, String nombre, int condicion, int numeroEspacios ){ //float dato1, float dato2, String fecha, float kcals 
		int caracteres = nombreAnterior.length();
        for(int a = 0; a<numeroEspacios-caracteres;a++){
            
            System.out.print(" ");
            
        }
if(condicion == 1){
        System.out.print(nombre);
}else{
System.out.println(nombre);
}        


    }
	
}




