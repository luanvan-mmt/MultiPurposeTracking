package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Properties {
	
	public static InputStream configProperties;
	public static java.util.Properties prop;
	
	static {
		try {
			configProperties = new FileInputStream("../config.properties");
			prop = new java.util.Properties();
			
			prop.load(configProperties);
			
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
