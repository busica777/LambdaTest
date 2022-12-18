package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.function.UnaryOperator;


public class ConfigReader extends BaseClass{
	public static Properties properties;
	
	public static Properties loadProperty(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return properties;
	}
	
	public static UnaryOperator<String> getPropertyValue = (target)
			-> properties.get(target).toString();
}
