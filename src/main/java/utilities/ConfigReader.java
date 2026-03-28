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
			
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties",e);
		}
	}
	
	public static String getProperty(String key)
	{
		String value=properties.getProperty(key);
		if(value==null)
		{
			throw new RuntimeException("Property not found: "+key);
		}
		return value;
	}

}
