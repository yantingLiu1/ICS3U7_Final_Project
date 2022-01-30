/**
 * Creates a patient info notes
 * @author Ada
 *
 */

public class PatientInfoNotes {
	
	//declare variables
    String notes;

    /**
     * constructor for the patient info notes
     * @param fNotes Notes of patient
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
     * @param cNotes Changed notes of patient
     * @return changed note
     */
    public String changeNotes(String cNotes) {
        notes = cNotes;

        return notes;
    }
}