/**
 * Patient Contact Information
 * 1. creates a contact information
 * 2. can change contact information
 * 3. can get contact information
 * @author Ada
 *
 */

public class PatientInfoContactInfo {
	private static String mainPhoneNumber;

	public PatientInfoContactInfo(String fmainP) {
		mainPhoneNumber = fmainP;
	}
	
	public String mainPhoneNumberChange(String cmainP) {
		mainPhoneNumber = cmainP;
		return mainPhoneNumber;
	}

	public String getMainPhoneNumber() {
		return mainPhoneNumber;
	}
}