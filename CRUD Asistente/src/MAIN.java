import java.io.IOException;
import java.util.*;
public class MAIN {
   
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Vector <Asistente> asistentes= new Vector();
        //Cargando Datos
        try {
        	asistentes = GestionDeCuentas.CargarDatos();
        }
        catch(Exception ex) {
        	System.out.println("No se encuentran datos");
        }
        //Seccion de opciones para el usuario
    	String opcion = "";
        while(true) {
        	try {
            	Opciones();
        		opcion = scan.next();
        		if(RevisarOpcion(opcion)==true) {
        		switch(opcion) {
        			//Mostrar listado
        			case "1":
        				Listado(asistentes);
        			break;
        			//Añadir nuevo asistente
        			case "2":
        				System.out.println("--------------");
        				System.out.println("Por favor introduzca los datos del asistente como se indica a continuacion");
        				System.out.println("Nombre -> Apellidos -> CI ->Edad");
        		        String nombre = scan.next();
        		        String apellido = scan.next();
        		        String CI = scan.next();
        		        String edadtemp = scan.next();
        		        int edad = Integer.valueOf(edadtemp);
        		        
        		        Asistente k = new Asistente(nombre,apellido,CI,edad);
        		        asistentes.add(k);
        			break;
        			//Eliminar un asistente
        			case "3":
        				System.out.println("-----------");
        				System.out.println("Introduzca el numero del asistente que quiere eliminar");
        				Listado(asistentes);
        				String eliminartemp = scan.next();
        				int eleminar = Integer.valueOf(eliminartemp);
        				asistentes.remove(eleminar-1);
        			break;
        			//Guardar Datos
        			case "4":
        		    	GestionDeCuentas.GuardarDatos(asistentes);
        				System.out.println("-------");
        				System.out.println("Guardado con exito!");
        			break;
        			//Finalizar aplicacion
        			case "5":
        				return;
        		}
        		}
        	}
        	catch(NumberFormatException ex1){
        		System.out.println("Error!! Tiene que escribir un numero");
        	}
        	catch(Exception ex) {
        		System.out.println(ex.getMessage());
        	}

        }
	}
	//Opciones a mostrar
	public static void Opciones() {
		System.out.println("-------------------------------------------------");
		System.out.println("Escriba el numero de la opcion que desea:");
		System.out.println("1-Mostrar listado.");
		System.out.println("2-Añadir nuevo asistente.");
		System.out.println("3-Eliminar un asistente.");
		System.out.println("4-Guardar datos.");
		System.out.println("5-Cerrar aplicacion.");
	}
	
	//Mostrar listado
	public static void Listado(Vector<Asistente> asistentes) {
		System.out.println("-------------------------------------------------");
		System.out.println("Listado de asistentes al evento");
		System.out.println("#-Nombre_Apellidos_CI_Edad");
        for(int i =0;i<asistentes.size();i++) {
        	System.out.println((i+1)+"-"+asistentes.get(i).nombre+" "+asistentes.get(i).apellido+
        			" "+asistentes.get(i).CI+" "+asistentes.get(i).edad);
        }
	}
	//Revisar q la opcion sea valida en el rango de opciones
	public static boolean RevisarOpcion(String k) {
		if(Integer.valueOf(k)>=1&&Integer.valueOf(k)<=5) {
			return true;
		}
		else {
			throw new InputMismatchException("La opcion es incorrecta");
		}
	}
}

