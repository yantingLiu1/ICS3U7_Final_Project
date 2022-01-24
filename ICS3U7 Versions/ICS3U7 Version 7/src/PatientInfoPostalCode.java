/**
 * Patient Information Postal Code
 * 1. creates a postal code
 * 2. changes a postal code
 * 3. gets a postal code
 *
 * @author Ada
 */

public class PatientInfoPostalCode {

    public static String postalCode;

    public PatientInfoPostalCode(String fPostal) {
        postalCode = fPostal;
    }

    public String changePostalCode(String cPostal) {
        postalCode = cPostal;
        return postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

}