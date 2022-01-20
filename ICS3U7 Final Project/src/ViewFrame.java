import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFrame {
    public static void main(String[] args){
        viewf frame = new viewf();
        frame.setSize(900,650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("View");
        frame.setVisible(true);
    }
}
class viewf extends JFrame implements ActionListener{
    viewf(){
        setLayout(null);
        String firstname = "a";
        String lastname = "b";
        String phone = "c";
        String address = "d";
        String city = "e";
        String province = "f";
        String notes= "sadsafsadasfasasdgda\nsdgasfgsdagssfaerhsfs";

        add(new CustomLabel(firstname,30, 40, 150, 30));
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
