import java.io.*;
import java.util.*;

import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args)
	{		 
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setSize(800, 600);
		loginFrame.setTitle("Login");
		loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);
		
	}

}
