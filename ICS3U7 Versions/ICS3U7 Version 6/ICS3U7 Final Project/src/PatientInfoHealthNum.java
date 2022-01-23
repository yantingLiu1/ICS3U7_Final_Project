/**
 * Patient Information Health Number
 * 1. creates a health number
 * 2. changes a health number
 * 3. gets a health number
 *
 * @author Ada
 */

public class PatientInfoHealthNum {

    public String healthNumber;

    public PatientInfoHealthNum(String fHealthNumber) {
        healthNumber = fHealthNumber;
    }

    public String changeHealthNumber(String cHealthNumber) {
        healthNumber = cHealthNumber;
        return healthNumber;
    }

    public String getHealthNumber() {
        return healthNumber;
    }

}