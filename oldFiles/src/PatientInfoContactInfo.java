/**
 * Patient Contact Information
 * 1. creates a contact information
 * 2. can change contact information
 * 3. can get contact information
 * @author Ada
 *
 */

public class PatientInfoContactInfo {
	public static String mainPhoneNumber;
	public static String homePhoneNumber;
	public static String emergencyPhoneNumber;
	public static String email;
	public static String secondEmail;

	public PatientInfoContactInfo(String fmainP, String fhomeP, String fEmerP, String femail, String secEmail) {
		mainPhoneNumber = fmainP;
		homePhoneNumber = fhomeP;
		emergencyPhoneNumber = fEmerP;
		email = femail;
		secondEmail = secEmail;
	}

	public String mainPhoneNumberChange(String cmainP) {
		mainPhoneNumber = cmainP;
		return mainPhoneNumber;
	}

	public String homePhoneNumberChange(String chomeP) {
		homePhoneNumber = chomeP;
		return homePhoneNumber;
	}

	public String emergencyPhoneNumberChange(String cEmerP) {
		emergencyPhoneNumber = cEmerP;
		return emergencyPhoneNumber;
	}

	public String emailChange(String cemail) {
		email = cemail;
		return email;
	}

	public String secondEmailChange(String cSecEmail) {
		secondEmail = cSecEmail;
		return secondEmail;
	}

	public String getMainPhoneNumber() {
		return mainPhoneNumber;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getEmergencyPhoneNumber() {
		return emergencyPhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getsecondEmail() {
		return secondEmail;
	}

	public String getFullContact() {
		return mainPhoneNumber + " " + homePhoneNumber + " " + emergencyPhoneNumber + 
				" " + email + " " + secondEmail;
	}
}