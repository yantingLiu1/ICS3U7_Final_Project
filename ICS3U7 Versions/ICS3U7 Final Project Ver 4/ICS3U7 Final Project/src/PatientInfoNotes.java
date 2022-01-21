public class PatientInfoNotes {
	private static String notes;
	
	public PatientInfoNotes(String fNotes) {
		notes = fNotes;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public static String changeNotes(String cNotes) {
		notes = cNotes;
		
		return notes;
	}
}