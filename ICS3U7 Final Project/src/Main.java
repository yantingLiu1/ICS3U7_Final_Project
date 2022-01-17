import java.io.*;
import java.util.*;

import javax.swing.WindowConstants;

public class Main {

	public static String path = "C:\\temp\\ics3u7";
	public static String[] patientInfoArray = new String[9];
	public static String firstName;
	public static String lastName;
	public static String address;
	public static String city;
	public static String province;
	public static String contactInfo;
	public static String postalCode;
	public static String healthNumber;
	public static String notes;

	public static void main(String[] args)
	{		 
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setSize(800, 600);
		loginFrame.setTitle("Login");
		loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);
		//		
		//		if(loginFrame.LoginSuccessful() == true) {
		//			
		//			loginFrame.setVisible(false);
		//
		//			RegFrame rFrame = new RegFrame();
		//		    rFrame.setSize(900, 650);
		//		    rFrame.setTitle("Registration");
		//		    rFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//		    rFrame.setVisible(true);
		//		    
		//		}	

		for(int i = 0; i < 9; i++) {
			patientInfoArray[i] = loginFrame.getValues()[i];
		}
		
		setIntoFile(patientInfoArray);

	}	

	public static PatientInfoName nameTemp = new PatientInfoName(patientInfoArray[0], patientInfoArray[1]);
	public static PatientInfoContactInfo contactTemp = new PatientInfoContactInfo(patientInfoArray[2]);
	public static PatientInfoAddress addressTemp = new PatientInfoAddress(patientInfoArray[3], patientInfoArray[4], patientInfoArray[5]);
	public static PatientInfoPostalCode postalCodeTemp = new PatientInfoPostalCode(patientInfoArray[6]);
	public static PatientInfoHealthNum healthNumTemp = new PatientInfoHealthNum(patientInfoArray[7]);
	public static PatientInfoNotes noteTemp = new PatientInfoNotes(patientInfoArray[8]);		

	public static void setIntoFile(String[] array) {
		
		String pathForFile = "C:\\temp\\ics3u7";
		String folderName = healthNumTemp.getHealthNumber();
		boolean fileMade;
        if(folderName != null ) {
		for(int i = 0; i < 1; i++) {
			
			String path_revised = path + folderName;
			File f1 = new File(pathForFile);
			f1 = new File(path_revised);
			fileMade = f1.mkdirs();

			if(fileMade) {
				System.out.println("Folder made");
			}
			else {
				System.out.println("Folder not made");
			}

		}
        }

		try{

			String space = " ";
			String fileNameName = pathForFile + folderName + "\\" + nameTemp.getFirstName() + nameTemp.getLastName() + ".txt";
			String fileNameContact = pathForFile + folderName + "\\" + contactTemp.getMainPhoneNumber() + ".txt";
			String fileNameAddress = pathForFile + folderName + "\\" + addressTemp.getAddress() + ".txt";
			String fileNameCity = pathForFile + folderName + "\\" + addressTemp.getCity() + ".txt";
			String fileNameProvince = pathForFile + folderName + "\\" + addressTemp.getProvince() + ".txt";
			String fileNamePostalCode = pathForFile + folderName + "\\" + postalCodeTemp.getPostalCode() + ".txt";
			String fileNameHealthNum = pathForFile + folderName + "\\" + healthNumTemp.getHealthNumber() + ".txt";
			String fileNameNotes = pathForFile + folderName + "\\" + noteTemp.getNotes() + ".txt";

			Writer patientInfoWriterName = new FileWriter(fileNameName);
			Writer patientInfoWriterContact = new FileWriter(fileNameContact);
			Writer patientInfoWriterAddress = new FileWriter(fileNameAddress);
			Writer patientInfoWriterCity = new FileWriter(fileNameCity);
			Writer patientInfoWriterProvince = new FileWriter(fileNameProvince);
			Writer patientInfoWriterPostalCode = new FileWriter(fileNamePostalCode);
			Writer patientInfoWriterHealthNum = new FileWriter(fileNameHealthNum);
			Writer patientInfoWriterNotes = new FileWriter(fileNameNotes);

			patientInfoWriterName.write(nameTemp.getFirstName());
			patientInfoWriterName.write(space);
			patientInfoWriterName.write(nameTemp.getLastName());
			
			patientInfoWriterContact.write(contactTemp.getMainPhoneNumber());
			
			patientInfoWriterAddress.write(addressTemp.getAddress());
			
			patientInfoWriterCity.write(addressTemp.getCity());
			
			patientInfoWriterProvince.write(addressTemp.getProvince());
			
			patientInfoWriterPostalCode.write(postalCodeTemp.getPostalCode());
			
			patientInfoWriterHealthNum.write(healthNumTemp.getHealthNumber());
			
			patientInfoWriterNotes.write(noteTemp.getNotes());
			
			patientInfoWriterName.close();
			patientInfoWriterContact.close();
			patientInfoWriterAddress.close();
			patientInfoWriterCity.close();
			patientInfoWriterProvince.close();
			patientInfoWriterPostalCode.close();
			patientInfoWriterHealthNum.close();
			patientInfoWriterNotes.close();

		}
		catch(IOException ex) {
			System.out.println("The file was not written");
		}

	}

}
