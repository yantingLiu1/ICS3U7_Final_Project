/**
 * Creates a patient info notes
 * @author Ada
 *
 */

public class PatientInfoNotes {
	
	//declare variables
    public static String notes;

    /**
     * constructor for the patient info notes
     * @param fNotes
     */
    public PatientInfoNotes(String fNotes) {
        notes = fNotes;
    }
    
    /**
     * gets the note
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * changes the notes
     * @param cNotes 
     * @return changed note
     */
    public static String changeNotes(String cNotes) {
        notes = cNotes;

        return notes;
    }
}