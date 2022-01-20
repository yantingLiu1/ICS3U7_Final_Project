import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Ignore this for now, it's just for when we upload informaiton and read off stuff
 * @author Ada
 *
 */
     
public class TesterForFileIO {
	
	public static void main(String[] args) {

		String str;
		String[] patientInfoArray = new String[9];
		
		//To delete the nulls
		for(int i = 0; i < 9; i++) {
			patientInfoArray[i] = "";
		}

		Scanner input = new Scanner(System.in); 


		System.out.println("Enter a number 1-4: ");
		str = input.nextLine();

		try {				


			String pathWOtxt = "storedInformation\\" + str + "\\";

			BufferedReader nameReader = new BufferedReader(new FileReader(pathWOtxt + "name.txt")); //there are two values in name
			BufferedReader contactReader = new BufferedReader(new FileReader(pathWOtxt + "contact.txt"));
			BufferedReader addressReader = new BufferedReader(new FileReader(pathWOtxt + "address.txt"));
			BufferedReader cityReader = new BufferedReader(new FileReader(pathWOtxt + "city.txt"));
			BufferedReader provinceReader = new BufferedReader(new FileReader(pathWOtxt + "province.txt"));
			BufferedReader postalCodeReader = new BufferedReader(new FileReader(pathWOtxt + "postalCode.txt"));
			BufferedReader healthNumReader = new BufferedReader(new FileReader(pathWOtxt + "healthNumber.txt"));
			BufferedReader noteReader = new BufferedReader(new FileReader(pathWOtxt + "note.txt"));

			//Reader for name 
			patientInfoArray[0] = nameReader.readLine();
			patientInfoArray[1] = nameReader.readLine();

			//Reader for contact
			patientInfoArray[2] = contactReader.readLine();

			//Reader for address
			patientInfoArray[3] = addressReader.readLine();

			//Reader for city
			patientInfoArray[4] = cityReader.readLine();

			//Reader for province
			patientInfoArray[5] = provinceReader.readLine();

			//Reader for postal code
			patientInfoArray[6] = postalCodeReader.readLine();

			//Reader for health number
			patientInfoArray[7] = healthNumReader.readLine();

			//Reader for note 
			String noteLine = noteReader.readLine();
			
			while(noteLine != null) {
				patientInfoArray[8] += noteLine + "\n";
				
				noteLine = noteReader.readLine();
			}

			nameReader.close();
			contactReader.close();
			addressReader.close();
			cityReader.close();
			provinceReader.close();
			postalCodeReader.close();
			healthNumReader.close();
			noteReader.close();		

		}
		catch(IOException ex) {
			System.out.println("File cannot be read");
		}

		for(int i = 0; i < 9; i++) {
			System.out.println(patientInfoArray[i]);
		}
	}
}
