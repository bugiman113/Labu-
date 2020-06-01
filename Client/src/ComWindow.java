import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class ComWindow {

        public static void createWO(Object object, int x, int y, int f, int a, int b, ResourceBundle bundleDef) {
            final Font FONT = new Font("Verdana", Font.PLAIN, 10);
            JFrame frame2 = new JFrame("Window");
            frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            frame2.addWindowListener(new WindowListener() {

                public void windowActivated(WindowEvent event) {// все время пока окно активно
                    Container container = frame2.getContentPane();
                    JTextArea textArea = new JTextArea(a, b);
                    textArea.setFont (new Font ("Verdana", Font.PLAIN, f));
                    textArea.append(String.valueOf(object));
                    textArea.setEditable(false);
                    JPanel panel = new JPanel();
                    JScrollPane scroll = new JScrollPane(textArea);
                    scroll.getVerticalScrollBar();
                    panel.add(scroll);
                    JButton button = new JButton("OK");
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource()==button){
                                event.getWindow().setVisible(false);
                            }
                        }
                    });
                    panel.add(button);
                    container.add(button,BorderLayout.SOUTH);
                    frame2.add(panel);
                }

                public void windowClosed(WindowEvent event) {
                }

                public void windowClosing(WindowEvent event) {
                    Object[] options = new Object[0];
                    try {
                        options = new Object[]{ new String(bundleDef.getString("YES").getBytes("ISO-8859-1"),"Cp1251"), new String(bundleDef.getString("NO").getBytes("ISO-8859-1"),"Cp1251") };

                    int n = 0;
                    n = JOptionPane
                            .showOptionDialog(event.getWindow(),new String(bundleDef.getString("EXIT").getBytes("ISO-8859-1"),"Cp1251") ,
                                    "EXIT", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, options,
                                    options[0]);
                    if (n == 0) {
                        event.getWindow().setVisible(false);}
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
            frame2.setPreferredSize(new Dimension(x, y));
            frame2.pack();
            frame2.setLocationRelativeTo(null);
            frame2.setResizable(false);
            frame2.setVisible(true);
            UIManager.put("Label.font", FONT);
        }
    }