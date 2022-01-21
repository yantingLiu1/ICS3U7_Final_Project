
public class CurrentIssues_HospitalTime {
	
	public static String assumedTime, actualTime;
	
	public CurrentIssues_HospitalTime(String fAssumedTime, String fActualTime) {
		assumedTime = fAssumedTime;
		actualTime = fActualTime;
	}
	
	public static String changeAssumedTime(String cAssumedTime) {
		assumedTime = cAssumedTime;
		return assumedTime;
	}
	
	public static String changeActualTime(String cActualTime) {
		actualTime = cActualTime;
		return actualTime;
	}
	
	public static String getAssumedTime() {
		return assumedTime;
	}
	
	public static String getActualTime() {
		return actualTime;
	}
	
	public String getFullTime() {
		return assumedTime + "$$" + actualTime;
	}
	
}
