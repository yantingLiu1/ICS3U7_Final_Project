import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Creates and helps implement the entire program by initiating the login which starts the info frame
 *
 * @author Roshan
 */
public class LoginFrame extends JFrame implements ActionListener {

    //declare variables

    String[] patientInfoValue = new String[9];
    JButton login = new JButton("Login");
    JButton reset = new JButton("Reset");
    JButton register = new JButton("Register");
    JButton change = new JButton("Change");
    JCheckBox showpassword = new JCheckBox("Show Password");
    JTextField usertextfield = new JTextField("");
    JPasswordField passwordtextfield = new JPasswordField("");

    /**
     * Creates loginFrame
     */
    public LoginFrame() {
        //declare layout and add labels: username and password
        setLayout(null);
        add(new CustomLabel("Username: ", 50, 150, 100, 30));
        add(new CustomLabel("Password: ", 50, 220, 100, 30));

        //receive input from text field
        usertextfield.setBounds(150, 150, 150, 30);

        passwordtextfield.setBounds(150, 220, 150, 30);

        showpassword.setBounds(150, 250, 150, 30);

        login.setBounds(50, 300, 100, 30);

        reset.setBounds(200, 300, 100, 30);

        register.setBounds(350, 300, 100, 30);

        change.setBounds(500, 300, 100, 30);


        //adds the fields to the frames
        add(usertextfield);
        add(passwordtextfield);
        add(login);
        add(reset);
        add(showpassword);
        add(register);
        add(change);

        login.addActionListener(this);
        reset.addActionListener(this);
        showpassword.addActionListener(this);
        register.addActionListener(this);
        change.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String path = "storedInformation\\";
        String passwordFileName = "passwordName.txt";
        String usernameFileName = "usernameName.txt";
        String[] passwordUsername = new String[2];

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

        } catch (IOException ex) {
            System.out.println("File unread");
        }


        //turns password in a char for the password field and gets the username
        char[] pwdtxtArr = new char[4];

        pwdtxtArr = passwordtextfield.getPassword();

        String usertxt = "";
        String pwdtxt = "";

        for (int i = 0; i < pwdtxtArr.length; i++) {
            pwdtxt += pwdtxtArr[i];
        }

        //Logs in if the password and username match, creating a register frame
        if (e.getSource() == login) {

            usertxt = usertextfield.getText();


            if (usertxt.equals(passwordUsername[0]) && pwdtxt.equals(passwordUsername[1])) {

                System.out.println("The password and username is correct.");

                this.setVisible(false);

                InfoFrame rFrame = new InfoFrame();
                rFrame.setSize(800, 700);
                rFrame.setTitle("infoLookup");
                rFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                rFrame.setResizable(false);
                rFrame.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");

            }
        }

        //removes all characters from username and password to empty
        if (e.getSource() == reset) {
            usertextfield.setText("");
            passwordtextfield.setText("");
        }

        //shows the password
        if (e.getSource() == showpassword) {
            if (showpassword.isSelected()) {
                passwordtextfield.setEchoChar((char) 0);
            } else {
                passwordtextfield.setEchoChar('*');
            }

        }
        if (e.getSource() == register) {
            LoginReg lreg = new LoginReg();
            lreg.setTitle("Login Register");
            lreg.setSize(800, 600);
            lreg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            lreg.setResizable(false);
            lreg.setVisible(true);
        }
        if (e.getSource() == change) {
            LoginChange lchang = new LoginChange();
            lchang.setTitle("Change");
            lchang.setSize(800, 600);
            lchang.setDefaultCloseOperation(EXIT_ON_CLOSE);
            lchang.setResizable(false);
            lchang.setVisible(true);
        }

    }

    /**
     * Gets the values of the patient info
     *
     * @return string array of patient info
     */
    public String[] getValues() {
        return patientInfoValue;
    }

}

/**
 * Creates a CustomButton
 *
 * @author Roshan
 */
class CustomButton extends JButton {
    CustomButton(String name, int x, int y, int w, int h) {
        super(name);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomTextField
 *
 * @author Roshan
 */
class CustomTextField extends JTextField {
    CustomTextField(String text, int x, int y, int w, int h) {
        super(text);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomPasswordField
 *
 * @author Roshan
 */
class CustomPasswordField extends JTextField {
    CustomPasswordField(String text, int x, int y, int w, int h) {
        super(text);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomLabel
 *
 * @author Roshan
 */
class CustomLabel extends JLabel {
    CustomLabel(String name, int x, int y, int w, int h) {
        super(name);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomCheckBox
 *
 * @author Roshan
 */
class CustomCheckBox extends JCheckBox {
    CustomCheckBox(String name, int x, int y, int w, int h) {
        super(name);
        setBounds(x, y, w, h);
    }
}


