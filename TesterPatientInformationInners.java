/**
 * Patient Info:
 * 	1. Name
 *  2. Address
 *  3. Contact Info
 *  4. Health Num
 *  5. Postal Code
 *  
 *  They work, tested them. I'm going to add a remove to them later
 * @author Ada
 *
 */

public class TesterPatientInformationInners {
	public static void main(String[] args) {
		
		//Name
		PatientInfoName myName = new PatientInfoName("Yuuichi", "Katagiri");
		
		//gets name
		System.out.println(myName.getFullName());
		
		//changes first name and gets first name
		myName.changeFirstName("Yuu-chan");
		System.out.println(myName.getFirstName());
		
		//changes last name and gets last name
		myName.changeLastName("Katagiri-san");
		System.out.println(myName.getLastName());
		
		//gets full name (should be Yuu-chan Katagiri-san)
		System.out.println(myName.getFullName());
		
		System.out.println("---");
		
		//Contact Info
		PatientInfoContactInfo myInfo = new PatientInfoContactInfo("123", "123", "123", "bleh", "blah");
		
		//gets contact
		System.out.println(myInfo.getFullContact());
		
		System.out.println("-");
		
		//changes phone numbers and gets them
		myInfo.mainPhoneNumberChange("321");
		myInfo.homePhoneNumberChange("321");
		myInfo.emergencyPhoneNumberChange("321");
		
		System.out.println(myInfo.getMainPhoneNumber());
		System.out.println(myInfo.getHomePhoneNumber());
		System.out.println(myInfo.getEmergencyPhoneNumber());
		
		System.out.println("-");
		
		//changes emails and gets them
		myInfo.emailChange("yuuichiKatagiri@gmail.com");
		myInfo.secondEmailChange("dazaiOsamu@gmail.com");
		
		System.out.println(myInfo.getEmail());
		System.out.println(myInfo.getsecondEmail());
		
		System.out.println("-");
		
		//gets full contact info
		System.out.println(myInfo.getFullContact());
		
		System.out.println("---");
		
		//Address
		PatientInfoAddress myAddress = new PatientInfoAddress("Childe", "Fyodor", "Ei", "Yosano");
		
		//gets address
		System.out.println(myAddress.getFullAddress());
		
		System.out.println("-");
		
		//changes address and gets them
		myAddress.changeStreet("Jesse");
		myAddress.changeCity("Brown");
		myAddress.changeProvince("Law");
		myAddress.changeCountry("Chester");
		
		System.out.println(myAddress.getStreet());
		System.out.println(myAddress.getCity());
		System.out.println(myAddress.getProvince());
		System.out.println(myAddress.getCountry());
		
		System.out.println("-");
		
		//gets full address
		System.out.println(myAddress.getFullAddress());
		
		System.out.println("---");
		
		//Health Number
		PatientInfoHealthNum myHealthNum = new PatientInfoHealthNum("123");
		
		//gets health number
		System.out.println(myHealthNum.getHealthNumber());
		
		//changes health number and gets it
		myHealthNum.changeHealthNumber("321");
		System.out.println(myHealthNum.getHealthNumber());
		
		System.out.println("---");
		
		//Postal Code
		PatientInfoPostalCode myPostalCode = new PatientInfoPostalCode("TomodachiGame");
		
		//gets health number
		System.out.println(myPostalCode.getPostalCode());
		
		//changes postal code and gets it
		myPostalCode.changePostalCode("Rapport");
		System.out.println(myPostalCode.getPostalCode());
		
		
	}
}
