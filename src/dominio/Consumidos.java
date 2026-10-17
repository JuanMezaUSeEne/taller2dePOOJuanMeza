package dominio;

public class Consumidos{
    private persona personaConsumo;
    private String tipo;
    private float dato1;
    private int dato2;
    private float kcals;
    private String fechaConsumo;
    
    public Consumidos(persona personaConsumo, String tipo, float dato1, int dato2, String fechaConsumo){
        
        this.personaConsumo = personaConsumo;
        this.tipo = tipo;
        this.dato1 = dato1;
        this.dato2 = dato2;
        if(this.dato2 == 0){
            this.kcals = (dato1 * 10) /3;
        }else{
            this.kcals = (dato1*dato1)/3;
        }
        this.fechaConsumo = fechaConsumo;
    }
    public persona getPersonaConsumo(){
        return personaConsumo;
    }
    public String getTipo(){
        return tipo;
    }
    public float getDato1(){
        return dato1;
    }
    public int getDato2(){
        return dato2;
    }
    public String getFechaConsumo(){
        return fechaConsumo;
    }
    public float getKcals(){
        return kcals;
    }
    public String escribirRegistro(String choripann) {
    	int eldato1 = (int) dato1;
    	if(choripann.equals("1")) {
    		return tipo+";"+getPersonaConsumo().getNombre()+";"+String.valueOf(eldato1)+";"+String.valueOf(dato2)+";"+fechaConsumo; 
    	}else {
    		return tipo+";"+getPersonaConsumo().getNombre()+";"+String.valueOf(eldato1)+";"+fechaConsumo;
    	}
		
    }
}

