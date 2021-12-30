
public class CurrentIssues_DoctorInfo_Contact {
	
	public static String doctorMainPhone;
	public static String doctorHomePhone;
	public static String doctorEmerPhone;
	
	public CurrentIssues_DoctorInfo_Contact(String fDoctorMainPhone, String fDoctorHomePhone, String fDoctorEmerPhone) {
		doctorMainPhone = fDoctorMainPhone;
		doctorHomePhone = fDoctorHomePhone;
		doctorEmerPhone = fDoctorEmerPhone;
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
	
}
