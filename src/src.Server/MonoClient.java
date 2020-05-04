import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MonoClient implements Runnable {
    static int numofop= 20;
    private static Socket clientDialog;
    static String ss = System.lineSeparator();
    static  int numpool = Runtime.getRuntime().availableProcessors();
    public MonoClient(Socket client) {
        MonoClient.clientDialog = client;
    }

    @Override
    public void run() {

        boolean s = false;

        try {
            s = Main.main(clientDialog);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        if (s == true) {
            try {
                // инициируем каналы общения в сокете, для сервера
                // канал записи в сокет следует инициализировать сначала канал чтения для избежания блокировки выполнения программы на ожидании заголовка в сокете
                ObjectOutputStream outt = new ObjectOutputStream(clientDialog.getOutputStream());
                ObjectInputStream inn = new ObjectInputStream(clientDialog.getInputStream());
                clientDialog.isConnected();
                // канал чтения из сокета

                Object com = null;
                Long idus = inn.readLong();
                // начинаем диалог с подключенным клиентом в цикле, пока нет команды закрытия от клиента
                while (com != Comand.exit) {
                    Collection.chet();
                    com = inn.readObject();
                    ForkJoinPool pool = new ForkJoinPool(numpool);

                    String k = String.valueOf(com);
                    switch (k) {
                        case "show":
                            String s1 = new Show().show();
                            Object show = new Show().show();
                            outt.writeObject(pool.invoke(new MyFork(0,s1)));
                            break;
                        case "my_show":
                            String my_show = new Show().myshow(idus);
                            outt.writeObject(pool.invoke(new MyFork(0,my_show)));
                            break;
                        case "insert_key":
                            long key;
                            key = Keys.keys();
                            SpaceMarine sp = null;
                            sp = (SpaceMarine) inn.readObject();
                            AddTable.add(sp, idus);
                            addValue(key, sp);
                            Object ins = "Элемент успешно добавлен";
                            outt.writeObject(ins);
                            break;
                        case "update_id":
                            long keys;
                            keys = (long) inn.readObject();
                            if (Collection.marineMap.get(keys) != null) {
                                Long id = Collection.marineMap.get(keys).getId();
                                SpaceMarine spaceMarine = null;
                                spaceMarine = (SpaceMarine) inn.readObject();
                                if (Collection.marineMap.get(keys).getUs() == idus) {
                                    UpdateTable.up(spaceMarine, id);
                                    Collection.marineMap.put(keys, spaceMarine);
                                    Object msg = ("Обновление завершено, для проверки введите show или my_show.");
                                    outt.writeObject(msg);
                                } else {
                                    Object msg = String.valueOf("Этот объект был создан не вами, его обновление невозможно.\n Для того чтобы посмотреть все свои элементы введите my_show.");
                                    outt.writeObject(msg);
                                }
                            } else {
                                Object msg = String.valueOf("Вы ввели некоректное значение id. Для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "remove_key":
                            long kk = (long) inn.readObject();
                            if (Collection.marineMap.get(kk) != null) {
                            if (Collection.marineMap.get(kk).getUs() == idus) {
                                    Object remove = new Remove_key().remove1(kk);
                                    outt.writeObject(remove);
                                } else {
                                    Object msg1 = ("Этот объект был создан не вами, его удаление невозможно.\n Для того чтобы посмотреть все свои элементы введите my_show. ");
                                    outt.writeObject(msg1);
                                }
                            } else {
                                Object msg2 = ("Вы ввели некоректное значение ключа. Для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg2);
                            }
                            break;
                        case "replace_if_lowe":
                            Scanner scanner = new Scanner(System.in);
                            long k7 = (long) inn.readObject();
                            int anInt = (int) inn.readObject();
                            boolean b;
                            if (Collection.marineMap.get(k7) != null) {
                                if (Collection.marineMap.get(k7).getUs() == idus) {
                                    if (anInt == 1) {
                                        String name = (String) inn.readObject();
                                        int x = 0;
                                        int y = 0;
                                        float a3 = 0;
                                        b = new Replace().replace(scanner, k7, anInt, name, x, y, a3);
                                    }
                                    if (anInt == 2) {
                                        int x = (int) inn.readObject();
                                        int y = (int) inn.readObject();
                                        String name2 = null;
                                        float fl3 = 0;
                                        b = new Replace().replace(scanner, k7, anInt, name2, x, y, fl3);
                                    }
                                    if ((anInt == 3)) {
                                        float f = (float) inn.readObject();
                                        String name3 = null;
                                        int x = 0;
                                        int y = 0;
                                        b = new Replace().replace(scanner, k7, anInt, name3, x, y, f);
                                    }
                                    if (b = true) {
                                        Object msg2 = ("Элемент изменен,для проверки введите show");
                                        outt.writeObject(msg2);
                                    } else {
                                        Object msg3 = ("Элемент не был изменен, так как введеное занчение больше старого.");
                                        outt.writeObject(msg3);
                                    }
                                } else {
                                    Object msg2 = ("Этот объект был создан не вами, его изменение невозможно.\n Для того чтобы посмотреть все свои элементы введите my_show. ");
                                    outt.writeObject(msg2);
                                }
                            } else {
                                Object msg = ("Вы ввели неверное значение,для того чтобы узнать все значения ключей у ваших элементов коллекции - введите команду my_show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "remove_greater":
                            long kkk = (long) inn.readObject();
                            if (Collection.marineMap.get(kkk) != null) {
                                if (Collection.marineMap.get(kkk).getUs() == idus) {
                                    Object remg = new Remove_greater().remove2(kkk, idus);
                                    outt.writeObject(remg);
                                } else {
                                    Object msg = ("Этот объект был создан не вами, вы можете удалять лишь свои элементы.\n Для того чтобы посмотреть все свои элементы введите my_show.");
                                    outt.writeObject(msg);
                                }
                            } else {
                                Object msg = ("Вы ввели неверное значение,для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "remove_lower":
                            long key2 = (long) inn.readObject();
                            if (Collection.marineMap.get(key2) != null && Collection.marineMap.get(key2).getUs() == idus) {
                                int i = (int) inn.readObject();
                                Object reml = new Remove_lower().remove3(key2, i, idus);
                                outt.writeObject(reml);
                            } else {
                                Object msg = String.valueOf("Элемент с данным ключом принадлежит не вам,\n Для того чтобы посмотреть все свои элементы введите my_show. ");
                                outt.writeObject(msg);
                            }
                            break;
                        case "help":
                            String help = new Help().help();
                            outt.writeObject(pool.invoke(new MyFork(0,help)));
                            break;
                        case "info":
                            String inf = new Info().inf();
                            outt.writeObject(pool.invoke(new MyFork(0,inf)));
                            break;
                        case "print":
                            Object print = new Print().print();
                            outt.writeObject(print);
                            break;
                        case "MaxCord":
                            Object maxcord = new MaxCord().Max_by_coordinates();
                            outt.writeObject(maxcord);
                            break;
                        case "mindate":
                            Object mindate = new MinDate().Min_date();
                            outt.writeObject(mindate);
                            break;
                        case "script":
                            String file = (String) inn.readObject();
                            Object script = new Script().script(file,idus);
                            outt.writeObject(script);
                            break;
                        case "clear":
                            Object clear = new Clear().clear(idus);
                            outt.writeObject(clear);
                            break;
                        case "exit":
                            System.out.println("Client иницаизировал отключение от сервера");
                            clientDialog.close();
                            break;
                    }
                }
                System.out.println("Cервер ждет на подключение нового клиента(-_-)/");
            } catch (IOException | JAXBException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }

    private static void addValue(Long key, SpaceMarine spaceMarine) {
        if (!Collection.marineMap.containsKey(key))
            Collection.marineMap.put(key, spaceMarine);
    }
    static class MyFork extends RecursiveTask<StringBuilder> {
        String builder;
        int i;

        public MyFork(int i,String builder){
            this.i=i;
            this.builder=builder;
        }

        @Override
        protected StringBuilder compute() {
            int i = -1;
            String spl = "!";
            String string = builder;
            StringBuilder builder1 = new StringBuilder();
            String[] s = string.split(spl);
            while (i!=s.length-1){
                i++;
                while (s[i]==null){i++;}
                String s1 = s[i];
                builder1.append(s1+ss);
                MyFork f2 = new MyFork(i,builder); }
            for (int z=0;z<20;z++){builder1.append("___");}
            builder1.append("Команда сработала");
            for (int g=0;g<20;g++){builder1.append("___");}
                return builder1;
        }
    }
}