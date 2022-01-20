import java.io.*;
import java.util.*;

public class TesterForDelete {
	public static void main(String[] args) {		
		String str = "";
		String filePath = "storedInformation\\" + str;
		File fileName = new File(filePath);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number from 1-4");
		
		str = input.nextLine();
		
		deleteDirectory(fileName);
		
		fileName.delete();
	}
	
	/**
	 * geekForGeeks deleting file
	 * @param file
	 */
	public static void deleteDirectory(File file) {
		for(File subfile: file.listFiles()) {
			
			if(subfile.isDirectory()) {
				deleteDirectory(subfile);
			}
			
			subfile.delete();
		}
	}
}
