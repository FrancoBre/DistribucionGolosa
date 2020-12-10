package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LeerJson {

	public static void main(String[] args) {
		String json= "";
		Gson gson = new Gson(); 
		try {
			BufferedReader bc = new BufferedReader(new FileReader("../DistribucionGolosa/distribucionGolosa/src/logica/cliente.json"));
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
		
		//System.out.println(json);
		
//		Gson gson = new Gson(); 
//		Coordenada c = gson.fromJson(json, Coordenada.class); 
		
		Type collectionType = new TypeToken<Collection<Coordenada>>(){}.getType();
		Collection<Coordenada> c = gson.fromJson(json, collectionType);
		ArrayList<Coordenada> newList = new ArrayList<>(c);
		
		for(Coordenada coordenada : newList) {
			System.out.println("****"+coordenada+"*****");
		}
		
		
		//System.out.println(newList);
	}

}
