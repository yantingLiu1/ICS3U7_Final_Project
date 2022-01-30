import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Creates a GUI for the login registration 
 * @author Roshan
 *
 */

public class LoginReg extends JFrame implements ActionListener {
	
	//declare variables
    JTextField username = new JTextField("");
    JPasswordField password = new JPasswordField("");
    JPasswordField passwordconfirm = new JPasswordField("");

    JButton reset = new JButton("Reset");
    JButton confirm = new JButton("Confirm");

    /**
     * Creates a login GUI
     */
    LoginReg() {
        setLayout(null);
        
        //sets bounds for username and password and button fields and adds them to frame
        username.setBounds(200, 80, 150, 30);

        password.setBounds(200, 150, 150, 30);

        passwordconfirm.setBounds(200, 220, 150, 30);

        confirm.setBounds(50, 300, 100, 30);

        reset.setBounds(200, 300, 100, 30);
        add(new CustomLabel("Username: ", 50, 80, 100, 30));
        add(new CustomLabel("Password: ", 50, 150, 100, 30));
        add(new CustomLabel("Confirm Password: ", 50, 220, 150, 30));

        add(username);
        add(password);
        add(passwordconfirm);
        add(reset);
        add(confirm);

        confirm.addActionListener(this);
        reset.addActionListener(this);
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
        pwdctxtArr = passwordconfirm.getPassword();

        String pwd = "";
        String pwdc = "";

        //turns password into a string
        for (int i = 0; i < pwdtxtArr.length; i++) {
            pwd += pwdtxtArr[i];
        }
        for (int i = 0; i < pwdctxtArr.length; i++) {
            pwdc += pwdctxtArr[i];
        }

        //if reset, turns textfields to empty string
        if (e.getSource() == reset) {
            username.setText("");
            passwordconfirm.setText("");
            password.setText("");
        }
        //if confirm, changes the password and closes window
        if (e.getSource() == confirm) {
            if (!username.getText().equals("") || pwd.equals("") || pwdc.equals("")) {
                if (pwdc.equals(pwd)) {
                    String u = username.getText();
                    String p = pwdc;
                    new SetPassword(u, p);
                    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                } else {
                    JOptionPane.showMessageDialog(this, "Passwords do not match");
                }
            } else {
                JOptionPane.showMessageDialog(this, "All fields must be filled in");
            }
        }
    }
}
