import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
/*
* @author Roshan
* */

public class InfoLookup {
    public static void main(String[]args){
        infoFrame frame = new infoFrame();
        frame.setSize(800,700);
        frame.setTitle("Info Lookup");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
class infoFrame extends JFrame implements ActionListener {
    JButton view = new JButton("View");
    JButton addEntry = new JButton("Add entry");
    JButton delete = new JButton("Delete");
    JList<String> jlist;
    JScrollPane pane;
    infoFrame(){
        String list[] = new String[0];
        try{
            BufferedReader read = new BufferedReader(new FileReader("list.txt"));
            String line;
            ArrayList<String> al = new ArrayList<>();
            while((line = read.readLine())!=null){
                al.add(line);
            }
            read.close();
            list = al.toArray(new String[0]);
            /*
            for(String element : list){
                System.out.println(element);
            }
            */
            //for testing purposes



        } catch (IOException e) {
            System.out.println("Issues reading file");
        }
        setLayout(null);
        jlist = new JList<>(list);
        JScrollPane pane = new JScrollPane(jlist);
        pane.setBounds(50,50,700,500);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        addEntry.setBounds(200,600,100,30);
        addEntry.addActionListener(this);
        view.setBounds(50,600,100,30);
        view.addActionListener(this);
        delete.setBounds(500,600,100,30);
        delete.addActionListener(this);

        add(view);
        add(addEntry);
        add(delete);
        add(pane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view){
            String s = jlist.getSelectedValue();
            if(jlist.getSelectedValue()==null){
                JOptionPane.showMessageDialog(this,"no");
            }
            else {
                JOptionPane.showMessageDialog(this, s);
            }
        }
        else if(e.getSource() == addEntry){
            RegFrame rframe = new RegFrame();
            rframe.setSize(900,650);
            rframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
            rframe.setResizable(false);
            rframe.setTitle("Registration");
            rframe.setVisible(true);
        }
        else if(e.getSource() == delete){
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
            // 0=yes, 1=no, 2=cancel

        }
    }
}
