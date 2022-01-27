import java.io.*;

public class SetPassword {
	String path = "storedInformation\\";
	String passwordFileName = "passwordName.txt";
	String usernameFileName = "usernameName.txt";
	String password = "1234";
	String username = "1234";
	String[] passwordUsername = new String[2];

	public SetPassword(){
		try {
			FileWriter passwordFile = new FileWriter(passwordFileName);
			FileWriter usernameFile = new FileWriter(usernameFileName);
			BufferedWriter passwordWriter = new BufferedWriter(passwordFile);
			BufferedWriter usernameWriter = new BufferedWriter(usernameFile);
			
			passwordWriter.write(password);
			usernameWriter.write(username);
			
			passwordWriter.close();
			usernameWriter.close();
			
		}
		catch(IOException ex) {
			System.out.println("File unmade");
		}
	}
	
	public String[] getPassword() {
		try {
		FileReader passwordFileRead = new FileReader(passwordFileName);
		FileReader usernameFileRead = new FileReader(usernameFileName);
		BufferedReader passwordReader = new BufferedReader(passwordFileRead);
		BufferedReader usernameReader = new BufferedReader(usernameFileRead);
		
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
	
	public void changePassword(String cUsername, String cPassword) {
		try {
		FileWriter passwordFile = new FileWriter(passwordFileName, false);
		FileWriter usernameFile = new FileWriter(usernameFileName, false);
		BufferedWriter passwordWriter = new BufferedWriter(passwordFile);
		BufferedWriter usernameWriter = new BufferedWriter(usernameFile);
		
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
