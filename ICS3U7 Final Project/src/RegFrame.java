import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class RegFrame extends JFrame implements ActionListener {
    String[] s1 = {"AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK"};
    public static String[] out = new String[9];
    
    /*
    * index:
    * 0: firstname
    * 1: lastname
    * 2: phone number
    * 3: address
    * 4: city
    * 5: province
    * 6: postal code
    * 7: health number
    * 8: notes
    * */

    public static String path = "\\storedInformation\\";
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

    RegFrame() {
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
        if (e.getSource() == register) {
            if (firstname.getText().equals("")|| lastname.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || city.getText().equals("") || postal.getText().equals("") || healthno.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All fields except notes must be filled in");
            }
            else if(!isPostal(postal.getText())){
                JOptionPane.showMessageDialog(this,"Postal code is invalid");
            }

            else{
                out[0] = firstname.getText();
                out[1] = lastname.getText();
                out[2] = phone.getText();
                out[3] = address.getText();
                out[4] = city.getText();
                out[5] = (String)province.getSelectedItem();
                out[6] = postal.getText();
                out[7] = healthno.getText();
                out[8] = notes.getText();
                
        		setIntoFile(out);
            
            }
        }
        if (e.getSource() == clear){
            firstname.setText("");
            lastname.setText("");
            phone.setText("");
            address.setText("");
            city.setText("");
            postal.setText("");
            healthno.setText("");
        }
 
    }
    
	

	public static void setIntoFile(String[] array) {
		
	    PatientInfoName nameTemp = new PatientInfoName(array[0], array[1]);
		PatientInfoContactInfo contactTemp = new PatientInfoContactInfo(array[2]);
		PatientInfoAddress addressTemp = new PatientInfoAddress(array[3], array[4], array[5]);
		PatientInfoPostalCode postalCodeTemp = new PatientInfoPostalCode(array[6]);
		PatientInfoHealthNum healthNumTemp = new PatientInfoHealthNum(array[7]);
		PatientInfoNotes noteTemp = new PatientInfoNotes(array[8]);	
		
		String pathForFile = "storedInformation\\";
		String folderName = healthNumTemp.getHealthNumber();
		boolean fileMade;
	    if(folderName != null ) {
		for(int i = 0; i < 1; i++) {
			
			String path_revised = path + folderName;
			File f1 = new File(pathForFile);
			f1 = new File(path_revised);
			fileMade = f1.mkdirs();

			if(fileMade) {
				System.out.println("Folder made");
			}
			else {
				System.out.println("Folder not made");
			}

		}
	    }
	    else {
	    	System.out.println("Folder name was null");
	    }

		try{

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

			Writer patientInfoWriterName = new FileWriter(fileNameName);
			Writer patientInfoWriterContact = new FileWriter(fileNameContact);
			Writer patientInfoWriterAddress = new FileWriter(fileNameAddress);
			Writer patientInfoWriterCity = new FileWriter(fileNameCity);
			Writer patientInfoWriterProvince = new FileWriter(fileNameProvince);
			Writer patientInfoWriterPostalCode = new FileWriter(fileNamePostalCode);
			Writer patientInfoWriterHealthNum = new FileWriter(fileNameHealthNum);
			Writer patientInfoWriterNotes = new FileWriter(fileNameNotes);
			Writer patientInfoWriterAllHealthNumber = new FileWriter(fileAllHealthNumber);

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
			
			patientInfoWriterName.close();
			patientInfoWriterContact.close();
			patientInfoWriterAddress.close();
			patientInfoWriterCity.close();
			patientInfoWriterProvince.close();
			patientInfoWriterPostalCode.close();
			patientInfoWriterHealthNum.close();
			patientInfoWriterNotes.close();
			patientInfoWriterAllHealthNumber.close();

		}
		catch(IOException ex) {
			System.out.println("The file was not written");
		}
	}
    
    public static boolean isPostal(String s) {
        if(s.length()!=6){
            return false;
        }
        char[] p = new char[6];

        for(int i = 0; i < 6; i++){
            p[i] = s.charAt(i);
        }
        for(int i = 0;i<6;i+=2){
            if(!Character.isLetter(p[i])){
                return false;
            }
        }
        for(int i = 1; i < 6;i+=2){
            if(!Character.isDigit(p[i])){
                return false;
            }
        }
        return true;

    }
    
    public String[] getValues() {
    	return out;
    }
    
}
