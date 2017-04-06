import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.*;
import java.lang.String;

public class py extends Frame implements ActionListener, WindowListener {


    private Button btnSave;

    public py() {
        setLayout(new FlowLayout());



        btnSave = new Button("Start Python");
        add(btnSave);

        btnSave.addActionListener(this);

        addWindowListener(this);

        setTitle("Python Button");
        setSize(500, 640);
        setLayout(new GridLayout(30, 1));
        setVisible(true);
    }

    public static void main(String[] args) {

        new py();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            // Execute command

            String command = "cmd /c cd Search_eng" +" & start cmd.exe /c python rank.py";
            Runtime.getRuntime().exec(command);


            // Get output stream to write from it




        } catch (IOException e) {
        }





    }

    @Override
    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }
    @Override public void windowOpened(WindowEvent evt) { }
    @Override public void windowClosed(WindowEvent evt) { }
    @Override public void windowIconified(WindowEvent evt) { }
    @Override public void windowDeiconified(WindowEvent evt) { }
    @Override public void windowActivated(WindowEvent evt) { }
    @Override public void windowDeactivated(WindowEvent evt) { }
}