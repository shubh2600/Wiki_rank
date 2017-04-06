import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class fetchWebsite extends Frame implements ActionListener, WindowListener {

    private Label lblInput_1;
    private Label lblInput_2;
    private Label lblInput_3;
    private Label lblInput_4;
    private Label lblInput_5;
    private Label lblInput_6;
    private Label lblInput_7;
    private Label lblInput_8;
    private Label lblInput_9;
    private Label lblInput_10;
    private Label lblInput_11;
    private TextField tfInput_1;
    private TextField tfInput_2;
    private TextField tfInput_3;
    private TextField tfInput_4;
    private TextField tfInput_5;
    private TextField tfInput_6;
    private TextField tfInput_7;
    private TextField tfInput_8;
    private TextField tfInput_9;
    private TextField tfInput_11;
    private TextField tfInput_10;
    private Button btnSave;

    public fetchWebsite () {
        setLayout(new FlowLayout());

        lblInput_1 = new Label("Enter  First Website: ");
        add(lblInput_1);

        tfInput_1 = new TextField(50);
        add(tfInput_1);

        lblInput_2 = new Label("Enter  Second Website: ");
        add(lblInput_2);

        tfInput_2 = new TextField(50);
        add(tfInput_2);

        lblInput_3 = new Label("Enter  Third Website: ");
        add(lblInput_3);

        tfInput_3 = new TextField(50);
        add(tfInput_3);

        lblInput_4 = new Label("Enter  Fourth  Website: ");
        add(lblInput_4);

        tfInput_4 = new TextField(50);
        add(tfInput_4);

        lblInput_5 = new Label("Enter  Fifth Website: ");
        add(lblInput_5);

        tfInput_5 = new TextField(50);
        add(tfInput_5);

        lblInput_6 = new Label("Enter  Sixth Website: ");
        add(lblInput_6);

        tfInput_6 = new TextField(50);
        add(tfInput_6);

        lblInput_7 = new Label("Enter  Seventh Website: ");
        add(lblInput_7);

        tfInput_7 = new TextField(50);
        add(tfInput_7);

        lblInput_8 = new Label("Enter  eighth Website: ");
        add(lblInput_8);

        tfInput_8 = new TextField(50);
        add(tfInput_8);

        lblInput_9 = new Label("Enter  Ninth Website: ");
        add(lblInput_9);

        tfInput_9 = new TextField(50);
        add(tfInput_9);

        lblInput_10 = new Label("Enter  Tenth Website: ");
        add(lblInput_10);

        tfInput_10 = new TextField(50);
        add(tfInput_10);

        lblInput_11 = new Label("Enter  Keyword for Search: ");
        add(lblInput_11);

        tfInput_11 = new TextField(50);
        add(tfInput_11);

        btnSave = new Button("Save");
        add(btnSave);

        btnSave.addActionListener(this);
        addWindowListener(this);

        setTitle("Store website Link");
        setSize(500, 640);
        setLayout(new GridLayout(30, 1));
        setVisible(true);
    }

   /* public static void main(String[] args) {


    }
*/

    @Override
    public void actionPerformed(ActionEvent evt) {
        String j1 = tfInput_1.getText();
        tfInput_1.setText("");

        String j2 = tfInput_2.getText();
        tfInput_2.setText("");

        String j3 = tfInput_3.getText();
        tfInput_3.setText("");

        String j4 = tfInput_4.getText();
        tfInput_4.setText("");

        String j5 = tfInput_5.getText();
        tfInput_5.setText("");

        String j6 = tfInput_6.getText();
        tfInput_6.setText("");

        String j7 = tfInput_7.getText();
        tfInput_7.setText("");

        String j8 = tfInput_8.getText();
        tfInput_8.setText("");

        String j9 = tfInput_9.getText();
        tfInput_9.setText("");

        String j10 = tfInput_10.getText();
        tfInput_10.setText("");

        String j11 = tfInput_11.getText();
        tfInput_11.setText("");

        JSONObject obj = new JSONObject();
        JSONArray list = new JSONArray();

        list.add(j1);
        list.add(j2);
        list.add(j3);
        list.add(j4);
        list.add(j5);
        list.add(j6);
        list.add(j7);
        list.add(j8);
        list.add(j9);
        list.add(j10);


        obj.put("Keyword",j11);
        obj.put("Links", list);

        try (FileWriter file = new FileWriter("I:\\src\\java\\search_eng\\test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
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