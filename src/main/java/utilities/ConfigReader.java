package utilities;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class ConfigReader {
	
	private static final Properties properties=new Properties();
	
	static 
	{
		try(InputStream input=ConfigReader.class
				.getClassLoader()
				.getResourceAsStream("config.properties"))
		{
			if(input==null)
			{
				throw new RuntimeException("config.properties not found in resources folder");
			}
			
			properties.load(input);
			
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties",e);
		}
	}
	
	public static String getProperty(String key)
	{
	        String envValue = System.getenv(key.toUpperCase());
	        if (envValue != null && !envValue.trim().isEmpty()) 
	        {
	            return envValue;
	        }
		   String value=properties.getProperty(key);
		   if(value==null)
		   {
			  throw new RuntimeException("Property not found: "+key);
		   }
		  return value;
	}

}
