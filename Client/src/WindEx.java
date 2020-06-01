import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class WindEx {

    public static final Font FONT = new Font("Verdana", Font.PLAIN, 20);

    public static void createWO(ResourceBundle bundleDef) {
        JFrame frame2 = new JFrame("Ошибка");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {// все время пока окно активно
                JLabel label1 = null;
                try {
                    label1 = new JLabel(new String(bundleDef.getString("EXS1").getBytes("ISO-8859-1"),"Cp1251"));
                JPanel panel = new JPanel();
                panel.setBackground(Color.LIGHT_GRAY);
                JButton button2 = new JButton(new String(bundleDef.getString("EXITS").getBytes("ISO-8859-1"),"Cp1251"));
                button2.setPreferredSize(new Dimension(120,40));
                JLabel label2 = new JLabel(new String(bundleDef.getString("EXS").getBytes("ISO-8859-1"),"Cp1251"));
                panel.add(label1);
                panel.add(label2);
                panel.add(button2);
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                        if(ev.getSource()==button2){
                            event.getWindow().setVisible(false);
                            System.exit(0);
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
//                Object[] options = { "Да", "Нет!" };
//                int n = JOptionPane
//                        .showOptionDialog(event.getWindow(), "Закрыть окно?",
//                                "Подтверждение", JOptionPane.YES_NO_OPTION,
//                                JOptionPane.QUESTION_MESSAGE, null, options,
//                                options[0]);
//                if (n == 0) {
//                    event.getWindow().setVisible(false);
//                    System.exit(0);
//                }
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
        frame2.setPreferredSize(new Dimension(340, 150));
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setVisible(true);
    }
}

