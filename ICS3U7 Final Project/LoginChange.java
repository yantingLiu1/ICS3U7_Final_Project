import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static java.awt.event.WindowEvent.*;

/**
 * Creates a GUI that to changes the login
 * @author Roshan
 *
 */
public class LoginChange extends JFrame implements ActionListener {
	
	//declare variables
    JTextField username = new JTextField("");
    JPasswordField password = new JPasswordField("");
    JPasswordField newpassword = new JPasswordField("");

    JButton cancel = new JButton("Reset");
    JButton confirm = new JButton("Confirm");
    
    /**
     * Creates the GUI
     */
    LoginChange() {
        setLayout(null);
        
        //sets textfield and button bounds and adds them to GUI
        username.setBounds(200, 80, 150, 30);

        password.setBounds(200, 150, 150, 30);

        newpassword.setBounds(200, 220, 150, 30);

        confirm.setBounds(50, 300, 100, 30);

        cancel.setBounds(200, 300, 100, 30);

        add(new CustomLabel("Username: ", 50, 80, 100, 30));
        add(new CustomLabel("Password: ", 50, 150, 100, 30));
        add(new CustomLabel("Confirm Password: ", 50, 220, 150, 30));

        add(username);
        add(password);
        add(newpassword);
        add(cancel);
        add(confirm);

        confirm.addActionListener(this);
        cancel.addActionListener(this);

    }

    @Override
    /**
     * Checks for action
     */
    public void actionPerformed(ActionEvent e) {
    	
    	//declare variables
        char[] pwdtxtArr = new char[0];
        char[] pwdctxtArr = new char[0];

        pwdtxtArr = password.getPassword();
        pwdctxtArr = newpassword.getPassword();

        String pwd = "";
        String pwdc = "";

        //turns password into a string
        for (int i = 0; i < pwdtxtArr.length; i++) {
            pwd += pwdtxtArr[i];
        }
        for (int i = 0; i < pwdctxtArr.length; i++) {
            pwdc += pwdctxtArr[i];
        }
        //if cancal, close the window
        if (e.getSource() == cancel) {
            dispatchEvent(new WindowEvent(this, WINDOW_CLOSING));
        }
        //if confirm, then check if password and username are valid before closing
        if (e.getSource() == confirm) {
            if (username.getText().equals("") == false || pwd.equals("") == false || pwdc.equals("") == false) {
                if (pwd.equals(pwdc)) {
                    String p = pwdc;
                    String u = username.getText();
                    new changePassword(u, p);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Passwords do not match");
                }
            } else {
                JOptionPane.showMessageDialog(this, "All fields must be filled in");
            }
        }
    }
}
