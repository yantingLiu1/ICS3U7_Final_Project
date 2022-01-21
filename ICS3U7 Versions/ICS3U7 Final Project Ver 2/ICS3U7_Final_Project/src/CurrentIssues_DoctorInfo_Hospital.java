
public class CurrentIssues_DoctorInfo_Hospital {
	
	public static String doctorHospital;
	
	public CurrentIssues_DoctorInfo_Hospital(String fDoctorHospital) {
		doctorHospital = fDoctorHospital;
	}
	
	public static String changeHospital(String cDoctorHospital) {
		doctorHospital = cDoctorHospital;
		return doctorHospital;
	}
	
	public String getHospital() {
		return doctorHospital;
	}
	
}
