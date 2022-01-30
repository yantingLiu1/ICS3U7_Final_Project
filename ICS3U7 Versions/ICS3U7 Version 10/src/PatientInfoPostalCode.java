/**
 * Patient Information Postal Code
 * @author Ada
 */

public class PatientInfoPostalCode {

	//declare variables
    private static String postalCode;

    /**
     * constructor for the patient info postal code class
     * @param fPostal
     */
    public PatientInfoPostalCode(String fPostal) {
        postalCode = fPostal;
    }

    /**
     * changes the postal code
     * @param cPostal
     * @return changed postal code
     */
    public String changePostalCode(String cPostal) {
        postalCode = cPostal;
        return postalCode;
    }

    /**
     * gets postal code
     * @return postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

}