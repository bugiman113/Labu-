import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;
import javax.swing.*;

public class Script extends JDialog {
    public static final Font FONT = new Font("Serif", Font.PLAIN, 21);
    public static final Font FONTb = new Font("Serif", Font.PLAIN, 18);
    private boolean resultDialog;
    public boolean isOK() {
        return resultDialog;
    }

    Script(JFrame owner, ObjectOutputStream outToClient, ObjectInputStream inn, ResourceBundle bundleDef,int c) throws UnsupportedEncodingException {
        super(owner);
        setSize(420, 250);
        UIManager.put("Button.font", FONTb);
        UIManager.put("Label.font", FONT);
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JLabel label = new JLabel((new String(bundleDef.getString("SCRIPT1").getBytes("ISO-8859-1"),"Cp1251")));
        add(label);
        JLabel label2 = new JLabel((new String(bundleDef.getString("SCRIPT2").getBytes("ISO-8859-1"),"Cp1251")));
        add(label2);
        JTextField name = new JTextField("",13);
        add(name);
        JButton button1 = new JButton((new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251")));
        setLayout(new FlowLayout());
        add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!name.getText().equals("")) {
                    Comand comand = Comand.script;
                    try {
                        outToClient.writeObject(comand);
                        outToClient.flush();
                        long scr=1;
                        outToClient.writeObject(scr);
                        outToClient.writeObject(name.getText());
                        outToClient.flush();
                        outToClient.writeInt(c);
                        outToClient.flush();
                        Object o = inn.readObject();
                        setVisible(false);
                        ComWindow.createWO(o, 800, 380, 12, 18, 68,bundleDef);
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        JButton button2 = new JButton((new String(bundleDef.getString("BACK").getBytes("ISO-8859-1"),"Cp1251")));
        setLayout(new FlowLayout());
        add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Comand comand = Comand.script;
                    try {
                        outToClient.writeObject(comand);
                        outToClient.flush();
                        long scr=0;
                        outToClient.writeObject(scr);
                        setVisible(false);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        });
        setVisible(true);
    }
}