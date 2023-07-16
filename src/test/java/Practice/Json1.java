package Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// read the data from json file
JSONParser p=new JSONParser();
Object obj = p.parse(new FileReader("C:\\Users\\veena\\OneDrive\\Desktop\\Jsonbody.json"));
//downcast the obj in to jsonobject automatically all text stored in the form of key and values
JSONObject map=(JSONObject) obj;
System.out.println(map.get("url"));
System.out.println(map.get("username"));

	}

}
