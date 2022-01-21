/**
 * Patient Information Name
 * 1. creates a name
 * 2. changes a name
 * 3. gets a name
 * @author Ada
 *
 */

public class PatientInfoName {
	
	private static String firstNameOfPatient = "";
	private static String lastNameOfPatient = "";
	
	public PatientInfoName(String firstName, String lastName) {
		firstNameOfPatient = firstName;
		lastNameOfPatient = lastName;
	}
	
	public String changeFirstName(String firstNameChanged) {
		firstNameOfPatient = firstNameChanged;
		return firstNameOfPatient;
	}
	
	public String changeLastName(String lastNameChanged) {
		lastNameOfPatient = lastNameChanged;
		return lastNameOfPatient;
	}
	
	public String getFirstName() {
		return firstNameOfPatient;
	}
	
	public String getLastName() {
		return lastNameOfPatient;
	}
	
	public String getFullName() {
		return firstNameOfPatient + " " + lastNameOfPatient;
	}
	
}