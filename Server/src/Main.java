import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Данный класс используется для общения клиент-пользователь при авторизации
 */

public class Main {
    public static long main(Socket client) throws SQLException, IOException {
        try {
            int pr=-1;
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                CollUS.collection();
                String bb = in.readUTF();
                if(bb.equals("")){return 0;};
                long b1;
                int f = 0;
                int n = 0;
                long key;
                while (pr != 1) {
                    if (bb.equals("back")){
                        bb = in.readUTF();
                    }
                    int b = Integer.parseInt(bb);
                    if (b == 1) {
                        b1 = 0;
                        int n1 = 0;
                        int c = 1;
                        boolean b2 = false;
                        while (n != 3) {
                            key = 1;
                            String string = in.readUTF();
                            if (string.equals("back")){
                                bb="back";
                                break;}
                            if (string.equals("")){n=3;return b1=0; }
                            while (key <= CollUS.mapus.size()) {
                                if (string.equals(CollUS.mapus.get(key).getLogin())) {
                                    b2 = true;
                                    n1 = 3;
                                    out.write(4);
                                    break;
                                } else {
                                    key++;
                                }
                            }
                            if (b2 == false) {
                                n1 = 0;
                                out.write(n1);
                                n = 1;
                                break;
                            }
                            if (b2 == true) {
                                while (c <= 3) {
                                    String parol = in.readUTF();
                                    String parol2 = UserTab.encryptThisString(parol);
                                    if (parol2.equals(CollUS.mapus.get(key).getParol())) {
                                        out.write(5);
                                        n = 3;
                                        c = 4;
                                        pr = 1;
                                        out.writeLong(CollUS.mapus.get(key).getIdus());
                                        out.writeInt(CollUS.mapus.get(key).getColor());
                                        Long us = CollUS.mapus.get(key).getIdus();
                                        return b1 = us;
                                    } else {
                                        out.write(f);
                                        c = 2;
                                        n = 1;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (b == 2) {
                        String login = in.readUTF();
                        if (login.equals("")){
                            return 0;
                        };
                        if (login.equals("back")){
                            bb="back";
                           }else {
                        String parol = in.readUTF();
                        int color = in.readInt();
                        UserTab.adduser(login, parol,color);
                        CollUS.collection();
                        long k = CollUS.indkey(login);
                        out.writeLong(k);
                        pr=1;
                        return b1 = k;}
                    }
                    if (b == 0) {
                        return b1 = 0;
                    }
                }
        }catch (RuntimeException e){
            System.out.println("");
        }
        return 0;
    }
}
