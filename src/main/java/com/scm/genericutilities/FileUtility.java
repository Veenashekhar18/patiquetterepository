package com.scm.genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * used to read data from external files like text,properties
 * @author veena
 *
 */
public class FileUtility {
	/**
	 * used to get the filepaths from the externalfiles
	 * @param key
	 * @return
	 * @throws IOException
	 */

		public String getfilepathfromproeritiesfile(String key) throws IOException
		{
			FileInputStream fis=new FileInputStream("./configuration/filepath1.properties");
			Properties p=new Properties();
			p.load(fis);
			String value=p.getProperty(key);
			return value;
		}
		/**
		 * used to get the key:value from the any properties based on file path parameter
		 * @param filepath
		 * @param key
		 * @return
		 * @throws IOException
		 */
		
		public String getdatafromproperties(String filepath,String key) throws IOException
		{
			FileInputStream fis=new FileInputStream(filepath);
			Properties p=new Properties();
			p.load(fis);
			String value=p.getProperty(key);
			return value;
			
			
	}
}
