import java.util.*;

/**
 * 
 * 
 * @author Ada
 *
 */

public class SetUserProfile {

	//patient information for tester
	public static PatientInfoName myName = new PatientInfoName("Mikado", "Ryuugamine");
	public static PatientInfoAddress myAddress = new PatientInfoAddress("Ikebukuro", "Toshima-ku", "Tokyo", "Japan");
	public static PatientInfoContactInfo myContact = new PatientInfoContactInfo("123", "123", "123", "izaya", "shizuo");
	public static PatientInfoPostalCode myPostal = new PatientInfoPostalCode("baccano");
	public static PatientInfoHealthNum myHealthNum = new PatientInfoHealthNum("durarara");

	//general history for tester
	public static GeneralHistory_Disease myDisease = new GeneralHistory_Disease("Rheumatism", "Astigmatism", "Isopropyl");
	public static GeneralHistory_EconomicSituation myEconomicSituation = new GeneralHistory_EconomicSituation("good", "banker");
	public static GeneralHistory_PatientHistory myPatientHistory = new GeneralHistory_PatientHistory("not good", "peanuts", "none");
	public static GeneralHistory myGeneralHistory = new GeneralHistory(myDisease.getDisease(), myEconomicSituation.getFullEcoJob(), myPatientHistory.getFullPatientHistory());
	
	//current issues for tester
	public static CurrentIssues_Diagnosis myDisgnosis = new CurrentIssues_Diagnosis("Childe", "says", "hi");
	public static CurrentIssues_DoctorInfo_Contact myDocContact = new CurrentIssues_DoctorInfo_Contact("123", "123", "123");
	
	public static void main(String[] args) {
		String[][] patientInfoArray = new String[5][5];

		setArray(patientInfoArray);
		
		PatientInfo myArray = new PatientInfo(patientInfoArray);

	}

	public static void refreshArray() {

			String[][] patientInfoArrayTemp = new String[5][5];

			setArray(patientInfoArrayTemp);
			
			PatientInfo.changePatientInfo(patientInfoArrayTemp);

	}
	
	public static String[][] setArray(String[][] array){
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				array[i][j] = "";
			}
		}
		
		array[0][0] = myName.getFirstName();
		array[1][0] = myName.getLastName();

		array[0][1] = myContact.getMainPhoneNumber();
		array[1][1] = myContact.getEmergencyPhoneNumber();
		array[2][1] = myContact.getHomePhoneNumber();
		array[3][1] = myContact.getEmail();
		array[4][1] = myContact.getsecondEmail();

		array[0][2] = myAddress.getStreet();
		array[1][2] = myAddress.getCity();
		array[2][2] = myAddress.getProvince();
		array[3][2] = myAddress.getCountry();

		array[0][3] = myPostal.getPostalCode();

		array[0][4] = myHealthNum.getHealthNumber();
		
		return array;
	}

}
