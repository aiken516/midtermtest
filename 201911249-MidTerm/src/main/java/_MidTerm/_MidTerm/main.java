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

import midterm.problem2.RegularExpression;

public class main {
	public static void main(String args[]) throws ParseException {
		Scanner console = new Scanner(System.in);
		JSONParser parser = new JSONParser();
		RegularExpression re = new RegularExpression();
		
		try {
			
			Object obj=parser.parse(new FileReader("midterm.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray infoArray = (JSONArray) jsonObject.get("poem");
			
			System.out.println("Enter the keyword you are looking for: ");
			String str = console.next();

			String[] sentence = str.split("|");
			String s1 = sentence[0];
			String s2 = sentence[1];
			
		     for(int i = 0; i<infoArray.size(); i++) {
		      	JSONObject itemObject = (JSONObject) infoArray.get(i);
		      	
		      String item = (String) itemObject.get("item");
		         
		      if (re.check(s1, s2))
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
