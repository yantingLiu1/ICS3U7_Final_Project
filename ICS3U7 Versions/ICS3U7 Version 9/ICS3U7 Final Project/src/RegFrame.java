import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * Creates a register frame for the user to register a patient
 *
 * @author Roshan (GUI), Ada (File IO)
 */

public class RegFrame extends JDialog implements ActionListener {

    //declares variables
    String[] s1 = {"AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK"};
    public static String[] out = new String[9];

    public static String path = "storedInformation\\";
    public static String[] patientInfoArray = new String[9];
    JButton clear = new JButton("Clear");
    JButton register = new JButton("Register");

    JTextField firstname = new JTextField("");
    JTextField lastname = new JTextField("");
    JTextField phone = new JTextField("");
    JTextField address = new JTextField("");
    JTextField city = new JTextField("");
    JComboBox province = new JComboBox(s1);
    JTextField postal = new JTextField("");
    JTextField healthno = new JTextField("");
    JTextArea notes = new JTextArea("");

    /**
     * Constructor for the regframe
     */
    RegFrame() {

        //creates custom labels
        setLayout(null);
        add(new CustomLabel("First name:", 30, 40, 150, 30));
        add(new CustomLabel("Last name:", 280, 40, 150, 30));
        add(new CustomLabel("Phone Number:", 530, 40, 150, 30));

        add(new CustomLabel("Address:", 30, 110, 150, 30));
        add(new CustomLabel("City:", 280, 110, 150, 30));
        add(new CustomLabel("Province:", 460, 110, 100, 30));
        add(new CustomLabel("Postal Code:", 560, 110, 100, 30));

        add(new CustomLabel("Health Number:", 30, 180, 150, 30));

        add(new CustomLabel("Notes:", 30, 250, 100, 30));

        //sets the bounds for the textfields
        firstname.setBounds(30, 70, 230, 30);
        lastname.setBounds(280, 70, 230, 30);
        phone.setBounds(530, 70, 230, 30);

        address.setBounds(30, 140, 230, 30);
        city.setBounds(280, 140, 150, 30);
        province.setBounds(460, 140, 70, 30);
        postal.setBounds(560, 140, 85, 30);

        healthno.setBounds(30, 210, 230, 30);

        notes.setBounds(30, 280, 800, 200);

        clear.setBounds(610, 530, 80, 30);
        register.setBounds(740, 530, 90, 30);

        //adds the textfields to the frame
        add(firstname);
        add(lastname);
        add(phone);

        add(address);
        add(city);
        add(province);
        add(postal);

        add(healthno);

        add(notes);

        add(clear);
        add(register);

        clear.addActionListener(this);
        register.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //checks if the button clicked is register
        if (e.getSource() == register) {
            //checks if all fields are inputted
            if (firstname.getText().equals("") || lastname.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || city.getText().equals("") || postal.getText().equals("") || healthno.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All fields except notes must be filled in");
            } else if (!isPostal(postal.getText())) {
                JOptionPane.showMessageDialog(this, "Postal code is invalid");
            } else {
                //gets the textfield
                out[0] = firstname.getText();
                out[1] = lastname.getText();
                out[2] = phone.getText();
                out[3] = address.getText();
                out[4] = city.getText();
                out[5] = (String) province.getSelectedItem();
                out[6] = postal.getText();
                out[7] = healthno.getText();
                out[8] = notes.getText();

                setIntoFile(out);
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            }
        }

        //checks if the button pressed is clear
        if (e.getSource() == clear) {
            //sets all the textfields to an empty string
            firstname.setText("");
            lastname.setText("");
            phone.setText("");
            address.setText("");
            city.setText("");
            postal.setText("");
            healthno.setText("");
            notes.setText("");
        }

    }

    /**
     * Sets information into a file
     *
     * @param array
     */
    public static void setIntoFile(String[] array) {

        //creates patient info classes into a temp
        PatientInfoName nameTemp = new PatientInfoName(array[0], array[1]);
        PatientInfoContactInfo contactTemp = new PatientInfoContactInfo(array[2]);
        PatientInfoAddress addressTemp = new PatientInfoAddress(array[3], array[4], array[5]);
        PatientInfoPostalCode postalCodeTemp = new PatientInfoPostalCode(array[6]);
        PatientInfoHealthNum healthNumTemp = new PatientInfoHealthNum(array[7]);
        PatientInfoNotes noteTemp = new PatientInfoNotes(array[8]);

        //declares variables for the path as well as folder name
        String pathForFile = "storedInformation\\";
        String folderName = healthNumTemp.getHealthNumber();
        boolean fileMade;

        //checks if the foldername is valid
        if (folderName != null) {
            for (int i = 0; i < 1; i++) {

                //creates the folder
                String path_revised = path + folderName;
                File f1 = new File(pathForFile);
                f1 = new File(path_revised);
                fileMade = f1.mkdirs();

                if (fileMade) {
                    System.out.println("Folder made");
                } else {
                    System.out.println("Folder not made");
                }

            }
        } else {
            System.out.println("Folder name was null");
        }

        try {

            //creates file paths as well as writers for those paths
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
     * checks if the postal code is valid
     *
     * @param s
     * @return boolean for if the postal code is valid
     */
    public static boolean isPostal(String s) {

        //checks if length less than 6
        if (s.length() != 6) {
            return false;
        }

        //creates an array to check every letter
        char[] p = new char[6];

        for (int i = 0; i < 6; i++) {
            p[i] = s.charAt(i);
        }

        //checks if every second letter is a letter
        for (int i = 0; i < 6; i += 2) {
            if (!Character.isLetter(p[i])) {
                return false;
            }
        }

        //checks if every second digit(after letter)is a number
        for (int i = 1; i < 6; i += 2) {
            if (!Character.isDigit(p[i])) {
                return false;
            }
        }
        return true;

    }

    /**
     * gets string array of values
     *
     * @return values of the array
     */
    public String[] getValues() {
        return out;
    }

}