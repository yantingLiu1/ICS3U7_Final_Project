import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCodeThatIsSomewhatUselessRightNow {
	ArrayList<String> diseaseArray = new ArrayList<String>();
	ArrayList<String> economicArray = new ArrayList<String>();
	ArrayList<String> historyArray = new ArrayList<String>();
	
	try {
		FileWriter file = new FileWriter(userDisease);
		BufferedWriter writer = new BufferedWriter(file);
		
		writer.write(disease1Ex);
		writer.newLine();
		writer.write(disease2Ex);
		writer.newLine();
		
		writer.close();
		
	}
	catch(IOException ex) {
		System.out.println("The file cannot be made.");
	}
	
	try {
		FileWriter file = new FileWriter(userEconomic);
		BufferedWriter writer = new BufferedWriter(file);
		
		writer.write(economicSituationEx);
		writer.newLine();
		writer.write(jobEx);
		writer.newLine();
				
		writer.close();
		
	}
	catch(IOException ex) {
		System.out.println("The file cannot be made.");
	}
	
	try {
		FileWriter file = new FileWriter(userHistory);
		BufferedWriter writer = new BufferedWriter(file);
		
		writer.write(patientHistoryEx);
		writer.newLine();
		writer.write(allergiesEx);
		writer.newLine();
		writer.write(familyHistoryEx);
		writer.newLine();
		
		writer.close();
		
	}
	catch(IOException ex) {
		System.out.println("The file cannot be made.");
	}
	
	//this is when we want to get the files, the string are in the thing, but they still need to be transported into files. 
	//When we print it'll be in files.
	
	String lineRead;
	
	//disease
	try {
		BufferedReader reader = new BufferedReader(new FileReader(userDisease));
		lineRead = reader.readLine();
		
		while(lineRead != null) {
			diseaseArray.add(lineRead);
			lineRead = reader.readLine();
		}
		
		reader.close();
		
	}
	catch(IOException ex) {
		System.out.println("...");
	}
	
	//economics
	try {
		BufferedReader reader = new BufferedReader(new FileReader(userEconomic));
		lineRead = reader.readLine();
		
		while(lineRead != null) {
			economicArray.add(lineRead);
			lineRead = reader.readLine();
		}
		
		reader.close();
	}
	catch(IOException ex) {
		System.out.println("...");
	}
	
	//history
	try {
		BufferedReader reader = new BufferedReader(new FileReader(userHistory));
		lineRead = reader.readLine();
		
		while(lineRead != null) {
			historyArray.add(lineRead);
			lineRead = reader.readLine();
		}
		
		reader.close();
	}
	catch(IOException ex) {
		System.out.println("...");
	}
	
}
}
