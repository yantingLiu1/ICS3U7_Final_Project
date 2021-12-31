/**
 * I need the GUI to finish this.
 * @author Ada
 *
 */

public class PatientInfo {

	public static String[][] patientInfoArray = new String[6][5];
	public static String[][] fPatientInfoArray = new String[6][5];
	public static String[][] cPatientInfoArray = new String[6][5];

	public PatientInfo(String[][] fPatientInfoArray) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				patientInfoArray[i][j] = fPatientInfoArray[i][j];
			}
		}
	}
	
	public static String[][] changePatientInfo(String[][] cPatientInfoArray){
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(patientInfoArray[i][j].equals(cPatientInfoArray[i][j]) == false) {
					patientInfoArray[i][j] = cPatientInfoArray[i][j];
				}
			}
		}
		
		return patientInfoArray;
	}
	
	public String[][] getPatientInfo(){
		return patientInfoArray;
	}
		
}
