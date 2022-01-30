/**
 * Creates a patient info address
 * @author Ada
 *
 */

public class PatientInfoAddress {
	
	//declare variables
    private static String address = "";
    private static String city = "";
    private static String province = "";

    /**
     * Contructor for the patient info address
     * @param fAddress
     * @param fCity
     * @param fProvince
     */
    public PatientInfoAddress(String fAddress, String fCity, String fProvince) {
        address = fAddress;
        city = fCity;
        province = fProvince;
    }

    /**
     * Changes the street
     * @param cAddress
     * @return changed street
     */
    public String changeStreet(String cAddress) {
        address = cAddress;
        return address;
    }

    /**
     * Changes the city
     * @param cCity
     * @return changed city 
     */
    public String changeCity(String cCity) {
        city = cCity;
        return city;
    }
    
    /**
     * Changes the province
     * @param cProvince
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