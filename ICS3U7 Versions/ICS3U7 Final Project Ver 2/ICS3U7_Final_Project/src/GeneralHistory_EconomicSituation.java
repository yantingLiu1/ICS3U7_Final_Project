
public class GeneralHistory_EconomicSituation {
	
	public static String economicSituation;
	public static String job;
	
	public GeneralHistory_EconomicSituation(String fEconomicSituation, String fJob) {
		economicSituation = fEconomicSituation;
		job = fJob;
	}
	
	public String changeEconomicSituation(String cEconomicSituation) {
		economicSituation = cEconomicSituation;
		return economicSituation;
	}
	
	public String changeJob (String cJob) {
		job = cJob;
		return job;
	}
	
	public String getEconomicSituation() {
		return economicSituation;
	}
	
	public String getJob() {
		return job;
	}
	
	public String getFullEcoJob(){
		return job + "$$" + economicSituation;
	}
	
}
