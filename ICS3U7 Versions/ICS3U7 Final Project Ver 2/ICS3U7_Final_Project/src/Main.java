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
class RegFrame extends JFrame implements ActionListener {
	String[] s1 = {"AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK"};
	String[] out = new String[9];
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
}

class CustomLabel extends JLabel{
	CustomLabel(String name,int x, int y, int w, int h){
		super(name);
		setBounds(x, y, w, h);
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


				if(usertxt.equals("test") && pwdtxt.equals("test")){
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
}

