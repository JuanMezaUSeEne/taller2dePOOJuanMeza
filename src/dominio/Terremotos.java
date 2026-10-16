package dominio;

public class Terremotos{
    private float litros;
    private String fecha;
    private float kcal;
    private int contadorT;
    
    public Terremotos(float litros, String fecha, int contadorT){
        this.litros = litros;
        this.fecha = fecha;
        this.kcal = (litros * 10)/3;
        this.contadorT = contadorT;
        
    }
    public float getLitros(){
        return litros;
    }
    public String getFecha(){
        return fecha;
    }
    public float getKcal(){
        return kcal;
    }
}