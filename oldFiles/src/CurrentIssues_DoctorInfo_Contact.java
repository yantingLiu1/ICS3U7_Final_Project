
public class CurrentIssues_DoctorInfo_Contact {
	
	public static String doctorMainPhone, doctorHomePhone, doctorEmerPhone, doctorFullInfo;
	
	public CurrentIssues_DoctorInfo_Contact(String fDoctorMainPhone, String fDoctorHomePhone, String fDoctorEmerPhone) {
		doctorMainPhone = fDoctorMainPhone;
		doctorHomePhone = fDoctorHomePhone;
		doctorEmerPhone = fDoctorEmerPhone;
		
		doctorFullInfo = doctorMainPhone + " " + doctorHomePhone + " " + doctorEmerPhone;
	}
	
	public static String changeDoctorMainPhone(String cDoctorMainPhone) {
		doctorMainPhone = cDoctorMainPhone;
		return doctorMainPhone;
	}
	
	public static String changeDoctorHomePhone(String cDoctorHomePhone) {
		doctorHomePhone = cDoctorHomePhone;
		return doctorHomePhone;
	}
	
	public static String changeDoctorEmerPhone(String cDoctorEmerPhone) {
		doctorEmerPhone = cDoctorEmerPhone;
		return doctorEmerPhone;
	}
	
	public static String getDoctorMainPhone() {
		return doctorMainPhone;
	}
	
	public static String getDoctorHomePhone() {
		return doctorHomePhone;
	}
	
	public static String getDoctorEmerPhone() {
		return doctorEmerPhone;
	}
	
	public static String getFullDoctorInfo() {
		return doctorFullInfo;
	}
	
}
