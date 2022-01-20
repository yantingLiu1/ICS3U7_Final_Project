
public class CurrentIssues_DoctorInfo_HeadNurse {
	
	public static String headNurse;
	
	public CurrentIssues_DoctorInfo_HeadNurse(String fHeadNurse) {
		headNurse = fHeadNurse;
	}
	
	public static String changeHeadNurse(String cHeadNurse) {
		headNurse = cHeadNurse;
		return headNurse;
	}
	
	public static String getHeadNuse() {
		return headNurse;
	}
	
}
