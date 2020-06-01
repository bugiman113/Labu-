import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;

public class Window2A {

        public static final Font FONT = new Font("Verdana", Font.PLAIN, 16);

        public static void createW3(Socket socket, DataOutputStream oos, DataInputStream ois, ResourceBundle bundleDef,int b) {
            JFrame frame = new JFrame("Авторизация");
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            frame.addWindowListener(new WindowListener() {
                public void windowActivated(WindowEvent event) { // все время пока окно активно
                    try {
                    JPanel contents = new JPanel();
                    JLabel label0 = null;
                    label0 = new JLabel(new String(bundleDef.getString("WAL").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(label0);
                    JTextField log = new JTextField("", 20);
                    // Настройка шрифта
                    log.setFont(new Font("Dialog", Font.PLAIN, 15));
                    log.setHorizontalAlignment(JTextField.LEFT);
                    contents.add(log);
                    JLabel t = new JLabel("   ");
                    contents.add(t);
                    JLabel label1 = null;
                    label1 = new JLabel(new String(bundleDef.getString("WAP").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(label1);
                    JTextField password = new JTextField("", 20);
                    // Настройка шрифта
                    password.setFont(new Font("Dialog", Font.PLAIN, 15));
                    password.setHorizontalAlignment(JTextField.LEFT);
                    contents.add(password);
                    JLabel t2 = new JLabel("   ");
                    contents.add(t2);
                    JLabel label10 = new JLabel(new String(bundleDef.getString("WAPS").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(label10);
                    JButton b1 = new JButton(new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251"));//JButton создает активные клавиши
                    contents.add(b1);
                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource()==b1) {
                                if (!password.getText().equals("") && !log.getText().equals("")) {
                                    try {
                                        oos.writeUTF(log.getText());
                                        int c = 0;
                                        int cc = 0;
                                        while (c != 1) {
                                            c = ois.read();
                                            if (c == 4) {
                                                while (cc != 11 && cc != 3) {
                                                    oos.writeUTF(password.getText());
                                                    c = 5;
                                                    cc = ois.read();
                                                    if (cc == 5) {
                                                        Long us = ois.readLong();
                                                        int color = ois.readInt();
                                                        c = 1;
                                                        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
                                                        ObjectInputStream inn = new ObjectInputStream(socket.getInputStream());
                                                        WindowClient.createGUI(outToClient,inn, us,bundleDef,log.getText(),color);
                                                        event.getWindow().setVisible(false);
                                                        break;
                                                    }
                                                    if (cc == 0) {
                                                        c = 1;
                                                        Exc.createWO(socket, oos, ois, "пароль", bundleDef,b);
                                                        event.getWindow().setVisible(false);
                                                        break;
                                                    }
                                                }
                                            }
                                            if (c == 0) {
                                                event.getWindow().setVisible(false);
                                                Exc.createWO(socket, oos, ois, "логин", bundleDef,b);
                                                break;
                                            }
                                        }
                                    } catch (IOException | InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
                    JButton b2 = new JButton((new String(bundleDef.getString("BACK").getBytes("ISO-8859-1"),"Cp1251")));
                    b2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource()==b2){
                                String s = "back";
                                try {
                                    oos.writeUTF(s);
                                    frame.setVisible(false);
                                    WindowStart.createGUI(b,socket,oos,ois,bundleDef);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });contents.add(b2);
                    frame.add(contents);
                    } catch (UnsupportedEncodingException e) {
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

                public void windowOpened(WindowEvent event) {//когда окно только появляется
                }
            });
            UIManager.put("Label.font", FONT);
            frame.setPreferredSize(new Dimension(510, 190));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        }
    }
