import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewFrame {
    public static void main(String[] args){
        viewf frame = new viewf();
        frame.setSize(900,650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("View");
        frame.setVisible(true);
        
      
    }
}
class viewf extends JFrame implements ActionListener{
    viewf(){    	
        setLayout(null);
        
        String[] patientInfoArray = new String[9];
        
        patientInfoArray[0] = readFiles()[0];
        patientInfoArray[1] = readFiles()[1];
        patientInfoArray[2] = readFiles()[2];
        patientInfoArray[3] = readFiles()[3];
        patientInfoArray[4] = readFiles()[4];
        patientInfoArray[5] = readFiles()[5];
        patientInfoArray[6] = readFiles()[6];
        patientInfoArray[7] = readFiles()[7];
        patientInfoArray[8] = readFiles()[8];
        
        String firstname = "First Name: " + patientInfoArray[0];
        String lastname = "Last Name: " + patientInfoArray[1];
        String phone = "Phone Number: " + patientInfoArray[2];
        String address = "Address: " + patientInfoArray[3] + ", " + patientInfoArray[5] + ", " + patientInfoArray[6];
        String postalCode = "Postal Code: " + patientInfoArray[6];
        String healthNumber = "Health Number: " + patientInfoArray[7];
        String notes = "Notes: " + patientInfoArray[8];
        

        add(new CustomLabel(firstname, 30, 40, 300, 30));
        add(new CustomLabel(lastname, 30, 40, 300, 100));
        add(new CustomLabel(phone, 30, 40, 300, 170));
        add(new CustomLabel(address, 30, 40, 300, 240));
        add(new CustomLabel(postalCode, 30, 40, 300, 310));
        add(new CustomLabel(healthNumber, 30, 40, 300, 380));
        add(new CustomLabel(notes, 30, 40, 300, 450));
        
        
    }
    
    public String[] readFiles() {

    	String[] patientInfoArrayTemp = new String[9];
		
		//To delete the nulls
		for(int i = 0; i < 9; i++) {
			patientInfoArrayTemp[i] = "";
		}	
		
		try {		
			String pathWOtxt = "storedInformation\\1";

			BufferedReader nameReader = new BufferedReader(new FileReader(pathWOtxt + "\\name.txt")); //there are two values in name
			BufferedReader contactReader = new BufferedReader(new FileReader(pathWOtxt + "\\contact.txt"));
			BufferedReader addressReader = new BufferedReader(new FileReader(pathWOtxt + "\\address.txt"));
			BufferedReader cityReader = new BufferedReader(new FileReader(pathWOtxt + "\\city.txt"));
			BufferedReader provinceReader = new BufferedReader(new FileReader(pathWOtxt + "\\province.txt"));
			BufferedReader postalCodeReader = new BufferedReader(new FileReader(pathWOtxt + "\\postalCode.txt"));
			BufferedReader healthNumReader = new BufferedReader(new FileReader(pathWOtxt + "\\healthNumber.txt"));
			BufferedReader noteReader = new BufferedReader(new FileReader(pathWOtxt + "\\note.txt"));

			//Reader for name 
			patientInfoArrayTemp[0] = nameReader.readLine();
			patientInfoArrayTemp[1] = nameReader.readLine();

			//Reader for contact
			patientInfoArrayTemp[2] = contactReader.readLine();

			//Reader for address
			patientInfoArrayTemp[3] = addressReader.readLine();

			//Reader for city
			patientInfoArrayTemp[4] = cityReader.readLine();

			//Reader for province
			patientInfoArrayTemp[5] = provinceReader.readLine();

			//Reader for postal code
			patientInfoArrayTemp[6] = postalCodeReader.readLine();

			//Reader for health number
			patientInfoArrayTemp[7] = healthNumReader.readLine();

			//Reader for note 
			String noteLine = noteReader.readLine();
			
			while(noteLine != null) {
				patientInfoArrayTemp[8] += noteLine + "\n";
				
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
		
		return patientInfoArrayTemp;
		
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    }
}