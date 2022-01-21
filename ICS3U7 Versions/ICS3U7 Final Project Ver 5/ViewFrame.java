import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFrame {
    public static void main(String[] args) {
        viewf frame = new viewf();
        frame.setSize(900, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("View");
        frame.setVisible(true);
    }
}

class viewf extends JFrame implements ActionListener {
    viewf() {
        setLayout(null);
        String firstname = "a";
        String lastname = "b";
        String phone = "c";
        String address = "d";
        String city = "e";
        String province = "f";
        String notesin = "sadsafsadasfasasdgda\nsdgasfgsdagssfaerhsfs";
        String[] notes = notesin.split("\n");

        add(new CustomLabel(firstname + " " + lastname + " - " + phone, 30, 70, 500, 30));
        add(new CustomLabel(address + ", " + city + ", " + province, 30, 90, 500, 30));
        add(new CustomLabel("notes:", 30, 130, 100, 30));
        for (int i = 0; i < notes.length; i++) {
            add(new CustomLabel(notes[i], 30, 150 + i * 15, 800, 30));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
