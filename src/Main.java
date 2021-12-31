import java.io.*;
import java.util.*;

/**
 * This isn't really the main, it's just a template for the main. I'll add to it later where I'll get general History and current histories in it
 * We can just plug stuff in later. It shouldn't be that hard to added things from the button to here.
 * @author Ada
 *
 */

public class Main {
	
	//patient information
	public static PatientInfoName myName = new PatientInfoName("Mikado", "Ryuugamine");
	public static PatientInfoAddress myAddress = new PatientInfoAddress("Ikebukuro", "Toshima-Ku", "Tokyo", "Japan");
	public static PatientInfoContactInfo myContact = new PatientInfoContactInfo("123", "123", "123", "mikadoRyuugamine@gmail.com", "baccano@gmail.com");
	public static PatientInfoPostalCode myPostal = new PatientInfoPostalCode("BIG123");
	public static PatientInfoHealthNum myHealthNum = new PatientInfoHealthNum("0321");
	
	public static void main(String[] args) {
		
		/*
		 * The code below is for Patient Info
		 * It includes the template for setting up an array with the Patient Info and an array declaration and refreshes to match PatientInfo
		 * class with the array within the code.
		 */
	
		String[][] patientInfoArray = new String[5][5];	
		
		//makes sure there are no null
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				patientInfoArray[i][j] = "";
			}
		}
		
		patientInfoArray[0][0] = myName.getFullName();
		patientInfoArray[1][0] = myName.getFirstName();
		patientInfoArray[2][0] = myName.getLastName();
		
		patientInfoArray[0][1] = myContact.getFullContact();
		patientInfoArray[1][1] = myContact.getMainPhoneNumber();
		patientInfoArray[2][1] = myContact.getEmergencyPhoneNumber();
		patientInfoArray[3][1] = myContact.getEmail();
		patientInfoArray[4][1] = myContact.getsecondEmail();
		
		patientInfoArray[0][2] = myAddress.getFullAddress();
		patientInfoArray[1][2] = myAddress.getStreet();
		patientInfoArray[2][2] = myAddress.getCity();
		patientInfoArray[3][2] = myAddress.getProvince();
		patientInfoArray[4][2] = myAddress.getCountry();
		
		patientInfoArray[0][3] = myPostal.getPostalCode();
		
		patientInfoArray[0][4] = myHealthNum.getHealthNumber();
		
		PatientInfo myArray = new PatientInfo(patientInfoArray);
		
		PatientInfo.changePatientInfo(patientInfoArray);
		
		System.out.println(myArray.getPatientInfo()[0][0]);

		myName.changeFirstName("Mika");

		refreshArray();
		
		System.out.println(myArray.getPatientInfo()[0][0]);
		System.out.println(myArray.getPatientInfo()[2][2]);		
		
		/*
		 * For General History
		 * 
		 * When making the string names for the files, we'll manipulate the string so that it starts with file number whatever, then it'll add a 
		 * value to it. Then we'll get different txt files for every patient. I just made them directly but it'll be in a while loop
		 */
		
		String disease1Ex = "Rheumatism";
		String disease2Ex = "Astigmatism";
		
		String economicSituationEx = "good";
		String jobEx = "mangaka";
		
		String patientHistoryEx = "No.";
		String allergiesEx = "peanuts";
		String familyHistoryEx = "No.";
		
		ArrayList<String> diseaseArray = new ArrayList<String>();
		ArrayList<String> economicArray = new ArrayList<String>();
		ArrayList<String> historyArray = new ArrayList<String>();
		
		
		
	}
		
	
	/**
	 * It refreshes the array for Patient info to match the class.
	 * Ada
	 */
	
	public static void refreshArray(){
		
		String[][] patientInfoArrayTemp = new String[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				patientInfoArrayTemp[i][j] = "";
			}
		}
		
		patientInfoArrayTemp[0][0] = myName.getFullName();
		patientInfoArrayTemp[1][0] = myName.getFirstName();
		patientInfoArrayTemp[2][0] = myName.getLastName();
		
		patientInfoArrayTemp[0][1] = myContact.getFullContact();
		patientInfoArrayTemp[1][1] = myContact.getMainPhoneNumber();
		patientInfoArrayTemp[2][1] = myContact.getEmergencyPhoneNumber();
		patientInfoArrayTemp[3][1] = myContact.getEmail();
		patientInfoArrayTemp[4][1] = myContact.getsecondEmail();
		
		patientInfoArrayTemp[0][2] = myAddress.getFullAddress();
		patientInfoArrayTemp[1][2] = myAddress.getStreet();
		patientInfoArrayTemp[2][2] = myAddress.getCity();
		patientInfoArrayTemp[3][2] = myAddress.getProvince();
		patientInfoArrayTemp[4][2] = myAddress.getCountry();
		
		patientInfoArrayTemp[0][3] = myPostal.getPostalCode();
		
		patientInfoArrayTemp[0][4] = myHealthNum.getHealthNumber();

		PatientInfo.changePatientInfo(patientInfoArrayTemp);
		
	}

}
