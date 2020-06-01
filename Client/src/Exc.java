import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ResourceBundle;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Exc {

    public static final Font FONT = new Font("Verdana", Font.PLAIN, 18);

    public static void createWO(Socket socket, DataOutputStream oos, DataInputStream ois, String name, ResourceBundle bundleDef,int b) {

        JFrame frame2 = new JFrame("Ошибка");
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame2.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {// все время пока окно активно
                JLabel label = new JLabel("                  ");
                JPanel panel = new JPanel();
                panel.add(label);
                try {
                JLabel label1 = new JLabel((new String(bundleDef.getString("EXC").getBytes("ISO-8859-1"),"Cp1251"))+" "+name+"!");
                JButton button2 = null;
                button2 = new JButton((new String(bundleDef.getString("BACK").getBytes("ISO-8859-1"),"Cp1251")));
                JLabel label4 = new JLabel(new String(bundleDef.getString("EXC2").getBytes("ISO-8859-1"),"Cp1251"));
                panel.add(label1);panel.add(label4);panel.add(button2);
                assert button2 != null;
                JButton finalButton = button2;
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                        if(ev.getSource()== finalButton){
                            Window2A.createW3(socket,oos,ois,bundleDef,b);
                            event.getWindow().setVisible(false);
                        }
                    }
                    });
                frame2.add(panel);
                } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            }

            public void windowClosed(WindowEvent event) {
            }

            public void windowClosing(WindowEvent event) {
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
        frame2.setPreferredSize(new Dimension(360, 200));
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setVisible(true);
    }
}

