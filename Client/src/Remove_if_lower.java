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

public class Remove_if_lower {
    public static final Font FONT = new Font("Verdana", Font.PLAIN, 15);
    public static void createW2(ObjectOutputStream outToClient, ObjectInputStream inn, Object k, ResourceBundle bundleDef) {

        JFrame frame2 = new JFrame("Remove_if_lower");
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame2.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {// все время пока окно активно
                JLabel label1 = null;
                try { label1 = new JLabel(new String(bundleDef.getString("REML1").getBytes("ISO-8859-1"),"Cp1251"));
                JLabel label7 = new JLabel(new String(bundleDef.getString("REML2").getBytes("ISO-8859-1"),"Cp1251"));
                JPanel panel = new JPanel();
                panel.add(label1);
                panel.add(label7);
                JTextArea textArea = new JTextArea(7, 45);
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
                JLabel label11 = new JLabel(new String(bundleDef.getString("REML3").getBytes("ISO-8859-1"),"Cp1251"));
                panel.add(label11);
                JComboBox comboBox = new JComboBox();
                comboBox.addItem(new String(bundleDef.getString("REMN").getBytes("ISO-8859-1"),"Cp1251"));
                comboBox.addItem(new String(bundleDef.getString("REMD").getBytes("ISO-8859-1"),"Cp1251"));
                panel.add(comboBox);
                JButton button = new JButton(new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251"));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==button){
                                try {
                                    Comand comand = Comand.remove_lower;
                                    outToClient.writeObject(comand);
                                    outToClient.flush();
                                    Long l1 = Long.parseLong(l.getText());
                                    outToClient.writeObject(l1);
                                    outToClient.writeObject(comboBox.getItemCount());
                                    outToClient.flush();
                                    Object rem = inn.readObject();
                                    ComWindow.createWO(rem,550,200,12,5,43,bundleDef);
                                    event.getWindow().setVisible(false);
                                } catch (IOException | ClassNotFoundException ex) {
                                    ex.printStackTrace();
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
        frame2.setPreferredSize(new Dimension(580, 350));
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setVisible(true);
    }
}
