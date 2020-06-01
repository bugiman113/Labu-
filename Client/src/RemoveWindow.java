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

public class RemoveWindow {
        public static final Font FONT = new Font("Verdana", Font.PLAIN, 15);
        public static void createW2(ObjectOutputStream outToClient, ObjectInputStream inn, Object k, ResourceBundle bundleDef,Comand comand) {

            JFrame frame2 = new JFrame("Объект");
            frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            frame2.addWindowListener(new WindowListener() {

                public void windowActivated(WindowEvent event) {// все время пока окно активно
                     try {
                    JLabel label1 = new JLabel((new String(bundleDef.getString("REMKEY1").getBytes("ISO-8859-1"),"Cp1251")));
                    JPanel panel = new JPanel();
                    panel.add(label1);
                    JTextArea textArea = new JTextArea(7, 45);
                    textArea.setFont (new Font ("Verdana", Font.PLAIN, 12));
                    textArea.append(String.valueOf(k));
                    textArea.setEditable(false);
                    JScrollPane scroll = new JScrollPane(textArea);
                    scroll.getVerticalScrollBar();
                    panel.add(scroll);
                    JLabel label0 = new JLabel((new String(bundleDef.getString("REMKEY2").getBytes("ISO-8859-1"),"Cp1251")));
                    JTextField l = new JTextField("",10);
                    panel.add(label0);
                    panel.add(l);
                    JButton button = null;
                    button = new JButton((new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251")));
                         JButton finalButton = button;
                         button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource()== finalButton){
                                if (!l.getText().equals("")){
                                    try {
                                        outToClient.writeObject(comand);
                                        Long l1 = Long.parseLong(l.getText());
                                        outToClient.writeObject(l1);
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
                    try {
                    Object[] options = new Object[0];

                        options = new Object[]{ new String(bundleDef.getString("YES").getBytes("ISO-8859-1"),"Cp1251"), new String(bundleDef.getString("NO").getBytes("ISO-8859-1"),"Cp1251") };

                    int n = 0;

                    n = JOptionPane
                            .showOptionDialog(event.getWindow(),new String(bundleDef.getString("EXIT").getBytes("ISO-8859-1"),"Cp1251") ,
                                    "Подтверждение", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, options,
                                    options[0]);
                    if (n == 0) {
//                        long lo=0;
//                            outToClient.writeObject(lo);
                       event.getWindow().setVisible(false);
                    }
                    } catch (UnsupportedEncodingException e) {
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
            UIManager.put("Button.font", FONT);
            UIManager.put("Label.font", FONT);
            frame2.setPreferredSize(new Dimension(550, 280));
            frame2.pack();
            frame2.setLocationRelativeTo(null);
            frame2.setResizable(false);
            frame2.setVisible(true);
        }
    }
