package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

public class LeerJson {

	public static void main(String[] args) {
		String json= ""; 
		try {
			BufferedReader bc = new BufferedReader(new FileReader("cliente.json"));
			String linea= ""; 
			while((linea = bc.readLine()) != null)
			{
				json += linea; 
			}
			bc.close();
					
		} catch (FileNotFoundException ex) {
			Logger.getLogger(LeerJson.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(LeerJson.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		System.out.println(json);
		
		Gson gson = new Gson(); 
		Coordenada c = gson.fromJson(json, Coordenada.class); 
		System.out.println(c);
	}

}
