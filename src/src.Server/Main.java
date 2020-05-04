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
    public static boolean main(Socket client) throws SQLException, IOException {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            CollUS.collection();
            String bb = in.readUTF();
            boolean b1;
            int f=1;
            int n = 0;
            long key;
            int b = Integer.parseInt(bb);
            if (b == 1) {
                b1 = false;
                int n1=0;
                int c = 1;
                boolean b2 = false;
                while (n!=3) {
                    key=1;
                    String string = in.readUTF();
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
                        n1++;
                        out.write(n1);
                        n++;
                    }
                    if (b2 == true) {
                        while (c <= 3) {
                            String parol = in.readUTF();
                            String parol2 = UserTab.encryptThisString(parol);
                            if (parol2.equals(CollUS.mapus.get(key).getParol())) {
                                out.write(5);
                                n=3;
                                c=4;
                                out.writeLong(CollUS.mapus.get(key).getIdus());
                                return b1 = true;
                            } else {
                                out.write(f);
                                f++;
                                c++;
                            }
                            if (c == 4) {
                                out.write(3);
                                c=4;
                                n=3;
                                return false;
                            }
                        }
                    }
                }
            }
            if (b == 2) {
                String login = in.readUTF();
                String parol = in.readUTF();
                UserTab.adduser(login, parol);
                CollUS.collection();
                out.writeUTF("Регистрация успешно завершена!");
                long k= CollUS.indkey(login);
                out.writeLong(k);
                return b1 = true;
            }
            if (b==0){return b1=false;}
        }catch (RuntimeException e){
            System.out.println("");
        }
        return false;
    }
}
