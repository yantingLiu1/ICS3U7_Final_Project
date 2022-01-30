import java.io.*;

/**
 * Creates a password as well as change it
 *
 * @author Ada
 */

public class SetPassword {

    //declare variables
    String passwordFileName = "passwordName.txt";
    String usernameFileName = "usernameName.txt";
    String password;
    String username;
    String[] passwordUsername = new String[2];

    /**
     * Constructor for creating a password
     */
    public SetPassword(String p, String u) {
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

        } catch (IOException ex) {
            System.out.println("File unmade");
        }
    }

}

/**
 * changes the password
 *
 * @param cUsername Changed username
 * @param cPassword Changed password
 */
class changePassword {
	
	//declare variables
    String passwordFileName = "passwordName.txt";
    String usernameFileName = "usernameName.txt";
    String password;
    String username;
    String[] passwordUsername = new String[2];

    /**
     * Changes the password
     * @param cUsername Changed username
     * @param cPassword Changed password
     */
    public changePassword(String cUsername, String cPassword) {
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

        } catch (IOException ex) {
            System.out.println("Changes not made");
        }
    }
}