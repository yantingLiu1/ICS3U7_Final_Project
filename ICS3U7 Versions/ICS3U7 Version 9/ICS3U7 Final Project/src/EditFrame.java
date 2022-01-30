import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * Edit frame of the GUI 
 * @author Roshan
 *
 */

public class EditFrame extends JDialog implements ActionListener {

	//Declare Variables
    String[] s1 = {"AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK"};
    public static String[] out = new String[9];

    public static String path = "storedInformation\\";
    public static String[] patientInfoArray = new String[9];
    JButton reset = new JButton("Reset");
    JButton apply = new JButton("Apply");

    JTextField firstname;
    JTextField lastname;
    JTextField phone;
    JTextField address;
    JTextField city;
    JComboBox province;
    JTextField postal;
    JTextField healthno;
    JTextArea notes;
    String firstnamestr;
    String lastnamestr;
    String phonestr;
    String addressstr;
    String citystr;
    String provincestr;
    String postalstr;
    String healthnumstr;
    String notesstr;
    String folderName;

    int index = 0;

    /**
     * Edit frame of the GUI 
     * @param folder
     */
    EditFrame(String folder) {

        setLayout(null);

        //Reads the current files and rewrites them the files
        String pathForFile = "storedInformation\\";
        folderName = folder;
        try{
        	//Create file
            String fileNameName = pathForFile + folderName + "\\name.txt";
            String fileNameContact = pathForFile + folderName + "\\contact.txt";
            String fileNameAddress = pathForFile + folderName + "\\address.txt";
            String fileNameCity = pathForFile + folderName + "\\city.txt";
            String fileNameProvince = pathForFile + folderName + "\\province.txt";
            String fileNamePostalCode = pathForFile + folderName + "\\postalCode.txt";
            String fileNameHealthNum = pathForFile + folderName + "\\healthNumber.txt";
            String fileNameNotes = pathForFile + folderName + "\\note.txt";
            
            //Create reader
            BufferedReader patientInfoReaderName = new BufferedReader(new FileReader(fileNameName));
            BufferedReader patientInfoReaderContact = new BufferedReader(new FileReader(fileNameContact));
            BufferedReader patientInfoReaderAddress = new BufferedReader(new FileReader(fileNameAddress));
            BufferedReader patientInfoReaderCity = new BufferedReader(new FileReader(fileNameCity));
            BufferedReader patientInfoReaderProvince = new BufferedReader(new FileReader(fileNameProvince));
            BufferedReader patientInfoReaderPostalCode = new BufferedReader(new FileReader(fileNamePostalCode));
            BufferedReader patientInfoReaderHealthNum = new BufferedReader(new FileReader(fileNameHealthNum));
            BufferedReader patientInfoReaderNotes = new BufferedReader(new FileReader(fileNameNotes));
            
            //Reads files into the strings
            firstnamestr = patientInfoReaderName.readLine();
            lastnamestr = patientInfoReaderName.readLine();
            phonestr = patientInfoReaderContact.readLine();
            addressstr = patientInfoReaderAddress.readLine();
            citystr = patientInfoReaderCity.readLine();
            provincestr = patientInfoReaderProvince.readLine();
            postalstr = patientInfoReaderPostalCode.readLine();
            healthnumstr = patientInfoReaderHealthNum.readLine();

            //reads file NOTES into a string array
            String line;
            ArrayList<String> al = new ArrayList<>();
            while ((line = patientInfoReaderNotes.readLine()) != null) {
                al.add(line);
            }
            
            String[] notesarr = al.toArray(new String[0]);
            notesstr = "";
            for(int i = 0; i < notesarr.length;i++){
                notesstr+=notesarr[i];
                notesstr+="\n";
            }
            System.out.println(notesstr);

            patientInfoReaderAddress.close();
            patientInfoReaderCity.close();
            patientInfoReaderContact.close();
            patientInfoReaderHealthNum.close();
            patientInfoReaderName.close();
            patientInfoReaderNotes.close();
            patientInfoReaderPostalCode.close();
            patientInfoReaderProvince.close();

        }
        catch(IOException ex){
            System.out.println("something went wrong");
        }
        
        //adds the province string
        System.out.println(provincestr);
        index = 0;
        while(!s1[index].equals(provincestr)){
            index++;
        }
        //Creates textfields
        firstname = new JTextField(firstnamestr);
        lastname = new JTextField(lastnamestr);
        phone = new JTextField(phonestr);
        address = new JTextField(addressstr);
        city = new JTextField(citystr);
        province = new JComboBox(s1);
        province.setSelectedItem(provincestr);
        postal = new JTextField(postalstr);
        healthno = new JTextField(healthnumstr);
        notes = new JTextArea(notesstr);
        
        //Adds labels to frame
        add(new CustomLabel("First name:", 30, 40, 150, 30));
        add(new CustomLabel("Last name:", 280, 40, 150, 30));
        add(new CustomLabel("Phone Number:", 530, 40, 150, 30));

        add(new CustomLabel("Address:", 30, 110, 150, 30));
        add(new CustomLabel("City:", 280, 110, 150, 30));
        add(new CustomLabel("Province:", 460, 110, 100, 30));
        add(new CustomLabel("Postal Code:", 560, 110, 100, 30));

        add(new CustomLabel("Health Number:", 30, 180, 150, 30));

        add(new CustomLabel("Notes:", 30, 250, 100, 30));

        //Sets the textfield size
        firstname.setBounds(30, 70, 230, 30);
        lastname.setBounds(280, 70, 230, 30);
        phone.setBounds(530, 70, 230, 30);

        address.setBounds(30, 140, 230, 30);
        city.setBounds(280, 140, 150, 30);
        province.setBounds(460, 140, 70, 30);
        postal.setBounds(560, 140, 85, 30);

        healthno.setBounds(30, 210, 230, 30);

        notes.setBounds(30, 280, 800, 200);

        reset.setBounds(610, 530, 80, 30);
        apply.setBounds(740, 530, 90, 30);

        //adds textfield to frame
        add(firstname);
        add(lastname);
        add(phone);

        add(address);
        add(city);
        add(province);
        add(postal);

        add(healthno);

        add(notes);

        add(reset);
        add(apply);

        reset.addActionListener(this);
        apply.addActionListener(this);

    }

    @Override
    /**
     * Checks for different actions
     */
    public void actionPerformed(ActionEvent e) {
    	
    	//Checks for the new text, deletes the old files before replacing them with new ones
        if (e.getSource() == apply) {
            if (firstname.getText().equals("") || lastname.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || city.getText().equals("") || postal.getText().equals("") || healthno.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All fields except notes must be filled in");
            } else if (!isPostal(postal.getText())) {
                JOptionPane.showMessageDialog(this, "Postal code is invalid");
            } else {
                purgeFiles(new File(path + folderName));
                out[0] = firstname.getText();
                out[1] = lastname.getText();
                out[2] = phone.getText();
                out[3] = address.getText();
                out[4] = city.getText();
                out[5] = (String) province.getSelectedItem();
                out[6] = postal.getText();
                out[7] = healthno.getText();
                out[8] = notes.getText();
                index = 0;
                setIntoFileEdit(out);
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));


            }
        }
        //Sets all fields to ""
        if (e.getSource() == reset) {
            firstname.setText(firstnamestr);
            lastname.setText(lastnamestr);
            phone.setText(phonestr);
            address.setText(addressstr);
            city.setText(citystr);
            postal.setText(postalstr);
            healthno.setText(healthnumstr);
            province.setSelectedIndex(index);
            notes.setText(notesstr);
        }

    }

    /**
     * Creates file template and fills in values for them based on the patient
     * @param array
     */
    public static void setIntoFileEdit(String[] array) {
    	
    	//declare variables
    	//creates temp instances based on the PatientInfo classes
        PatientInfoName nameTemp = new PatientInfoName(array[0], array[1]);
        PatientInfoContactInfo contactTemp = new PatientInfoContactInfo(array[2]);
        PatientInfoAddress addressTemp = new PatientInfoAddress(array[3], array[4], array[5]);
        PatientInfoPostalCode postalCodeTemp = new PatientInfoPostalCode(array[6]);
        PatientInfoHealthNum healthNumTemp = new PatientInfoHealthNum(array[7]);
        PatientInfoNotes noteTemp = new PatientInfoNotes(array[8]);

        String pathForFile = "storedInformation\\";
        String folderName = healthNumTemp.getHealthNumber();

        try {
        	//creates the file
            String space = "\n";
            String fileNameName = pathForFile + folderName + "\\name.txt";
            String fileNameContact = pathForFile + folderName + "\\contact.txt";
            String fileNameAddress = pathForFile + folderName + "\\address.txt";
            String fileNameCity = pathForFile + folderName + "\\city.txt";
            String fileNameProvince = pathForFile + folderName + "\\province.txt";
            String fileNamePostalCode = pathForFile + folderName + "\\postalCode.txt";
            String fileNameHealthNum = pathForFile + folderName + "\\healthNumber.txt";
            String fileNameNotes = pathForFile + folderName + "\\note.txt";
            String fileAllHealthNumber = pathForFile + "\\AllHealthNumbers.txt";

            //creates buffer writer for the files
            BufferedWriter patientInfoWriterName = new BufferedWriter(new FileWriter(fileNameName));
            BufferedWriter patientInfoWriterContact = new BufferedWriter(new FileWriter(fileNameContact));
            BufferedWriter patientInfoWriterAddress = new BufferedWriter(new FileWriter(fileNameAddress));
            BufferedWriter patientInfoWriterCity = new BufferedWriter(new FileWriter(fileNameCity));
            BufferedWriter patientInfoWriterProvince = new BufferedWriter(new FileWriter(fileNameProvince));
            BufferedWriter patientInfoWriterPostalCode = new BufferedWriter(new FileWriter(fileNamePostalCode));
            BufferedWriter patientInfoWriterHealthNum = new BufferedWriter(new FileWriter(fileNameHealthNum));
            BufferedWriter patientInfoWriterNotes = new BufferedWriter(new FileWriter(fileNameNotes));
            BufferedWriter patientInfoWriterAllHealthNumber = new BufferedWriter(new FileWriter(fileAllHealthNumber, true));

            //writes the information into the files
            patientInfoWriterName.write(nameTemp.getFirstName());
            patientInfoWriterName.write(space);
            patientInfoWriterName.write(nameTemp.getLastName());

            patientInfoWriterContact.write(contactTemp.getMainPhoneNumber());

            patientInfoWriterAddress.write(addressTemp.getAddress());

            patientInfoWriterCity.write(addressTemp.getCity());

            patientInfoWriterProvince.write(addressTemp.getProvince());

            patientInfoWriterPostalCode.write(postalCodeTemp.getPostalCode());

            patientInfoWriterHealthNum.write(healthNumTemp.getHealthNumber());

            patientInfoWriterNotes.write(noteTemp.getNotes());

            patientInfoWriterAllHealthNumber.write(healthNumTemp.getHealthNumber());
            patientInfoWriterAllHealthNumber.newLine();

            patientInfoWriterName.close();
            patientInfoWriterContact.close();
            patientInfoWriterAddress.close();
            patientInfoWriterCity.close();
            patientInfoWriterProvince.close();
            patientInfoWriterPostalCode.close();
            patientInfoWriterHealthNum.close();
            patientInfoWriterNotes.close();
            patientInfoWriterAllHealthNumber.close();

        } catch (IOException ex) {
            System.out.println("The file was not written");
        }
    }
    /**
     * Deletes the files
     * @param dir
     */
    void purgeFiles(File dir) {
    	
    	//Finds the files
        File Name = new File(dir + "\\name.txt");
        File Contact = new File(dir + "\\contact.txt");
        File Address = new File(dir + "\\address.txt");
        File City = new File(dir + "\\city.txt");
        File Province = new File(dir + "\\province.txt");
        File PostalCode = new File(dir + "\\postalCode.txt");
        File HealthNum = new File(dir + "\\healthNumber.txt");
        File Notes = new File(dir + "\\note.txt");

        //deletes the files
        Name.delete();
        Contact.delete();
        Address.delete();
        City.delete();
        Province.delete();
        PostalCode.delete();
        HealthNum.delete();
        Notes.delete();
    }
    
    /**
     * Checks if the Postal code is valid
     * @param s
     * @return boolean TRUE if the Postal String is a valid Postal code
     */
    public static boolean isPostal(String s) {
        if (s.length() != 6) {
            return false;
        }
        char[] p = new char[6];

        for (int i = 0; i < 6; i++) {
            p[i] = s.charAt(i);
        }
        for (int i = 0; i < 6; i += 2) {
            if (!Character.isLetter(p[i])) {
                return false;
            }
        }
        for (int i = 1; i < 6; i += 2) {
            if (!Character.isDigit(p[i])) {
                return false;
            }
        }
        return true;

    }
    
    /**
     * Gets the values of the array for patient info
     * @return String array for the patient info
     */
    public String[] getValues() {
        return out;
    }

}