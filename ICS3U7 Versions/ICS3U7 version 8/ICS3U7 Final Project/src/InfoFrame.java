import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
/*
 * @author Roshan
 * */


class InfoFrame extends JFrame implements ActionListener {
    String path = "storedInformation\\AllHealthNumbers.txt";
    JButton view = new JButton("View");
    JButton addEntry = new JButton("Add entry");
    JButton delete = new JButton("Delete");
    JButton edit = new JButton("Edit");
    JButton changeup = new JButton("Alter PIN");
    JList<String> jlist;
    JScrollPane pane;
    String[] list = new String[0];
    DefaultListModel model = new DefaultListModel();
    String pathForFile = "storedInformation\\";

    InfoFrame() {
        readList();

        setLayout(null);
        for (String item : list) {
            model.addElement(item);
        }
        jlist = new JList<>(model);
        JScrollPane pane = new JScrollPane(jlist);
        pane.setBounds(50, 50, 700, 500);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        addEntry.setBounds(200, 600, 100, 30);
        addEntry.addActionListener(this);
        view.setBounds(50, 600, 100, 30);
        view.addActionListener(this);
        delete.setBounds(500, 600, 100, 30);
        delete.addActionListener(this);
        edit.setBounds(350,600,100,30);
        edit.addActionListener(this);
        changeup.setBounds(650, 600, 100, 30);
        changeup.addActionListener(this);

        add(view);
        add(addEntry);
        add(delete);
        add(edit);
        add(changeup);
        add(pane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = jlist.getSelectedValue();
        if (e.getSource() == view) {
            if (jlist.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(this, "no selection made");
            } else {

                viewf vFrame = new viewf(s);
                vFrame.setSize(900, 650);
                vFrame.setResizable(false);
                vFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                vFrame.setTitle("View");
                vFrame.setVisible(true);
            }
        }
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
        } else if (e.getSource() == delete) {
            if (jlist.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(this, "no selection made");
            } else {
                int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + s + "?");
                // 0=yes, 1=no, 2=cancel
                if (input == 0) {
                    String deleteDir = pathForFile + s;
                    purgeDirectory(new File(deleteDir), s);
                    /*
                     * So I added it here, but it's not working.
                     */
                    readList();
                    model.clear();
                    for (String item : list) {
                        model.addElement(item);
                    }

                }
            }
        }
        
        else if(e.getSource() == changeup) {
        	
        }
    }

    private void readList() {
        list = null;
        list = new String[0];
        try {
            BufferedReader healthNumReader = new BufferedReader(new FileReader(path));
            String line;
            ArrayList<String> al = new ArrayList<>();

            while ((line = healthNumReader.readLine()) != null) {
                al.add(line);
            }

            list = al.toArray(new String[0]);

//			for (String element : list) {
//				System.out.println(element);
//			}
            healthNumReader.close();


        } catch (IOException e) {
            System.out.println("Issues reading file");
        }
    }

    void purgeDirectory(File dir, String selectedValue) {

        File Name = new File(dir + "\\name.txt");
        File Contact = new File(dir + "\\contact.txt");
        File Address = new File(dir + "\\address.txt");
        File City = new File(dir + "\\city.txt");
        File Province = new File(dir + "\\province.txt");
        File PostalCode = new File(dir + "\\postalCode.txt");
        File HealthNum = new File(dir + "\\healthNumber.txt");
        File Notes = new File(dir + "\\note.txt");

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
            File allhealthnumbersdelete = new File(path);
            BufferedReader healthNumReader = new BufferedReader(new FileReader(path));

            while ((line = healthNumReader.readLine()) != null) {
                listOfHealthNumbers.add(line);

                //line = healthNumReader.readLine();
            }

            for (int i = 0; i < listOfHealthNumbers.size(); i++) {
                if (listOfHealthNumbers.get(i).equals(selectedValue)) {
                    listOfHealthNumbers.remove(i);
                }
            }

            healthNumReader.close();

            allhealthnumbersdelete.delete();

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