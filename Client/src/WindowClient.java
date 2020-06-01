import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WindowClient {
    public static final Font FONT = new Font("Serif", Font.PLAIN, 16);
   public static String[][] data1=new String[][]{};
    public static  String[] columnNames = {
            "Name",
            "X coordinate",
            "Y coordinate",
            "Number of lives",
            "alive",
            "Height",
            "Type",
    };
    public static int color;

    public static void createGUI(ObjectOutputStream outToClient,ObjectInputStream inn, long us, ResourceBundle bundleDef,String login,int k) throws IOException, InterruptedException {
        color=k;
        JFrame frame = new JFrame("Window Client");
        final Font FONT = new Font("Serif", Font.PLAIN, 19);
        final Font FONTb = new Font("Serif", Font.PLAIN, 18);
        UIManager.put("Label.font", FONT);
        UIManager.put("Button.font", FONTb);
        JScrollPane scrollPane = new JScrollPane();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
        Thread.sleep(200);
        JPanel contents = new JPanel();
        //ObjectInputStream inn = new ObjectInputStream(socket.getInputStream());
        frame.addWindowListener(new WindowListener() {
            public void windowActivated(WindowEvent event) {
                try {
                JLabel label0 = new JLabel("        ");
                JLabel label1 = null;
                label1 = new JLabel(new String(bundleDef.getString("WCG").getBytes("ISO-8859-1"),"Cp1251")+login+"! ");
                JLabel label2 = new JLabel(new String(bundleDef.getString("WC").getBytes("ISO-8859-1"),"Cp1251"));
                JLabel label3 = new JLabel("     ");
                contents.add(label1);
                contents.add(label2);
                contents.add(label3);
                    JButton b1 = new JButton("help");//JButton создает активные клавиши
                    contents.add(b1);
                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == b1) {
                                Comand comand = null;
                                comand = Comand.help;
                                try {
                                    outToClient.writeObject(new AComands(comand).getComand());
                                    outToClient.flush();
                                    Object hl = inn.readObject();
                                    ComWindow.createWO(hl,805,295,12,13,69,bundleDef);
                                } catch (IOException | ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });
                    JButton b2 = new JButton("info");
                    contents.add(b2);
                    b2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == b2) {
                                Comand comand = null;
                                comand = Comand.info;
                                try {
                                    outToClient.writeObject(comand);
                                    outToClient.flush();
                                    Object inf = inn.readObject();
                                    ComWindow.createWO(inf,560,250,12,10,45,bundleDef);
                                } catch (IOException | ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });
                JButton b3 = new JButton("my_show");
                contents.add(b3);
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b3) {
                            Comand comand = null;
                            comand= Comand.my_show;
                            try {
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object myshow= inn.readObject();
                                ComWindow.createWO(myshow,830,250,10,10,68,bundleDef);
                            } catch (IOException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        }
                    }
                });
                JButton b6 = new JButton("show");
                contents.add(b6);
                b6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b6) {
                            Comand comand = null;
                            comand= Comand.show;
                            try {
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object show= inn.readObject();
                                ComWindow.createWO(show,830,250,10,10,68,bundleDef);
                            } catch (IOException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        }
                    }
                });
                JButton b15 = new JButton("script");
                contents.add(b15);
                JButton b4 = new JButton("print_unigue_chapter");
                contents.add(b4);
                b4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b4) {
                            Comand comand = null;
                            comand = Comand.print;
                            try {
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object print = inn.readObject();
                                ComWindow.createWO(print,550,200,15,6,30,bundleDef);
                            } catch (IOException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b5 = new JButton("max_by_coordinates");
                contents.add(b5);
                b5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b5) {
                            Comand comand = null;
                            comand = Comand.MaxCord;
                            try {
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object maxcorrd = inn.readObject();
                                ComWindow.createWO(maxcorrd,550,200,15,6,30,bundleDef);
                            } catch (IOException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b7 = new JButton("min_by_creation_date");
                contents.add(b7);
                b7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b7) {
                            Comand comand = null;
                            comand = Comand.mindate;
                            try {
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object mindate = inn.readObject();
                                ComWindow.createWO(mindate,570,200,13,6,49,bundleDef);
                            } catch (IOException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b8 = new JButton("insert_key");
                contents.add(b8);
                b8.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b8) {
                            Comand comand = Comand.insert_key;
                            try {
                                outToClient.writeObject(comand);
                            outToClient.flush();
                            Thread.sleep(300);
                            Insert_key.createW2(outToClient,inn,bundleDef,k);
                            } catch (IOException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        }
                    }
                });
                JButton b9 = new JButton("update_id");
                contents.add(b9);
                b9.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b9) {
                            Comand comand = null;
                            try {
                                comand = Comand.my_show;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object o = inn.readObject();
                                Thread.sleep(300);
                                Update_id.createW2(outToClient,inn,o,bundleDef,k);
                            } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b10 = new JButton("clear");
                contents.add(b10);
                b10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b10) {
                            Comand comand = null;
                            try {
                                Object[] options = { new String(bundleDef.getString("YES").getBytes("ISO-8859-1"),"Cp1251"), new String(bundleDef.getString("NO").getBytes("ISO-8859-1"),"Cp1251") };
                                int n = JOptionPane
                                        .showOptionDialog(event.getWindow(), (new String(bundleDef.getString("CLEAR").getBytes("ISO-8859-1"),"Cp1251")),
                                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null, options,
                                                options[0]);
                                if (n == 0) {
                                    comand = Comand.clear;
                                    outToClient.writeObject(comand);
                                    outToClient.flush();
                                    long c=1;
                                    outToClient.writeObject(c);
                                }
                                if (n==1 || n==-1){
                                    comand = Comand.clear;
                                    outToClient.writeObject(comand);
                                    long c=0;
                                    outToClient.writeObject(c);
                                }
                                Thread.sleep(300);
                            } catch (IOException | InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b11 = new JButton("remove_key");
                contents.add(b11);
                b11.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b11) {
                            Comand comand = null;
                            try {
                                comand = Comand.my_show;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object o = inn.readObject();
                                Thread.sleep(300);
                                RemoveWindow.createW2(outToClient,inn,o,bundleDef,Comand.remove_key);
                            } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b12 = new JButton("remove_greater_key");
                contents.add(b12);
                b12.addActionListener(new ActionListener() {
                    @Override
                        public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b12) {
                            Comand comand = null;
                            try {
                                comand = Comand.my_show;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object o = inn.readObject();
                                Thread.sleep(300);
                                RemoveWindow.createW2(outToClient,inn,o,bundleDef,Comand.remove_greater);
                            } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b13 = new JButton("replace_if_lowe");
                contents.add(b13);
                b13.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b13) {
                            Comand comand = null;
                            try {
                                comand = Comand.my_show;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object o = inn.readObject();
                                Thread.sleep(300);
                                ReplaceWindow.createW2(outToClient,inn,o,bundleDef);
                            } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JButton b14 = new JButton("remove_if_lower");
                contents.add(b14);
                b14.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b14) {
                            Comand comand = null;
                            try {
                                comand = Comand.my_show;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object o = inn.readObject();
                                Thread.sleep(300);
                                Remove_if_lower.createW2(outToClient,inn,o,bundleDef);
                            } catch (IOException | InterruptedException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                b15.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == b15) {
                            Comand comand = null;
                            Script fm = null;
                            try {
                                fm = new Script(frame,outToClient,inn,bundleDef,k);
                            } catch (UnsupportedEncodingException ex) {
                                ex.printStackTrace();
                            }
                            if(fm.isOK()){
                                JOptionPane.showMessageDialog(frame, "OK");
                            }
                        }
                    }
                });
                JButton button = new JButton(new String(bundleDef.getString("VIZ").getBytes("ISO-8859-1"),"Cp1251"));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Ellips example = new Ellips(outToClient,inn,bundleDef,us,login);
                            event.getWindow().setVisible(false);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                contents.add(button);
                JLabel label = new JLabel(new String(bundleDef.getString("TABLE").getBytes("ISO-8859-1"),"Cp1251"));
                contents.add(label);
                JLabel jLabel = new JLabel(new String(bundleDef.getString("WT1").getBytes("ISO-8859-1"),"Cp1251"));
                contents.add(jLabel);
                Tab(contents,scrollPane,inn,outToClient,bundleDef,us);
                JLabel labelv = new JLabel(new String(bundleDef.getString("WT2").getBytes("ISO-8859-1"),"Cp1251"));
                contents.add(labelv);
                contents.add(button);
                frame.add(contents);
                } catch (IOException | ClassNotFoundException e) {
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
                                    "EXIT", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, options,
                                    options[0]);
                if (n == 0) {
                    event.getWindow().setVisible(false);
                    Comand comand = Comand.exit;
                    try {
                        outToClient.writeObject(comand);
                        outToClient.flush();
                        outToClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
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

            public void windowOpened(WindowEvent event) {//когда с окном что-то происходит только появляется
            }
        });
        UIManager.put("Label.font", FONT);
        frame.pack();
        frame.setSize(new Dimension(700, 450));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void Tab(JPanel panel,JScrollPane scrollPane2,ObjectInputStream inn,ObjectOutputStream outToClient,ResourceBundle bundleDef,long us) throws IOException, ClassNotFoundException {
        Comand s = Comand.start;
        outToClient.writeObject(s);
        String data2[][]= (String[][]) inn.readObject();
        JTable table1 = new JTable(data2,columnNames){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        table1.setAutoCreateRowSorter(true);
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();
                if (evt.getClickCount() > 1) {
                    Object  o = table1.getValueAt(row,col);
                    Object  o2 = data2[row][8];
                    try {
                        outToClient.writeObject(Comand.table);
                        outToClient.writeObject(o);
                        outToClient.writeObject(o2);
                        outToClient.flush();
                        SpaceMarine sp =(SpaceMarine) inn.readObject();
                        if(sp!=null){
                            long key = (long) inn.readObject();
                            String sx=String.valueOf(sp.getCordinatesX());
                            String sy=String.valueOf(sp.getCordinatesY());
                            String fls = String.valueOf(sp.getHealth());
                            String h0 = String.valueOf(sp.getHeight());
                            String string = String.valueOf(sp.getChapter().getMarinesCount());
                            Update_table.createW2(outToClient,inn,bundleDef,key,sp.getName(),sx,sy,fls,h0,sp.getChapter().getName(),sp.getChapter().getParentLegion(),string,color);
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        scrollPane2.setViewportView(table1);
        scrollPane2.getVerticalScrollBar();
        scrollPane2.setPreferredSize(new Dimension(450,130));
        panel.add(scrollPane2,BorderLayout.CENTER);
    }
}
