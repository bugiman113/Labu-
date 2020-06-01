import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;

import javax.swing.*;

public class WindowStart extends JFrame {



    public static void createGUI(int b,Socket socket,DataOutputStream oos,DataInputStream ois,ResourceBundle bundleDef) throws IOException {
        final Font FONT = new Font("Serif", Font.PLAIN, b);
        final Font FONTb = new Font("Serif", Font.PLAIN, b);
        UIManager.put("Label.font", FONT);
        UIManager.put("Button.font", FONTb);
        String bb = String.valueOf(1);
        try {
        JFrame frame = new JFrame("Input window");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {
                try {
                    JPanel contents = new JPanel();
                    JLabel label1 = new JLabel(new String(bundleDef.getString("WSR").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(label1);
                    JButton b1 = new JButton(new String(bundleDef.getString("WSB1").getBytes("ISO-8859-1"),"Cp1251"));//JButton создает активные клавиши
                    contents.add(b1);
                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == b1) {
                                try {
                                    Window2R.createW2(socket, oos, ois,bundleDef,b);
                                String bb = String.valueOf(2);
                                    oos.writeUTF(bb);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                event.getWindow().setVisible(false);
                            }
                        }
                    });
                    JLabel label2 = new JLabel(new String(bundleDef.getString("WSA").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(label2);
                    JButton b2 = null;
                        b2 = new JButton(new String(bundleDef.getString("WSB2").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(b2);
                    JButton finalB = b2;
                    b2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ev) {
                            if (ev.getSource() == finalB) {
                                Window2A.createW3(socket, oos, ois,bundleDef,b);
                                String bb = String.valueOf(1);
                                try {
                                    oos.writeUTF(bb);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                event.getWindow().setVisible(false);
                            }
                        }
                    });
                    frame.add(contents);// все время пока окно активно
                }catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            public void windowClosed(WindowEvent event) {
            }

            public void windowClosing(WindowEvent event) {
                try {
                    Object[] options = { new String(bundleDef.getString("YES").getBytes("ISO-8859-1"),"Cp1251"), new String(bundleDef.getString("NO").getBytes("ISO-8859-1"),"Cp1251") };
                    int n = 0;

                    n = JOptionPane
                            .showOptionDialog(event.getWindow(),new String(bundleDef.getString("EXIT").getBytes("ISO-8859-1"),"Cp1251") ,
                                    "Подтверждение", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, options,
                                    options[0]);

                    if (n == 0) {
                        oos.writeUTF("");
                        event.getWindow().setVisible(false);
                        System.exit(0);
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

            public void windowOpened(WindowEvent event) {//когда с окном что-то происходит только появляется
            }
        });
        frame.pack();
        frame.setSize(new Dimension(400, 180));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }catch (Exception e){

        }
    }
}
