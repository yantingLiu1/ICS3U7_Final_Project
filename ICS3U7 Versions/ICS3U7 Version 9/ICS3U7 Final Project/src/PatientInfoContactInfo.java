/**
 *Creates Patient Contact Information
 * @author Ada
 */

public class PatientInfoContactInfo {
	//declare variables
    private static String mainPhoneNumber;

    /**
     * Constructor for the Patient Contact Info Class
     * @param fmainP
     */
    public PatientInfoContactInfo(String fmainP) {
        mainPhoneNumber = fmainP;
    }

    /**
     * Changes main phone numbers
     * @param cmainP
     * @return main phone number
     */
    public String mainPhoneNumberChange(String cmainP) {
        mainPhoneNumber = cmainP;
        return mainPhoneNumber;
    }

    /**
     * gets main phone number
     * @return main phone number
     */
    public String getMainPhoneNumber() {
        return mainPhoneNumber;
    }

    /**
     * get full contact
     * @return full contact
     */
    public String getFullContact() {
        return mainPhoneNumber;
    }
}