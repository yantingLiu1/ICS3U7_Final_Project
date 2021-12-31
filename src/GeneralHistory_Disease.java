import java.util.*;

public class GeneralHistory_Disease {
	
	public static ArrayList<String> disease;
	
	public GeneralHistory_Disease(ArrayList<String> fDisease) {
		for(int i = 0; i < fDisease.size(); i++) {
			disease.add(fDisease.get(i));
		}
	}
	
	public static ArrayList<String> changeDisease(ArrayList<String> cDisease) {
		disease.clear();
		for(int i = 0; i < cDisease.size(); i++) {
			disease.add(cDisease.get(i));
		}
		return disease;
	}
	
	public static ArrayList<String> getDisease() {
		return disease;
	}
	
}
