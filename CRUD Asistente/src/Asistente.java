import java.io.Serializable;

public class Asistente implements Serializable{
    protected String nombre;
    protected String apellido;
    protected String CI;
    protected int edad;
    
    
    public Asistente(){
        nombre="";
        apellido="";
        CI="";
        edad=0;
    }
    public Asistente(String nombre,String apellido,String CI,int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.CI = CI;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "{" + "nombre: " + nombre+ " }";
    }

    
    
}