import java.io.*;
import java.util.*;

public class CreateUserFiles {
	public static void main(String[] args) {
		String path = "C:\\Users\\xinyu\\Desktop\\ICS3U7 Final Project Ver 2\\CreateUserFile\\src";
		String folderName = "";
		String src = "src";
		String emptyString = "";
		File fileName = new File("Data.txt");
		
		boolean fileMade;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter file name: ");
		folderName = input.nextLine();
		
		path = path + fileName;
		
		File f1 = new File(path);
		
		fileMade = f1.mkdir();
		
		if(fileMade) {
			System.out.println("File " + fileName + " made");
		}
		else {
			System.out.println("File " + fileName + " not made");
		}
		
		try {
			Writer fileWriter = new FileWriter("srcGacha give me Xiao please\\filewriter.txt");
			fileWriter.write("XIAOOOOO");
			fileWriter.close();
		}
		catch(IOException ex) {
			System.out.println("error");
		}
		
		input.close();
		
	}
}
