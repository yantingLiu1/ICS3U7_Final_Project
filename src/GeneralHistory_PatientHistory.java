
public class GeneralHistory_PatientHistory {
	
	public static String patientHistory;
	public static String allergies;
	public static String familyHistory;
	
	
	public GeneralHistory_PatientHistory(String fPatientHistory, String fAllergies, String fFamilyHistory) {
		patientHistory = fPatientHistory;
		allergies = fAllergies;
		familyHistory = fFamilyHistory;
	}		
	
	public static String changePatientHistory(String cPatientHistory) {
		patientHistory = cPatientHistory;
		return patientHistory;
	}
	
	public static String changeAllergies(String cAllergies) {
		allergies = cAllergies;
		return allergies;
	}
	
	public static String changeFamilyHistory(String cFamilyHistory) {
		familyHistory = cFamilyHistory;
		return familyHistory;
	}
	
	public static String getPatientHistory() {
		return patientHistory;
	}
	
	public static String getAllergies() {
		return allergies;
	}
	
	public static String getFamilyHistory() {
		return familyHistory;
	}
}
