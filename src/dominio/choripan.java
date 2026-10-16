package dominio;

public class choripan {
	private String fecha;
	private int largo;
	private int ancho;
	private float kcal;
	private int contador;
	public choripan(String fecha, int largo, int ancho, int contador ) {
		this.fecha = fecha;
		this.largo = largo;
		this.ancho = ancho;
		this.kcal = (largo* ancho) / 3;
		this.contador = contador;
	}
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public float getKcal() {
		return kcal;
	}
	public void setKcal(float kcal) {
		this.kcal = kcal;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}