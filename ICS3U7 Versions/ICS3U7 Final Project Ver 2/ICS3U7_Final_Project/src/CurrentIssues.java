import java.util.*;

public class CurrentIssues {
	
	public static String doctorDiagnosis, doctorContact, headNurse, doctorName, hospitalTime;
	public static ArrayList<String> currentIssuesArray = new ArrayList<String>();
	
	public CurrentIssues(String fDoctorDiagnosis, String fDoctorContact, String fHeadNurse, String fDoctorHospital, String fDoctorName, String fHospitalTime) {
		doctorDiagnosis = fDoctorDiagnosis;
		doctorContact = fDoctorContact;
		headNurse = fHeadNurse;
		doctorName = fDoctorName;
		hospitalTime = fHospitalTime;
		
		currentIssuesArray.add(fHospitalTime);
		currentIssuesArray.add(fDoctorName);
		currentIssuesArray.add(fDoctorHospital);
		currentIssuesArray.add(fDoctorContact);
		currentIssuesArray.add(fDoctorDiagnosis);
		currentIssuesArray.add(fHeadNurse);
	}
	
	public static ArrayList<String> changeCurrentIssues(ArrayList<String> cCurrentIssuesArray){
		for(int i = 0; i < cCurrentIssuesArray.size(); i++) {
			if(currentIssuesArray.get(i).equals(cCurrentIssuesArray.get(i)) == false) {
				currentIssuesArray.set(i, cCurrentIssuesArray.get(i));
			}
		}
		
		return currentIssuesArray;
	}
	
	public ArrayList<String> getCurrentIssues(){
		return currentIssuesArray;
	}
	
	public static int getCurrentIssuesSize() {
		return currentIssuesArray.size();
	}
	
}
