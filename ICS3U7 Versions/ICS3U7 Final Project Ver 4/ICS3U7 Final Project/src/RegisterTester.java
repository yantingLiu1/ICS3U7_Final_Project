import javax.swing.WindowConstants;

public class RegisterTester {
	public static void main(String[] args) {
		RegFrame rFrame = new RegFrame();
	    rFrame.setSize(900, 700);
	    rFrame.setTitle("infoLookup");
	    rFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		rFrame.setResizable(false);
	    rFrame.setVisible(true);
	}
}