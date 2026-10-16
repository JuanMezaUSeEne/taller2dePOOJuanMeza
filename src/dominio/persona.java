package dominio;

public class persona {
    
	private String nombre;
	private choripan[] choripanes = new choripan[200];
	private Terremotos[] listaterremotos = new Terremotos[200];
	private int[] contador_choripan_terremoto = new int[2];
	
	public persona(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public choripan getChoripanes(int aux) {
		return choripanes[aux];
	}
	public void setChoripanes(choripan choripanes, int aux) {
		this.choripanes[aux] = choripanes;
	}
	
	
	public void setTerremotos(Terremotos listaterremotos, int aux) {
		this.listaterremotos[aux] = listaterremotos;
	}
	public Terremotos getTerremotos(int aux){
	    return listaterremotos[aux];
	}
	
	public void sumarChoripanTerremoto(int opcion){
		if(opcion == 0) {
			contador_choripan_terremoto[opcion]++;
		}else {
			contador_choripan_terremoto[1]++;
		}
	}
	
	
	public int getIndexContadorChoripanTerremoto(int opcion){
		if(opcion == 0) {
			return contador_choripan_terremoto[0];
		}else {
			return contador_choripan_terremoto[1];
		}
	}	
}
