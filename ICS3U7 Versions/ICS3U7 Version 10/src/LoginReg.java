import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class LoginReg extends JFrame implements ActionListener {
    JTextField username = new JTextField("");
    JPasswordField password = new JPasswordField("");
    JPasswordField passwordconfirm = new JPasswordField("");

    JButton reset = new JButton("Reset");
    JButton confirm = new JButton("Confirm");

    LoginReg() {
        setLayout(null);

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
    public void actionPerformed(ActionEvent e) {
        char[] pwdtxtArr = new char[0];
        char[] pwdctxtArr = new char[0];

        pwdtxtArr = password.getPassword();
        pwdctxtArr = passwordconfirm.getPassword();

        String pwd = "";
        String pwdc = "";


        for (int i = 0; i < pwdtxtArr.length; i++) {
            pwd += pwdtxtArr[i];
        }
        for (int i = 0; i < pwdctxtArr.length; i++) {
            pwdc += pwdctxtArr[i];
        }

        if (e.getSource() == reset) {
            username.setText("");
            passwordconfirm.setText("");
            password.setText("");
        }
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
