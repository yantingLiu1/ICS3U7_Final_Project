
public class GeneralHistory_Disease {
	
	public static String disease;
	
	public GeneralHistory_Disease(String fDisease) {
		disease = fDisease;
	}
	
	public static String changeDisease(String cDisease) {
		disease = cDisease;
		return disease;
	}
	
	public static String getDisease() {
		return disease;
	}
	
}
