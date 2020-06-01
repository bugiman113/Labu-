import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class Insert_key {
    public static final Font FONT = new Font("Verdana", Font.PLAIN,  17);
    public static int k;
    public static void createW2(ObjectOutputStream outToClient, ObjectInputStream inn, ResourceBundle bundleDef,int k1) {
        k=k1;
        JFrame frame2 = new JFrame("Объект");
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame2.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {// все время пока окно активно
                 try {
                JLabel label1 = null;
                label1 = new JLabel(new String(bundleDef.getString("ALL").getBytes("ISO-8859-1"),"Cp1251"));
                JPanel panel = new JPanel();
                panel.add(label1);
                JLabel label2 = new JLabel(new String(bundleDef.getString("NAME").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField name = new JTextField("",13);
                panel.add(label2);
                panel.add(name);
                JLabel label3 = new JLabel(new String(bundleDef.getString("X").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField x = new JTextField("",7);
                panel.add(label3);
                panel.add(x);
                JLabel label4 = new JLabel(new String(bundleDef.getString("Y").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField y = new JTextField("",7);
                panel.add(label4);
                panel.add(y);
                JLabel label5 = new JLabel(new String(bundleDef.getString("FL").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField fl = new JTextField("",8);
                panel.add(label5);
                panel.add(fl);
                JLabel label17 = new JLabel(new String(bundleDef.getString("BOOL").getBytes("ISO-8859-1"),"Cp1251"));
                panel.add(label17);
                JComboBox live = new JComboBox();
                live.addItem("true");
                live.addItem("false");
                JLabel label19 = new JLabel(new String(bundleDef.getString("BOOLP").getBytes("ISO-8859-1"),"Cp1251"));
                panel.add(label19);
                panel.add(live);
                JLabel label6 = new JLabel(new String(bundleDef.getString("H").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField h = new JTextField("",8);
                panel.add(label6);
                panel.add(h);
                JLabel label18 = new JLabel(new String(bundleDef.getString("AST").getBytes("ISO-8859-1"),"Cp1251"));
                panel.add(label18);
                JComboBox comboBox = new JComboBox();
                comboBox.addItem("SCOUT");
                comboBox.addItem("ASSAULT");
                comboBox.addItem("TACTICAL");
                comboBox.addItem("TERMINATOR");
                comboBox.addItem("LIBRARIAN");
                panel.add(comboBox);
                JLabel label7 = new JLabel(new String(bundleDef.getString("NAME2").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField name2 = new JTextField("",10);
                panel.add(label7);
                panel.add(name2);
                JLabel label8 = new JLabel(new String(bundleDef.getString("NAME3").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField name3 = new JTextField("",11);
                panel.add(label8);
                panel.add(name3);
                JLabel label9 = new JLabel(new String(bundleDef.getString("INT").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField r = new JTextField("",8);
                panel.add(label9);
                panel.add(r);
                JButton button = new JButton(new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251"));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==button){
                            if (!name.getText().equals("") && !x.getText().equals("") && !y.getText().equals("") && fl.getText()!=null && !h.getText().equals("") && !name2.getText().equals("") && !name3.getText().equals("") && !r.getText().equals("")){
                                int x1 = Integer.parseInt(x.getText());
                                int y1 = Integer.parseInt(y.getText());
                                int r1 = Integer.parseInt(r.getText());
                                String name22 = String.valueOf(name2.getText());
                                String name33 = String.valueOf(name3.getText());
                                String name1 = String.valueOf(name.getText());
                                Float fl1 = Float.parseFloat(fl.getText());
                                boolean bl;
                                if (live.getSelectedIndex()==0){
                                    bl = true;
                                }else bl=false;
                                Float h2 = Float.parseFloat(h.getText());
                                AstartesCategory categ=null;
                                if (comboBox.getSelectedIndex() == 0) { categ = AstartesCategory.SCOUT; }
                                if (comboBox.getSelectedIndex()  == 1) { categ = AstartesCategory.ASSAULT; }
                                if (comboBox.getSelectedIndex()  == 2) { categ = AstartesCategory.TACTICAL; }
                                if (comboBox.getSelectedIndex()  == 3) { categ = AstartesCategory.TERMINATOR; }
                                if (comboBox.getSelectedIndex()  == 4) { categ = AstartesCategory.LIBRARIAN; }
                                SpaceMarine sp = spaceMarine(name1,x1, y1, fl1, bl, h2, categ,name22, name33, r1);
                                try {
                                    long kin=1;
                                    outToClient.writeObject(kin);
                                    outToClient.writeObject(sp);
                                    outToClient.flush();
                                    Object insert = null;
                                insert = inn.readObject();
                            ComWindow.createWO(insert,550,200,15,10,30,bundleDef);
                                } catch (IOException | ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                event.getWindow().setVisible(false);
                            }
                        }
                    }
                });
                panel.add(button);
                JLabel label01 = new JLabel((new String(bundleDef.getString("PS").getBytes("ISO-8859-1"),"Cp1251")));
                panel.add(label01);
                JButton button1 =new  JButton("?");
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(button1==e.getSource()){
                            FormM fm = null;
                            try {
                                fm = new FormM(frame2,bundleDef);
                            } catch (UnsupportedEncodingException ex) {
                                ex.printStackTrace();
                            }
                            if(fm.isOK()){
                                JOptionPane.showMessageDialog(frame2, "OK");
                            }
                        }
                        }
                });
                panel.add(button1);
                frame2.add(panel);
                 } catch (UnsupportedEncodingException e) {
                     e.printStackTrace();
                 }
            }

            public void windowClosed(WindowEvent event) {
            }

            public void windowClosing(WindowEvent event) {
                Object[] options = new Object[0];
                try {
                    options = new Object[]{ new String(bundleDef.getString("YES").getBytes("ISO-8859-1"),"Cp1251"), new String(bundleDef.getString("NO").getBytes("ISO-8859-1"),"Cp1251") };

                int n = JOptionPane
                        .showOptionDialog(event.getWindow(),new String(bundleDef.getString("EXIT").getBytes("ISO-8859-1"),"Cp1251") ,
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    long kin = 0;
                    outToClient.writeObject(kin);
                    event.getWindow().setVisible(false);
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void windowDeactivated(WindowEvent event) {//когда окно свернуто
            }

            public void windowDeiconified(WindowEvent event) {//когда мы только только развернули окно
            }

            public void windowIconified(WindowEvent event) {
            }

            public void windowOpened(WindowEvent event) {//когда окно только появляется
            }
        });
        frame2.setPreferredSize(new Dimension(396, 450));
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setVisible(true);
        UIManager.put("Button.font", FONT);
        UIManager.put("Label.font", FONT);
    }
    public static SpaceMarine spaceMarine(String name1,int x1,int y1,Float fl1, boolean bl, Float h2,AstartesCategory categ,String name22,String name33,int r1){
        SpaceMarine abc = new SpaceMarine(name1, new Coordinates(x1, y1), fl1, bl, h2, categ, new Chapter(name22, name33, r1),k);
        return abc;
    }
}

