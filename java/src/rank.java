import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class rank extends Frame implements ActionListener, WindowListener {

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
    private TextField tfInput_1;
    private TextField tfInput_2;
    private TextField tfInput_3;
    private TextField tfInput_4;
    private TextField tfInput_5;
    private TextField tfInput_6;
    private TextField tfInput_7;
    private TextField tfInput_8;
    private TextField tfInput_9;
    private TextField tfInput_10;
    private Button btnSave;

    public rank() {
        setLayout(new FlowLayout());

        lblInput_1 = new Label("Rank First Website: ");
        add(lblInput_1);

        tfInput_1 = new TextField(50);
        tfInput_1.setEditable(false);
        add(tfInput_1);

        lblInput_2 = new Label("Rank Second Website: ");
        add(lblInput_2);

        tfInput_2 = new TextField(50);
        tfInput_2.setEditable(false);
        add(tfInput_2);

        lblInput_3 = new Label("Rank  Third Website: ");
        add(lblInput_3);

        tfInput_3 = new TextField(50);
        tfInput_3.setEditable(false);
        add(tfInput_3);

        lblInput_4 = new Label("Rank  Fourth  Website: ");
        add(lblInput_4);

        tfInput_4 = new TextField(50);
        tfInput_4.setEditable(false);
        add(tfInput_4);

        lblInput_5 = new Label("Rank  Fifth Website: ");
        add(lblInput_5);

        tfInput_5 = new TextField(50);
        tfInput_5.setEditable(false);
        add(tfInput_5);

        lblInput_6 = new Label("Rank  Sixth Website: ");
        add(lblInput_6);

        tfInput_6 = new TextField(50);
        tfInput_6.setEditable(false);
        add(tfInput_6);

        lblInput_7 = new Label("Rank  Seventh Website: ");
        add(lblInput_7);

        tfInput_7 = new TextField(50);
        tfInput_7.setEditable(false);
        add(tfInput_7);

        lblInput_8 = new Label("Rank  eighth Website: ");
        add(lblInput_8);

        tfInput_8 = new TextField(50);
        tfInput_8.setEditable(false);
        add(tfInput_8);

        lblInput_9 = new Label("Rank  Ninth Website: ");
        add(lblInput_9);

        tfInput_9 = new TextField(50);
        tfInput_9.setEditable(false);
        add(tfInput_9);

        lblInput_10 = new Label("Rank  Tenth Website: ");
        add(lblInput_10);

        tfInput_10 = new TextField(50);
        tfInput_10.setEditable(false);
        add(tfInput_10);

        btnSave = new Button("Get Ranking");
        add(btnSave);

        btnSave.addActionListener(this);

        addWindowListener(this);

        setTitle("Rankings");
        setSize(500, 640);
        setLayout(new GridLayout(30, 1));
        setVisible(true);
    }

   /* public static void main(String[] args) {

        new rank();
    }*/

    @Override
    public void actionPerformed(ActionEvent evt) {
        JSONParser parser = new JSONParser();
        int[] rank = new int[10];
        try {

            Object obj = parser.parse(new FileReader("I:\\src\\java\\search_eng\\freq.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("value");

            int[] result = new int[10];
            int[] result1 = new int[10];
            int k = 0;
            int temp = 0;

            for (int i = 0; i < 10; i++) {
                result[i] = ((Long) array.get(i)).intValue();
            }
            for (int i = 0; i < 10; i++) {
                result1[i] = result[i];
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 1; j < (10 - i); j++) {
                    if (result1[j - 1] < result1[j]) {
                        temp = result1[j - 1];
                        result1[j - 1] = result1[j];
                        result1[j] = temp;
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (result1[i] == result[j]) {
                        rank[k] = j;
                        k++;
                        break;
                    }
                }
            }


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONParser parser1 = new JSONParser();
        try {

            Object obj1 = parser1.parse(new FileReader("I:\\src\\java\\search_eng\\test.json"));
            JSONObject jsonObject1 = (JSONObject) obj1;
            JSONArray array1 = (JSONArray) jsonObject1.get("Links");

                tfInput_1.setText(array1.get(rank[0]).toString());
                tfInput_2.setText(array1.get(rank[1]).toString());
                tfInput_3.setText(array1.get(rank[2]).toString());
                tfInput_4.setText(array1.get(rank[3]).toString());
                tfInput_5.setText(array1.get(rank[4]).toString());
                tfInput_6.setText(array1.get(rank[5]).toString());
                tfInput_7.setText(array1.get(rank[6]).toString());
                tfInput_8.setText(array1.get(rank[7]).toString());
                tfInput_9.setText(array1.get(rank[8]).toString());
                tfInput_10.setText(array1.get(rank[9]).toString());
        }

         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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