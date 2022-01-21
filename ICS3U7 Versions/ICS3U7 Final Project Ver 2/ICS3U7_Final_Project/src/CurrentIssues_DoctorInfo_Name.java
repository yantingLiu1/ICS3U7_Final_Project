
public class CurrentIssues_DoctorInfo_Name {
	
	public static String name;
	
	public CurrentIssues_DoctorInfo_Name(String fName) {
		name = fName;
	}
	
	public static String changeDoctorName(String cName) {
		name = cName;
		return name;
	}
	
	public String getDoctorName() {
		return name;
	}
	
}
