 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
 import java.io.*;
 import java.net.Socket;
 import java.util.ResourceBundle;

 public class Window2R {
     public static int k;
        public static final Font FONT = new Font("Verdana", Font.PLAIN, 12);
        private static Color brushColor = Color.BLACK;

        public static void createW2(Socket socket, DataOutputStream oos, DataInputStream ois, ResourceBundle bundleDef,int b) throws UnsupportedEncodingException {

            JFrame frame = new JFrame(new String(bundleDef.getString("WSB1").getBytes("ISO-8859-1"),"Cp1251"));
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            frame.addWindowListener(new WindowListener() {

                public void windowActivated(WindowEvent event) {// все время пока окно активно
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
                    JLabel label1 = new JLabel(new String(bundleDef.getString("WAP").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(label1);
                    JTextField password = new JTextField("", 20);
                    // Настройка шрифта
                    password.setFont(new Font("Dialog", Font.PLAIN, 15));
                    password.setHorizontalAlignment(JTextField.LEFT);
                    contents.add(password);
                    JLabel label2 = new JLabel(new String(bundleDef.getString("WAPS").getBytes("ISO-8859-1"),"Cp1251"));
                    contents.add(label2);
                    JButton b1 = new JButton(new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251"));//JButton создает активные клавиши
                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource()==b1) {
                                if (!password.getText().equals("") && !log.getText().equals("")) {
                                    try {
                                        oos.writeUTF(log.getText());
                                        oos.writeUTF(password.getText());
                                        oos.writeInt(k);
                                        Long us = null;
                                        us = ois.readLong();
                                        ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
                                        ObjectInputStream inn = new ObjectInputStream(socket.getInputStream());
                                        WindowClient.createGUI(outToClient,inn, us,bundleDef,log.getText(),k);
                                    } catch (IOException | InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                    event.getWindow().setVisible(false);
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
                        });
                        JLabel label = new JLabel(new String(bundleDef.getString("R3").getBytes("ISO-8859-1"),"Cp1251"));
                        contents.add(label);
                        JButton selectBrushColorButton = new JButton("Select Color");
                        selectBrushColorButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                brushColor = JColorChooser.showDialog(((Component) e.getSource()).getParent(), "Select brush color panel", brushColor);
                                try {
                                    k=brushColor.getRGB();
                                }catch (RuntimeException ignored){}
                            }
                        });
                        contents.add(selectBrushColorButton);
                        contents.add(b1);
                        contents.add(b2);
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

            frame.setPreferredSize(new Dimension(520, 220));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        }
//     private static class colorButtonActionListener implements ActionListener {
//         public int actionPerformed(ActionEvent e) {
//             brushColor = JColorChooser.showDialog(((Component) e.getSource()).getParent(), "Select brush color panel", brushColor);
//             System.out.println(brushColor);
//             int k = brushColor.getRGB();
//             return k;
//         }
//     }
    }
