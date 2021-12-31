import java.util.*;

public class GeneralHistory {
	
	public static HashMap<String, ArrayList<String>> generalHistoryHM = new HashMap<String, ArrayList<String>>();
	public static ArrayList<String> fGeneralHistoryArray = new ArrayList<String>();
	public static ArrayList<String> cGeneralHistoryArray = new ArrayList<String>();
	
	public GeneralHistory(ArrayList<String> fDiseaseHistoryArray, ArrayList<String> fEconomicArray, ArrayList<String> fHistoryArray) {
		generalHistoryHM.put("disease", fDiseaseHistoryArray);
		generalHistoryHM.put("economic", fEconomicArray);
		generalHistoryHM.put("history", fHistoryArray);
	}
	
	public static HashMap<String, ArrayList<String>> changeGeneralHistory(ArrayList<String> cDiseaseHistoryArray, ArrayList<String> cEconomicArray, ArrayList<String> cHistoryArray) {
		generalHistoryHM.clear();
		
		generalHistoryHM.put("disease", cDiseaseHistoryArray);
		generalHistoryHM.put("economic", cEconomicArray);
		generalHistoryHM.put("history", cHistoryArray);
		
		return generalHistoryHM;
	}
	
	public static HashMap<String, ArrayList<String>> getGeneralHistory(){
		return generalHistoryHM;
	}
	
}
