package dominio;

public class persona {
	private String nombre;
	private choripan[] choripanes = new choripan[200];
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
	
	
}
