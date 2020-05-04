import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//
public class Main {
    public static void main(String[] arg) {
        try(Socket socket = new Socket("localhost", 28569);
            Scanner scan = new Scanner(System.in);
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            DataInputStream ois = new DataInputStream(socket.getInputStream()); ) {
            Thread.sleep(500);
            System.out.println("Client успешно начал работать");
            System.out.println("Если вы уже пользовались (регестрировались) то введите 1");
            System.out.println("Если вы впервые пользуетесь, то вам необходимо ввести 2, чтобы зарегистрироваться");
            try {
                int b = scan.nextInt();
                while (b != 1 && b != 2) {
                    System.out.println("Вы ввели неверное число, для тех кто уже авторизовался-1, для новых пользователей- 2:");
                    b = scan.nextInt();
                }
                String bb = String.valueOf(b);
                oos.writeUTF(bb);
                if (b == 1) {
                    System.out.println("Введите свой логин:");
                    String string;
                    //пользователь с данным логиным не зарегестрирован
                    // вам необходимо ввести 2 чтобы зарегистрироваться
                    scan.hasNextLine();
                    scan.nextLine();
                    string = scan.nextLine();
                    oos.writeUTF(string);
                    int cc = 0;
                    int c=0;
                    while (c != 5) {
                        c = ois.read();
                        if (c == 4) {
                            while (cc != 11 && cc != 3) {
                                System.out.println("Введите свой пароль:");
                                String parol = scan.nextLine();
                                oos.writeUTF(parol);
                                c=5;
                                cc = ois.read();
                                if (cc == 5) {
                                    System.out.println("Авторизация успешно завершена");
                                    Long us = ois.readLong();
                                    boolean b1;
                                    b1= Client.main(socket,us);
                                    if (b1){ System.out.println("Отсоединение произошло успешно\n До новых встреч!\nИ да прибудет с вами сила!");
                                        return;};
                                }
                                if (cc == 1) {
                                    System.out.println("Вы ввели неверный пароль.");
                                    System.out.println("Если вы ещё "+ (3-cc) +" раза введете неверный пароль то программа будет завершена.");
                                }
                                if (cc == 2) {
                                    System.out.println("Вы ввели неверный пароль.");
                                    System.out.println("Если вы ещё "+ (3-cc) +" раза введете неверный пароль то программа будет завершена.");
                                }
                                if (cc == 3) {
                                    System.out.println("Вы несколько раз ввели неправильный пароль,программа будет завершена.");
                                }
                            }
                        }
                            if (c==1) {
                                System.out.println("Указаного вами логина не существует.");
                                System.out.println("У вас есть ещё "+ (3-c)  +" попытки чтобы ввести логин.");
                                System.out.println("Введите логин:");
                                string=scan.nextLine();
                                oos.writeUTF(string);
                            }
                            if (c==2) {
                            System.out.println("Указаного вами логина не существует.");
                            System.out.println("У вас есть ещё "+ (3-c)  +" попытка чтобы ввести логин.");
                            System.out.println("Введите логин:");
                            string=scan.nextLine();
                            oos.writeUTF(string);
                            }
                            if (c==3){
                                System.out.println("Логин введен неверно,программа завершена.");
                                c=5;
                            }
                    }
                }
                if (b == 2) {
                    scan.nextLine();
                    System.out.println("Для начала регистрации введите логин");
                    String login = scan.nextLine();
                    System.out.println("Ваш логин: "+login);
                    oos.writeUTF(login);
                    System.out.println("Если вы хотите чтобы система сама придумала вам пароль, введите 0.");
                    System.out.println("Если же вы хотите сами придумаете себе  пароль, то введите 3.");
                    int s = scan.nextInt();
                    while (s!=3 && s!=0){
                        System.out.println("Вы ввели неверное число.");
                        System.out.println("Если вы хотите чтобы система сама придумала вам пароль, введите 0.");
                        System.out.println("Если же вы хотите сами придумать себе пароль, то введите 3.");
                        s = scan.nextInt();
                    }
                    if (s == 0) {
                        int max = 10000000;
                        int min = 12345678;
                        int max2 = 10;
                        int min2 = 3;
                        int a = (int) ((Math.random() * ++max) + min);
                        int z = (int) ((Math.random() * ++max) + min);
                        int b3=(int) ((Math.random() * ++max2) + min2);
                        String c = String.valueOf(a*b3 + z);
                        oos.writeUTF(c);
                        System.out.println("Вот ваш пароль: " + c);
                        System.out.println("Никому не говорите ваш пароль!!!");
                        Thread.sleep(1000);
                        ois.readUTF();
                        Long us = ois.readLong();
                        boolean b1;
                        b1= Client.main(socket,us);
                        if (b1){ System.out.println("Отсоединение произошло успешно\n До новых встреч!\nИ да прибудет с вами сила!");
                            return;};
                    }
                    if (s == 3) {
                        scan.nextLine();
                        System.out.println("Введите пароль");
                        String parol1 = scan.nextLine();
                        System.out.println("Повторите введеный ранее пароль");
                        String parol2 = scan.nextLine();
                        while (!parol1.equals(parol2)) {
                            Thread.sleep(300);
                            System.out.println("Вы не потвердили свой пароль");
                            System.out.println("Введите новый пароль");
                            parol1 = scan.nextLine();
                            System.out.println("Повторите введеный пароль");
                            parol2 = scan.nextLine();
                        }
                        oos.writeUTF(parol1);
                        ois.readUTF();
                        Long us = ois.readLong();
                        boolean b1;
                        b1= Client.main(socket,us);
                        if (b1){ System.out.println("Отсоединение произошло успешно\n До новых встреч!\nИ да прибудет с вами сила!");
                            return;};
                    }
                }
            }catch (Exception e){
                System.out.println("Неверный ввод данных");
                int b=0;
                String bb = String.valueOf(b);
                oos.writeUTF(bb);
                socket.close();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Сервер не найден.");
            System.out.println("Повторите попытку позже(*-*)");
        }
    }
}
