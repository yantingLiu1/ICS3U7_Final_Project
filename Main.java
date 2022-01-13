import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//define program

public class Main {

	public static void main(String[] args) {

		LoginFrame frame = new LoginFrame();
		frame.setSize(800,600);
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
class LoginFrame extends JFrame implements ActionListener {
	
	JButton login = new JButton("Login");
	JButton reset = new JButton("Reset");
	JCheckBox showpassword = new JCheckBox("Show Password");
	JTextField usertextfield = new JTextField(""); 
	JPasswordField passwordtextfield = new JPasswordField("");

	public LoginFrame(){
		setLayout(null);
		add(new CustomLabel("Username: ",50,150,100,30));
		add(new CustomLabel("Password: ",50,220,100,30));

		//receive input from text field
		usertextfield.setBounds(150,150,150,30);

		passwordtextfield.setBounds(150,220,150,30);

		showpassword.setBounds(150,250,150,30);

		login.setBounds(50,300,100,30);

		reset.setBounds(200,300,100,30);


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

		char[] pwdtxtArr = new char[4];

		pwdtxtArr = passwordtextfield.getPassword();
		
		String usertxt = "";
		String pwdtxt = "";

		for(int i = 0; i < pwdtxtArr.length; i++) {
			pwdtxt += pwdtxtArr[i];
		}

		if(e.getSource() == login){          

			System.out.println("Help");
			
			usertxt = usertextfield.getText();
			

			if(usertxt.equals("a") && pwdtxt.equals("a")){
				JOptionPane.showMessageDialog(this,"Login Successful");
			}
			else{
				JOptionPane.showMessageDialog(this,"Invalid username or password");

			}
		}

		        if(e.getSource() == reset){
		            usertextfield.setText("");
		            passwordtextfield.setText("");
		        }
		        if(e.getSource() == showpassword){
		            if(showpassword.isSelected()){
		                passwordtextfield.setEchoChar((char) 0);
		            }
		            else{
		                passwordtextfield.setEchoChar('*');
		            }
		
		        }
	}
}
class CustomButton extends JButton {
	CustomButton(String name, int x, int y, int w, int h){
		super(name);
		setBounds(x,y,w,h);
	}
}
class CustomTextField extends JTextField {
	CustomTextField(String text, int x, int y, int w, int h) {
		super(text);
		setBounds(x, y, w, h);
	}
}
class CustomPasswordField extends JTextField{
	CustomPasswordField(String text, int x, int y, int w, int h){
		super(text);
		setBounds(x, y, w, h);
	}
}
class CustomLabel extends JLabel{
	CustomLabel(String name,int x, int y, int w, int h){
		super(name);
		setBounds(x, y, w, h);
	}
}
class CustomCheckBox extends JCheckBox{
	CustomCheckBox(String name, int x, int y, int w, int h){
		super(name);
		setBounds(x, y, w, h);
	}
} 

