import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
/*
 * @author Roshan
 * */


class InfoFrame extends JFrame implements ActionListener {
	String path = "storedInformation\\AllHealthNumbers.txt";
	final int CAPACITY = 0;
	JButton select = new JButton("Select");
	JList<String> jlist;
	JScrollPane pane;
	InfoFrame(){
		String list[] = new String[CAPACITY];
		try{
			BufferedReader healthNumReader = new BufferedReader(new FileReader(path)); 
			String line;
			ArrayList<String> al = new ArrayList<>();

			while((line = healthNumReader.readLine()) != null) {
				al.add(line);
			}

			list = al.toArray(new String[CAPACITY]);

			for(String element : list){
				System.out.println(element);
			}



		} catch (IOException e) {
			System.out.println("Issues reading file");
		}

		setLayout(null);
		jlist = new JList<>(list);
		JScrollPane pane = new JScrollPane(jlist);
		pane.setBounds(50,50,700,500);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


		select.setBounds(50,600,100,30);
		select.addActionListener(this);

		add(select);
		add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == select){
			String s = jlist.getSelectedValue();
			if(jlist.getSelectedValue()==null){
				JOptionPane.showMessageDialog(this,"no");
			}
			else {
				JOptionPane.showMessageDialog(this, s);
				
				ViewFrame vFrame = new ViewFrame();
				
				
			}
		}
	}
}