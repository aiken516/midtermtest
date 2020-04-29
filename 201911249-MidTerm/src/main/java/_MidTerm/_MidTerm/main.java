package _MidTerm._MidTerm;


import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class main {
	public static void main(String args[]) throws ParseException {
		Scanner console = new Scanner(System.in);
		JSONParser parser = new JSONParser();

		try {
			
			Object obj=parser.parse(new FileReader("midterm.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray infoArray = (JSONArray) jsonObject.get("poem");
			
			System.out.println("Enter the keyword you are looking for: ");
			String str = console.next();

			
		     for(int i = 0; i<infoArray.size(); i++) {
		      	JSONObject itemObject = (JSONObject) infoArray.get(i);
		      	
		      String item = (String) itemObject.get("item");
		      if (item.contains(str))
		      	System.out.println("item"+ i + ": " + item);
		      }
		  }
			
		//	if(item.contains(str)) {
//				System.out.println(item);
		//	}
		catch (IOException exception) {
			System.out.println("Error processing file:" + exception);

		}
	}
}
