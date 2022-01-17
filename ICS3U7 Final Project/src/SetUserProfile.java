                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  import java.util.*;
import java.io.*;

/**
 * 
 * This has the classes need to make a file 
 * They go directly into the main file
 * @author Ada
 *
 */

public class SetUserProfile {
	
	public static 
	
	//name for where files go
	public static String path = "C:\\Users\\xinyu\\Desktop\\ICS3U7 Final Project Ver 2\\ICS3U7_Final_Project\\src";

	public static void main(String[] args) {
		ArrayList<String> patientInfoArray = new ArrayList<String>();
	
		setPatientInfo(patientInfoArray);
		
		//This is to refresh the patient info array
		
		myName.changeFirstName("Ada");
		
		refreshPatientInfoArray(patientInfoArray);
		
		System.out.println(patientInfoArray.get(0));
		
		
			
	}
	
	/**
	 * Refreshes the array
	 * @param array
	 */
	public static void refreshPatientInfoArray(ArrayList<String> array) {
		
		PatientInfo.changePatientInfo(array);
	}
	
	/**
	 * Refreshes the array
	 */

	public static ArrayList<String> setPatientInfo(ArrayList<String> array){

		array.add(myName.getFirstName());
		array.add(myName.getLastName());

		array.add(myContact.getMainPhoneNumber());

		array.add(myAddress.getAddress());
		array.add(myAddress.getCity());
		array.add(myAddress.getProvince());

		array.add(myPostal.getPostalCode());

		array.add(myHealthNum.getHealthNumber());

		return array;
		
	}
	
	public static void setIntoFile(ArrayList<String> array1, ArrayList<String> array2, ArrayList<String> array3) {
		String pathForFile = "C:\\Users\\xinyu\\Desktop\\ICS3U7 Final Project Ver 2\\ICS3U7_Final_Project\\src";
		String folderName = "Patient 001";
		boolean fileMade;
		
		for(int i = 0; i < 1; i++) {
			String path_revised = path + folderName;
			File f1 = new File(path);
			f1 = new File(path_revised);
			fileMade = f1.mkdir();

			if(fileMade) {
				System.out.println("File made");
			}
			else {
				System.out.println("File not made");
			}
			
		}
		
		try{
			Writer patientInfoWriter = new FileWriter(pathForFile + folderName + "\\Patient001Info.txt");
			for(int i = 0; i < 13; i++) {
					patientInfoWriter.write(array1.get(i));
					patientInfoWriter.write("\n");
				}

				patientInfoWriter.close();
			
			System.out.println("The file was written");

		}
		catch(IOException ex) {
			System.out.println("The file was not written");
		}
		
	}

}
