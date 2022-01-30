/**
 * Patient Information Health Number *
 * @author Ada
 */

public class PatientInfoHealthNum {

	//declare variables
    String healthNumber;

    /**
     * string constructor for patient info health number
     * @param fHealthNumber Health number of the patient
     */
    public PatientInfoHealthNum(String fHealthNumber) {
        healthNumber = fHealthNumber;
    }

    /**
     * changes the health number
     * @param cHealthNumber Changed health number of patient
     * @return changed health number
     */
    public String changeHealthNumber(String cHealthNumber) {
        healthNumber = cHealthNumber;
        return healthNumber;
    }
    
    /**
     * gets health number
     * @return health number
     */
    public String getHealthNumber() {
        return healthNumber;
    }

}