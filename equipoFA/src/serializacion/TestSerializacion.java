package serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TestSerializacion {
	
	public static void main(String[] args){
		
		Persona juan = new Persona("Juan",20,Genero.HOMBRE);
		Persona maria = new Persona("Maria",20,Genero.MUJER);
		Persona pedro = new Persona("Pedro",20,Genero.HOMBRE);
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(juan);
		lista.add(maria);
		lista.add(pedro);

		try{
			FileOutputStream file = new FileOutputStream("test.txt");
			ObjectOutputStream os = new ObjectOutputStream(file);
			os.writeObject(lista);
			file.close();
			os.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		try {
			FileInputStream doc = new FileInputStream("test.txt");
			ObjectInputStream is = new ObjectInputStream(doc);
			@SuppressWarnings("unchecked")
			ArrayList<Persona> leida = (ArrayList<Persona>)is.readObject();
			for(Persona p:leida){
				System.out.println(p.toString());
			}
			doc.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
