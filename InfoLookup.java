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
    JButton select = new JButton("Select");
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
        JList<String> jlist = new JList<>(list);
        //JScrollPane pane = new JScrollPane(jlist);
        jlist.setBounds(50,50,700,500);
        //pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        select.setBounds(50,600,30,100);
        select.addActionListener(this);

        add(select);
        add(jlist);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == select){
            String s = jlist.getSelectedValue();
            JOptionPane.showConfirmDialog(this,s,"Display",JOptionPane.PLAIN_MESSAGE );
        }
    }
}
