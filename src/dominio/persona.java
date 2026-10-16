package dominio;

public class persona {
	private String nombre;
	private choripan choripanes;
	public persona(String nombre, choripan choripanes) {
		this.nombre = nombre;
		this.choripanes = choripanes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public choripan getChoripanes() {
		return choripanes;
	}
	public void setChoripanes(choripan choripanes) {
		this.choripanes = choripanes;
	}
	
	
}
