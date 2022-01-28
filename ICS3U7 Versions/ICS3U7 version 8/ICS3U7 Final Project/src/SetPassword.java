import java.io.*;

/**
 * Creates a password as well as change it
 * @author Ada
 *
 */

public class SetPassword {

	//declare variables
	String path = "storedInformation\\";
	String passwordFileName = "passwordName.txt";
	String usernameFileName = "usernameName.txt";
	String password = "1234";
	String username = "1234";
	String[] passwordUsername = new String[2];

	/**
	 * Constructor for creating a password
	 */
	public SetPassword(String p, String u){
		try {

			//creates a file for password and usename
			FileWriter passwordFile = new FileWriter(passwordFileName);
			FileWriter usernameFile = new FileWriter(usernameFileName);
			BufferedWriter passwordWriter = new BufferedWriter(passwordFile);
			BufferedWriter usernameWriter = new BufferedWriter(usernameFile);

			//writes in the password and username
			passwordWriter.write(p);
			usernameWriter.write(u);

			passwordWriter.close();
			usernameWriter.close();

		}
		catch(IOException ex) {
			System.out.println("File unmade");
		}
	}

	/**
	 * gets the password
	 * @return string array of password
	 */
	public String[] getPassword() {
		try {
			//reads the file for password and username
			FileReader passwordFileRead = new FileReader(passwordFileName);
			FileReader usernameFileRead = new FileReader(usernameFileName);
			BufferedReader passwordReader = new BufferedReader(passwordFileRead);
			BufferedReader usernameReader = new BufferedReader(usernameFileRead);

			//reads each line
			passwordUsername[0] = usernameReader.readLine();
			passwordUsername[1] = passwordReader.readLine();

			passwordReader.close();
			usernameReader.close();

		}
		catch(IOException ex) {
			System.out.println("File unread");
		}

		return passwordUsername;
	}

	/**
	 * changes the password
	 * @param cUsername
	 * @param cPassword
	 */
	public void changePassword(String cUsername, String cPassword) {
		try {
			//overwrites the password file
			FileWriter passwordFile = new FileWriter(passwordFileName, false);
			FileWriter usernameFile = new FileWriter(usernameFileName, false);
			BufferedWriter passwordWriter = new BufferedWriter(passwordFile);
			BufferedWriter usernameWriter = new BufferedWriter(usernameFile);
			
			//overwrites both files
			passwordWriter.write(cPassword);
			usernameWriter.write(cUsername);

			passwordWriter.close();
			usernameWriter.close();

			password = cPassword;
			username = cUsername;

		}
		catch(IOException ex) {
			System.out.println("Changes not made");
		}


	}
}
