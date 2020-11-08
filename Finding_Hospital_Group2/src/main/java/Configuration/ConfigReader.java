/**
 * 
 */
package Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import org.testng.annotations.BeforeMethod;

/**
 * @author HP
 *
 */
public class ConfigReader {

	public static Properties prop;
	FileInputStream finput;
	public ConfigReader()
	{
		
	try {
		//File src=new File("config.property");
		finput=new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(finput);
	}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
}
