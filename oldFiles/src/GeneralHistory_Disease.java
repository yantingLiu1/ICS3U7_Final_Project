import java.util.*;

public class GeneralHistory_Disease {
	
	public static ArrayList<String> diseaseAL = new ArrayList<String>();
	public static int count = 0;
	
	public static String diseaseName;
	
	public GeneralHistory_Disease(String... args) {		
		for(String arg: args) {
			count++;
			diseaseAL.add(arg);
		}
	}
	
	public static ArrayList<String> changeDisease(ArrayList<String> cDisease) {
		diseaseAL = cDisease;
		return diseaseAL;
	}
	
	public String getDiseaseString() {
		
		for(int i = 0; i < diseaseAL.size(); i++) {
			diseaseName += diseaseAL.get(i) + " ";
		}
		
		return diseaseName;
	}
	
	public ArrayList<String> getDisease() {
		
		return diseaseAL;
	}
	
	public int getDiseaseSize(){
		return diseaseAL.size();
	}
	
}
