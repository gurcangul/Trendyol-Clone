package FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	
	public static ArrayList<String> readFile(String fileName){
			
	  ArrayList<String> allValues = new ArrayList<String>();

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
             while (scanner.hasNextLine()) {

                 String data = scanner.nextLine();
                 allValues.add(data);
             }

         } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        return allValues;
   }
}
		
