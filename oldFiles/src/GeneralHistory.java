import java.util.*;

public class GeneralHistory {
	
	public static ArrayList<String> fullPatientHistory = new ArrayList<String>();
	public static String disease = "";
	public static String economicSituation;
	public static String patientHistory;
	
	public static ArrayList<String> fullGeneralHistoryArray = new ArrayList<String>();
	
	public GeneralHistory(ArrayList<String> fDisease, String fEconomicSituation, String fPatientHistory) {
		for(int i = 0; i < fDisease.size(); i++) {
			disease += fDisease.get(i) + " ";
		}
		
		economicSituation = fEconomicSituation;
		patientHistory = fPatientHistory;
		
		fullPatientHistory.add(disease);
		fullPatientHistory.add(economicSituation);
		fullPatientHistory.add(patientHistory);
		
	}
	
	public static ArrayList<String> changeFullGeneralHistory(ArrayList<String> cDisease, String cEconomicSituation, String cPatientHistory){
		
		disease = "";
		
		for(int i = 0; i < cDisease.size(); i++) {
			disease += cDisease.get(i) + " ";
		}
		
		economicSituation = cEconomicSituation;
		patientHistory = cPatientHistory;
		
		fullPatientHistory.set(0, disease);
		fullPatientHistory.set(1, economicSituation);
		fullPatientHistory.set(2, patientHistory);
		
		return fullPatientHistory;
	}
	
	public static ArrayList<String> changeDiseaseGeneralHistory(ArrayList<String> cDisease){
		disease = "";
		for(int i = 0; i < cDisease.size(); i++) {
			disease += cDisease.get(i) + " ";
		}
		
		fullPatientHistory.set(0, disease);
		
		return fullPatientHistory;
	}
	
	public static ArrayList<String> changeEcoSitGeneralHistory(String cEconomicSituation){
		economicSituation = cEconomicSituation;
		
		fullPatientHistory.set(1, economicSituation);
		
		return fullPatientHistory;
	}
	
	public static ArrayList<String> changePatientHistory(String cPatientHistory){
		patientHistory = cPatientHistory;
		
		fullPatientHistory.set(2, cPatientHistory);
		
		return fullPatientHistory;
	}
		
	public static ArrayList<String> getGeneralHistory(){		
		return fullPatientHistory;
	}
	
	public int getGeneralHistorySize() {
		return fullPatientHistory.size();
	}
	
}
