
public class PatientInfoAddress {
	public static String street = "";
	public static String city = "";
	public static String province = "";
	public static String country = ""; 
	
	public PatientInfoAddress(String fStreet, String fCity, String fProvince, String fCountry) {
		street = fStreet;
		city = fCity;
		province = fProvince;
		country = fCountry;
	}
	
	public String changeStreet(String cStreet) {
		street = cStreet;
		return street;
	}
	
	public String changeCity(String cCity) {
		city = cCity;
		return city;
	}
	
	public String changeProvince(String cProvince) {
		province = cProvince;
		return province;
	}
	
	public String changeCountry(String cCountry) {
		country = cCountry;
		return country;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getFullAddress() {
		return street + ", " + city + ", " + province + ", " + country;
	}
}
