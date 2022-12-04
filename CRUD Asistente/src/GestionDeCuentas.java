import java.io.*;
import java.util.*;
public class GestionDeCuentas {
	static String direc ="C:\\data.bin";
    //GuardarDatos de CLIENTES
    public static void GuardarDatos(Vector<Asistente> datos) throws FileNotFoundException,IOException{

        File archivo= new File(direc);
        FileOutputStream fileOutputStream = new FileOutputStream(archivo);
        DataOutputStream outStream = new DataOutputStream(fileOutputStream);
        
        outStream.writeInt(datos.size());
        
        for(int i =0;i<datos.size();i++){
            outStream.writeUTF(datos.get(i).nombre);
            outStream.writeUTF(datos.get(i).apellido);
            outStream.writeUTF(datos.get(i).CI);
            outStream.writeInt(datos.get(i).edad);
        }

        outStream.flush();
        outStream.close();
    }
    //CargarDatos de CLIENTES
    public static Vector<Asistente> CargarDatos() throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream InStream = new DataInputStream(fileInputStream);
        
        int capacidad = InStream.readInt();
        
        Vector<Asistente> usuario = new Vector();
        
        for(int i =0;i<capacidad;i++){
            String nombre =InStream.readUTF();
            String apellido =InStream.readUTF();
            String CI =InStream.readUTF();
            int edad =InStream.readInt();

            Asistente nuevoUser = new Asistente(nombre,apellido,CI,edad);
        	usuario.add(nuevoUser);
        }
        
        InStream.close();
        return usuario;
    }
}