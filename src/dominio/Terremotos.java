package dominio;

public class Terremotos{
    private float litros;
    private String fecha;
    private float kcal;
    
    public Terremotos(float litros, String fecha){
        this.litros = litros;
        this.fecha = fecha;
        this.kcal = (litros * 10)/3;
        
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