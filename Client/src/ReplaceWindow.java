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

public class ReplaceWindow {
    public static final Font FONT = new Font("Verdana", Font.PLAIN, 15);
    public static void createW2(ObjectOutputStream outToClient, ObjectInputStream inn, Object k, ResourceBundle bundleDef) {

        JFrame frame2 = new JFrame("Объект");
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame2.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {// все время пока окно активно
                JLabel label1 = null;
                try {
                    label1 = new JLabel(new String(bundleDef.getString("REP1").getBytes("ISO-8859-1"),"Cp1251"));
                JPanel panel = new JPanel();
                panel.add(label1);
                JTextArea textArea = new JTextArea(7, 46);
                textArea.setFont (new Font ("Verdana", Font.PLAIN, 12));
                textArea.append(String.valueOf(k));
                textArea.setEditable(false);
                JScrollPane scroll = new JScrollPane(textArea);
                scroll.getVerticalScrollBar();
                panel.add(scroll);
                JLabel label0 = new JLabel(new String(bundleDef.getString("REMKEY2").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField l = new JTextField("",10);
                panel.add(label0);
                panel.add(l);
                JLabel label2 = new JLabel(new String(bundleDef.getString("NAME").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField name = new JTextField("",10);
                panel.add(label2);
                panel.add(name);
                JLabel label3 = new JLabel(new String(bundleDef.getString("X").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField x = new JTextField("",10);
                panel.add(label3);
                panel.add(x);
                JLabel label4 = new JLabel(new String(bundleDef.getString("Y").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField y = new JTextField("",10);
                panel.add(label4);
                panel.add(y);
                JLabel label5 = new JLabel(new String(bundleDef.getString("FL").getBytes("ISO-8859-1"),"Cp1251"));
                JTextField fl = new JTextField("",10);
                panel.add(label5);
                panel.add(fl);
                JButton button = new JButton(new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251"));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==button){
                            if (!l.getText().equals("")){
                                try {
                                    Comand comand = Comand.replace_if_lowe;
                                    outToClient.writeObject(comand);
                                    Long l1 = Long.parseLong(l.getText());
                                    outToClient.writeObject(l1);
                                    String name1 = String.valueOf(name.getText());
                                   outToClient.writeObject(name1);
                                   try {
                                       int x1 = Integer.parseInt(x.getText());
                                       outToClient.writeObject(x1);
                                   }catch (RuntimeException ex){ int x1=0;outToClient.writeObject(x1); }
                                    try {
                                        int y1 = Integer.parseInt(y.getText());
                                        outToClient.writeObject(y1);
                                    }catch (RuntimeException ex){ int y1=0;outToClient.writeObject(y1); }
                                    try {
                                        Float fl1 = Float.parseFloat(fl.getText());
                                        outToClient.writeObject(fl1);
                                    }catch (RuntimeException ex){ Float fl1 = (float) 0;outToClient.writeObject(fl1); }
                                    outToClient.flush();
                                    Object rem = inn.readObject();
                                    ComWindow.createWO(rem,550,200,12,5,43,bundleDef);
                                    event.getWindow().setVisible(false);
                                } catch (IOException | ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                });
                panel.add(button);
                frame2.add(panel);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            public void windowClosed(WindowEvent event) {
            }

            public void windowClosing(WindowEvent event) {
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane
                        .showOptionDialog(event.getWindow(), "Закрыть окно?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
//                    long lo=0;
//                    try {
//                        outToClient.writeObject(lo);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    event.getWindow().setVisible(false);
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
        UIManager.put("Button.font", FONT);
        UIManager.put("Label.font", FONT);
        frame2.setPreferredSize(new Dimension(550, 290));
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setVisible(true);
    }
}
