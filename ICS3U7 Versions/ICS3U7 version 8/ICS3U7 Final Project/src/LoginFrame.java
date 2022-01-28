import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Creates and helps implement the entire program by initiating the login which starts the info frame
 * @author Roshan (GUI), Ada (action listener)
 *
 */
public class LoginFrame extends JFrame implements ActionListener {
	
	//declare variables
	
    String[] patientInfoValue = new String[9];
    JButton login = new JButton("Login");
    JButton reset = new JButton("Reset");
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


        //adds the fields to the frames
        add(usertextfield);
        add(passwordtextfield);
        add(login);
        add(reset);
        add(showpassword);

        login.addActionListener(this);
        reset.addActionListener(this);
        showpassword.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
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

            if (usertxt.equals("a") && pwdtxt.equals("a")) {

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

    }

    /**
     * Gets the values of the patient info
     * @return string array of patient info
     */
    public String[] getValues() {
        return patientInfoValue;
    }

}

/**
 * Creates a CustomButton
 * @author Roshan
 *
 */
class CustomButton extends JButton {
    CustomButton(String name, int x, int y, int w, int h) {
        super(name);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomTextField
 * @author Roshan
 *
 */
class CustomTextField extends JTextField {
    CustomTextField(String text, int x, int y, int w, int h) {
        super(text);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomPasswordField
 * @author Roshan
 *
 */
class CustomPasswordField extends JTextField {
    CustomPasswordField(String text, int x, int y, int w, int h) {
        super(text);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomLabel
 * @author Roshan
 *
 */
class CustomLabel extends JLabel {
    CustomLabel(String name, int x, int y, int w, int h) {
        super(name);
        setBounds(x, y, w, h);
    }
}

/**
 * Creates a CustomCheckBox
 * @author Roshan
 *
 */
class CustomCheckBox extends JCheckBox {
    CustomCheckBox(String name, int x, int y, int w, int h) {
        super(name);
        setBounds(x, y, w, h);
    }
}