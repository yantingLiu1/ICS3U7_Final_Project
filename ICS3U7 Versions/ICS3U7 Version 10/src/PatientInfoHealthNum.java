/**
 * Patient Information Health Number *
 * @author Ada
 */

public class PatientInfoHealthNum {

	//declare variables
    private String healthNumber;

    /**
     * string constructor for patient info health number
     * @param fHealthNumber
     */
    public PatientInfoHealthNum(String fHealthNumber) {
        healthNumber = fHealthNumber;
    }

    /**
     * changes the health number
     * @param cHealthNumber
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