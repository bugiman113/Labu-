import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;

public class Start {
    public static final Font FONT = new Font("Serif", Font.PLAIN, 20);
    public static final Font FONTb = new Font("Serif", Font.PLAIN, 18);
    public static void main(String[] arg) {

        JFrame frame2 = new JFrame("Start");
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame2.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {// все время пока окно активно
                JPanel panel = new JPanel();
                JLabel label11 = new JLabel("Выберите язык, на котором будет работать программа.");
                JLabel label2 = new JLabel("Select the language that the program will work in.");
                JLabel label = new JLabel("Valige keel, milles töötab program.");
                JLabel label12 = new JLabel(" Vælg det sprog hvor programmet vil fortsætte med at virke: ");
                panel.add(label11);panel.add(label2);
                panel.add(label); panel.add(label12);
                JComboBox comboBox = new JComboBox();
                comboBox.addItem("Русский");
                comboBox.addItem("English");
                comboBox.addItem("Dansk");
                comboBox.addItem("Eesti");
                panel.add(comboBox);
                JButton button = new JButton("ВВОД");
                button.addActionListener(e -> {
                    if(e.getSource()==button){
                        String a="";
                        int b=19;
                        if (comboBox.getSelectedIndex()==0){a="lang_ru";b=18;}
                        if (comboBox.getSelectedIndex()==1){a="lang_en";b=20;}
                        if (comboBox.getSelectedIndex()==3){a="lang_est";b=20;}
                        if (comboBox.getSelectedIndex()==2){a="lang_da";b=20;}
                        ResourceBundle bundleDef = ResourceBundle.getBundle(a);
                        try {

                            Socket socket = new Socket("localhost", 28571);
                            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                            DataInputStream ois = new DataInputStream(socket.getInputStream());
                            WindowStart.createGUI(b,socket,oos,ois,bundleDef);
                        } catch (IOException ex) {
                            WindEx.createWO(bundleDef);
                        }
                        event.getWindow().setVisible(false);
                    }
                });
                panel.add(button);
                frame2.add(panel);
            }

            public void windowClosed(WindowEvent event) {
            }

            public void windowClosing(WindowEvent event) {
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane
                        .showOptionDialog(event.getWindow(), "Вы уверены что хотите выйти?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    long lo=0;
                    event.getWindow().setVisible(false);
                    System.exit(0);
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
        UIManager.put("Button.font", FONTb);
        UIManager.put("Label.font", FONT);
        frame2.setPreferredSize(new Dimension(490, 230));
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setVisible(true);
    }
}
