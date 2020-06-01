import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;
import javax.swing.*;

public class FormM extends JDialog {
    public static final Font FONT = new Font("Verdana", Font.PLAIN, 17);
    private boolean resultDialog;
    public boolean isOK() {
        return resultDialog;
    }

    FormM(JFrame owner, ResourceBundle bundleDef) throws UnsupportedEncodingException {
        super(owner);
        setSize(350, 410);
        setLocationRelativeTo(owner);
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        JLabel label = new JLabel((new String(bundleDef.getString("OPS").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label2 = new JLabel((new String(bundleDef.getString("ONAME").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label3 = new JLabel((new String(bundleDef.getString("OX").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label4 = new JLabel((new String(bundleDef.getString("OY").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label5 = new JLabel((new String(bundleDef.getString("OFL").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label17 = new JLabel((new String(bundleDef.getString("OBOOL").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label18 = new JLabel((new String(bundleDef.getString("OH").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label7 = new JLabel((new String(bundleDef.getString("OAST").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label8 = new JLabel((new String(bundleDef.getString("ONAME2").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label9 = new JLabel((new String(bundleDef.getString("ONAME3").getBytes("ISO-8859-1"),"Cp1251")));
        JLabel label10 = new JLabel((new String(bundleDef.getString("OINT").getBytes("ISO-8859-1"),"Cp1251")));
        add(label);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label17);
        add(label18);
        add(label7);
        add(label8);
        add(label9);
        add(label10);
        JButton button1 = new JButton((new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251")));
        setLayout(new FlowLayout());
        add(button1);
        UIManager.put("Button.font", FONT);
        UIManager.put("Label.font", FONT);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormM.this.setVisible(false);
            }
        });
        setVisible(true);
    }
}
