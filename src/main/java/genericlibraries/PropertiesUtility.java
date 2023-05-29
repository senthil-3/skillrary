package genericlibraries;

import java.io.FileInputStream;
	
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * this class contains all reuseable methods to perform operations on properties file
 * 
 */
public class PropertiesUtility {

	private Properties property;
	/*
	 * this method used to initialize properties file
	 * @param filepath
	 */
	public void propertiesUnit(String filepath) {
		FileInputStream fis = null;
		try {
			fis = new  FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		property = new Properties();
		try {
			property.load(fis);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/*
	 * this method is used to fetch data from properties file using key 
	 * @param key
	 * return
	 */
	public String readdatafrompropertiesfile(String key) {
		return property.getProperty(key);
		
	}
	public void writetopriperties(String key, String value,String filepath, String comments) {
		property.put(key, value);
		
		FileOutputStream fos = null; 
		try {
			fos = new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			property.store(fos, comments);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}


