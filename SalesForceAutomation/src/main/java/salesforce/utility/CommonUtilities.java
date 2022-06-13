package salesforce.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static salesforce.utility.Constants.APPLICATION_PROPERTIES_PATH;

public class CommonUtilities 
{
	public String getApplicationProperty(String key) throws IOException
	{
		File file = new File("Data.property");
		System.out.println(file.getAbsolutePath());
		String sPath = file.getAbsolutePath();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(sPath);
		prop.load(fis);
		String value = prop.getProperty(key);
		System.out.println(value);
		return value;
	}
//	public static void main(String args[]) throws IOException
//	{
//		File file = new File("Data.property");
//		System.out.println(file.getAbsolutePath());
//		//String sPath = file.getAbsolutePath();
//		CommonUtilities common = new CommonUtilities();
//		common.getApplicationProperty("url");
//	}

}
