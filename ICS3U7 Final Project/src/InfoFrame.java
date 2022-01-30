import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Creates the GUI for the user to choose certain actions from 
 * @author Roshan
 *
 */

class InfoFrame extends JFrame implements ActionListener {
	
	//declare variables
    String path = "storedInformation\\AllHealthNumbers.txt";
    JButton view = new JButton("View");
    JButton addEntry = new JButton("Add entry");
    JButton delete = new JButton("Delete");
    JButton edit = new JButton("Edit");
    JList<String> jlist;
    JScrollPane pane;
    String[] list = new String[0];
    DefaultListModel model = new DefaultListModel();
    String pathForFile = "storedInformation\\";

    /**
     * Creates an info GUI
     */
    InfoFrame() {
        readList();
        
        //finds out the health numbers and lists them
        setLayout(null);
        for (String item : list) {
            model.addElement(item);
        }
        jlist = new JList<>(model);
        JScrollPane pane = new JScrollPane(jlist);
        pane.setBounds(50, 50, 700, 500);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //set bounds and action listeners to different buttons        
        addEntry.setBounds(200, 600, 100, 30);
        addEntry.addActionListener(this);
        view.setBounds(50, 600, 100, 30);
        view.addActionListener(this);
        delete.setBounds(500, 600, 100, 30);
        delete.addActionListener(this);
        edit.setBounds(350,600,100,30);
        edit.addActionListener(this);

        add(view);
        add(addEntry);
        add(delete);
        add(edit);
        add(pane);
    }

    @Override
    /**
     * Checks for the action performed
     */
    public void actionPerformed(ActionEvent e) {
        String s = jlist.getSelectedValue();
        
        //if selected view, views the health number chosen by creating a view frame
        if (e.getSource() == view) {
            if (jlist.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(this, "no selection made");
            } else {

                ViewFrame vFrame = new ViewFrame(s);
                vFrame.setSize(900, 650);
                vFrame.setResizable(false);
                vFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                vFrame.setTitle("View");
                vFrame.setVisible(true);
            }
        }
        //if selected edit, edits the health number folder chosen by creating an edit frame
        else if (e.getSource() == edit) {
            if (jlist.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(this, "no selection made");
            } else {

                EditFrame eFrame = new EditFrame(s);
                eFrame.setSize(900, 650);
                eFrame.setResizable(false);
                eFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                eFrame.setTitle("Edit");
                eFrame.setVisible(true);
            }
        }
        //if selected addEntry, adds a health number and health number folder to the file system by creating 
        //register frame
        else if (e.getSource() == addEntry) {
            RegFrame rframe = new RegFrame();
            rframe.setSize(900, 650);
            rframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            rframe.setResizable(false);
            rframe.setTitle("Registration");
            rframe.setVisible(true);
            rframe.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    /*
                     * It's updated here
                     */
                    readList();
                    model.clear();
                    for (String item : list) {
                        model.addElement(item);
                    }
                }
            });
            
        //if selected delete, deletes the health number and the health number file from the file system
        } else if (e.getSource() == delete) {
            if (jlist.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(this, "no selection made");
            } else {
                int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + s + "?");
                // 0=yes, 1=no, 2=cancel
                if (input == 0) {
                    String deleteDir = pathForFile + s;
                    purgeDirectory(new File(deleteDir), s);
                    readList();
                    model.clear();
                    for (String item : list) {
                        model.addElement(item);
                    }

                }
            }
        }
    }

    /**
     * Reads the health number list 
     */
    private void readList() {
    	
    	//declare variables
    	
        list = null;
        list = new String[0];
        try {
        	
        	//reads the health number list and adds it to an Arraylist
            BufferedReader healthNumReader = new BufferedReader(new FileReader(path));
            String line;
            ArrayList<String> al = new ArrayList<>();

            while ((line = healthNumReader.readLine()) != null) {
                al.add(line);
            }
            
            //adds revised list to the list
            list = al.toArray(new String[0]);

            healthNumReader.close();


        } catch (IOException e) {
            System.out.println("Issues reading file");
        }
    }
    
    /**
     * Deletes the files in a specific health number folder
     * @param dir File directory of the files to be deleted
     * @param selectedValue Value that needs to be deleted from health number list
     */
    void purgeDirectory(File dir, String selectedValue) {
    	
    	//declare all files
        File Name = new File(dir + "\\name.txt");
        File Contact = new File(dir + "\\contact.txt");
        File Address = new File(dir + "\\address.txt");
        File City = new File(dir + "\\city.txt");
        File Province = new File(dir + "\\province.txt");
        File PostalCode = new File(dir + "\\postalCode.txt");
        File HealthNum = new File(dir + "\\healthNumber.txt");
        File Notes = new File(dir + "\\note.txt");
        
        //deltes them
        Name.delete();
        Contact.delete();
        Address.delete();
        City.delete();
        Province.delete();
        PostalCode.delete();
        HealthNum.delete();
        Notes.delete();

        dir.delete();

        ArrayList<String> listOfHealthNumbers = new ArrayList<String>();
        String line;

        try {
        	//reads in the health number list, deletes the extra health number 
            File allhealthnumbersdelete = new File(path);
            BufferedReader healthNumReader = new BufferedReader(new FileReader(path));

            while ((line = healthNumReader.readLine()) != null) {
                listOfHealthNumbers.add(line);

            }

            for (int i = 0; i < listOfHealthNumbers.size(); i++) {
                if (listOfHealthNumbers.get(i).equals(selectedValue)) {
                    listOfHealthNumbers.remove(i);
                }
            }

            healthNumReader.close();

            allhealthnumbersdelete.delete();
            
            //rewrites the health number list
            FileWriter allHealthNumbers = new FileWriter("storedInformation\\AllHealthNumbers.txt");
            BufferedWriter allHealthNumbersWriter = new BufferedWriter(allHealthNumbers);

            for (int i = 0; i < listOfHealthNumbers.size(); i++) {
                allHealthNumbersWriter.write(listOfHealthNumbers.get(i));
                allHealthNumbersWriter.newLine();
            }
            allHealthNumbersWriter.close();

        } catch (IOException ex) {
            System.out.println("File not read");
        }


    }
}