/**
 * Creates a patient info address
 * @author Ada
 *
 */

public class PatientInfoAddress {
	
	//declare variables
    String address = "";
    String city = "";
    String province = "";

    /**
     * Contructor for the patient info address
     * @param fAddress Address of the patient
     * @param fCity City of the patient
     * @param fProvince Province of the patient
     */
    public PatientInfoAddress(String fAddress, String fCity, String fProvince) {
        address = fAddress;
        city = fCity;
        province = fProvince;
    }

    /**
     * Changes the street
     * @param cAddress Changed address of patient
     * @return changed street
     */
    public String changeAddress(String cAddress) {
        address = cAddress;
        return address;
    }

    /**
     * Changes the city
     * @param cCity Changed city of the patient
     * @return changed city 
     */
    public String changeCity(String cCity) {
        city = cCity;
        return city;
    }
    
    /**
     * Changes the province
     * @param cProvince Changed province of the patient
     * @return changed province
     */
    public String changeProvince(String cProvince) {
        province = cProvince;
        return province;
    }
    
    /**
     * Gets the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the city
     * @return city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Gets the province
     * @return province
     */
    public String getProvince() {
        return province;
    }

}