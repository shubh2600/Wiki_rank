import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class pyy extends JFrame implements ActionListener {
    JButton SUBMIT;
    JPanel panel;

    pyy() {


        SUBMIT = new JButton("Launch Python Script");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(SUBMIT);
        add(panel, BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        setTitle("Python Button");

        setSize(300, 150);
        setVisible(true);


    }

/*
    public static void main(String arg[]) {
        new pyy();

    }
*/
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String command = "cmd /c cd Search_eng" + " & start cmd.exe /c python rank.py";
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
        }

    }
}