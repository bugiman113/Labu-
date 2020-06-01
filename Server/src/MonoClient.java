import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
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
        Long s = null;
        try {
            s = Main.main(clientDialog);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        if (s !=0) {
            try {
//                ObjectInputStream inn = new ObjectInputStream(clientDialog.getInputStream());
                clientDialog.isConnected();
                ObjectOutputStream outt = new ObjectOutputStream(clientDialog.getOutputStream());
                DataInputStream in = new DataInputStream(clientDialog.getInputStream());
                ObjectInputStream inn = new ObjectInputStream(in);
                // инициируем каналы общения в сокете, для сервера
                // канал записи в сокет следует инициализировать сначала канал чтения для избежания блокировки выполнения программы на ожидании заголовка в сокете
                // канал чтения из сокета
                Collection.chet();
                Object com = null;
                Long idus = s;
//                String[][] data1 = Tab();
//                   outt.writeObject(data1);
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
                            long kin = (long) inn.readObject();
                            if(kin==1) {
                                key = Keys.keys();
                                SpaceMarine sp = null;
                                sp = (SpaceMarine) inn.readObject();
                                AddTable.add(sp, idus);
                                addValue(key, sp);
                                Object ins = "Элемент успешно добавлен";
                                outt.writeObject(ins);
                            }
                            break;
                        case "update_id":
//                            String my_show2 = new Show().myshowl(idus);
//                            outt.writeObject(pool.invoke(new MyFork(0,my_show2)));
//                            long kup = (long) inn.readObject();
//                            if(kup==1) {
                                long keys;
                                keys = (long) inn.readObject();
                                if (Collection.marineMap.get(keys) != null) {
                                    Long id = Collection.marineMap.get(keys).getId();
                                    SpaceMarine spaceMarine = null;
                                    spaceMarine = (SpaceMarine) inn.readObject();
                                    if (Collection.marineMap.get(keys).getUs() == idus) {
                                        UpdateTable.up(spaceMarine, id);
                                        Collection.marineMap.put(keys, spaceMarine);
                                        Object msg = ("Обновление завершено,\n для проверки введите show или my_show.");
                                        outt.writeObject(msg);
                                    } else {
                                        Object msg = String.valueOf("Этот объект был создан не вами, его обновление невозможно.\n Чтобы посмотреть все свои элементы введите my_show.");
                                        outt.writeObject(msg);
                                    }
                                } else {
                                    Object msg = String.valueOf("Вы ввели некоректное значение ID. \nЧтобы узнать все значения у элементов коллекции\n - введите команду show");
                                    outt.writeObject(msg);
                                }
//                            }
                            break;
                        case "remove_key":
//                            String my_show3 = new Show().myshowl(idus);
//                            outt.writeObject(pool.invoke(new MyFork(0,my_show3)));
//                            long o1 =(long) inn.readObject();
//                            if(o1==1) {
                                long kk = (long) inn.readObject();
                                if (Collection.marineMap.get(kk) != null) {
                                    if (Collection.marineMap.get(kk).getUs() == idus) {
                                        Object remove = new Remove_key().remove1(kk);
                                        outt.writeObject(remove);
                                    } else {
                                        Object msg1 = ("Этот объект был создан не вами, его удаление невозможно.\n Для того чтобы посмотреть все свои элементы выберите my_show. ");
                                        outt.writeObject(msg1);
                                    }
                                } else {
                                    Object msg2 = ("Вы ввели некоректное значение ключа. \nДля того чтобы узнать все элементы коллекции выберите show");
                                    outt.writeObject(msg2);
                                }
//                            }
                            break;
                        case "replace_if_lowe":
//                            String my_show5 = new Show().myshowl(idus);
//                            outt.writeObject(pool.invoke(new MyFork(0,my_show5)));
//                            long o2 =(long) inn.readObject();
//                            if(o2==1) {
                                long k7 = (long) inn.readObject();
                                boolean b;
                                if (Collection.marineMap.get(k7) != null) {
                                    if (Collection.marineMap.get(k7).getUs() == idus) {
                                        String name = (String) inn.readObject();
                                        int x = (int) inn.readObject();
                                        int y = (int) inn.readObject();
                                        float f = (float) inn.readObject();
                                        b = new Replace().replace(k7, name, x, y, f);
                                        if (b = true) {
                                            Object msg2 = ("Элемент изменен,\nдля проверки введите show");
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
                                    Object msg = ("Вы ввели неверное значение,\nдля того чтобы узнать все значения ключей у ваших элементов коллекции - введите команду my_show");
                                    outt.writeObject(msg);
                                }
                            //}
                            break;
                        case "remove_greater":
//                            String my_show4 = new Show().myshowl(idus);
//                            outt.writeObject(pool.invoke(new MyFork(0, my_show4)));
//                            long o =(long) inn.readObject();
//                                if(o==1) {
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
//                                }
                            break;
                        case "remove_lower":
//                            String my_show6 = new Show().myshowl(idus);
//                            outt.writeObject(pool.invoke(new MyFork(0, my_show6)));
//                            long pr =(long) inn.readObject();
//                            if(pr==1) {
                                long key2 = (long) inn.readObject();
                                if (Collection.marineMap.get(key2) != null && Collection.marineMap.get(key2).getUs() == idus) {
                                    int i = (int) inn.readObject();
                                    Object reml = new Remove_lower().remove3(key2, i, idus);
                                    outt.writeObject(reml);
                                } else {
                                    Object msg = String.valueOf("Элемент с данным ключом принадлежит не вам,\n Для того чтобы посмотреть все свои элементы введите my_show. ");
                                    outt.writeObject(msg);
                                }
//                            }
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
                            long S = (long) inn.readObject();
                            if(S==1) {
                                String file = (String) inn.readObject();
                                int color = inn.readInt();
                                Object script = new Script().script(file, idus,color);
                                outt.writeObject(script);
                            }
                            break;
                        case "clear":
                            long c = (long) inn.readObject();
                            if(c==1) {
                               new Clear().clear(idus);
                            }
                            break;
                        case "start":
                            String[][] data1 = Tab();
                            data1 = Tab();
                            outt.writeObject(data1);
                            break;
                        case "table":
                            String name = (String) inn.readObject();
                            String x0 =(String) inn.readObject();
                            long x = Long.parseLong(x0);
                            long keyt=0;
                            SpaceMarine spaceMarine = null;
                            int b2 = Collection.marineMap.size();
                            for(long i=1;i<=b2;i++){
                                if((Collection.marineMap.get(i).getName().equals(name)&&Collection.marineMap.get(i).getId()==x)){
                                        if(Collection.marineMap.get(i).getUs()==idus){
                                        spaceMarine = Collection.marineMap.get(i);
                                        keyt = i;
                                        }
                                }
                            }
                            outt.writeObject(spaceMarine);
                            if (spaceMarine!=null){outt.writeObject(keyt);};
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
            System.out.println("Cервер ждет на подключение нового клиента(-_-)/");
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
                return builder1;
        }
    }
    public static String[][] Tab(){
        int n =Collection.marineMap.size();
        if (Collection.marineMap.size()!=0) {
            String[][] arr = new String[n][9];
            for (int i = 0; i < Collection.marineMap.size(); i++) {
                long key = i + 1;
                if (Collection.marineMap.get(key) != null) {
                    arr[i][0] = Collection.marineMap.get(key).getName();
                    arr[i][1] = String.valueOf(Collection.marineMap.get(key).getCordinatesX());
                    arr[i][2] = String.valueOf(Collection.marineMap.get(key).getCordinatesY());
                    arr[i][3] = String.valueOf(Collection.marineMap.get(key).getHealth());
                    arr[i][4] = String.valueOf(Collection.marineMap.get(key).getLoyal());
                    arr[i][5] = String.valueOf(Collection.marineMap.get(key).getHeight());
                    arr[i][6] = String.valueOf(Collection.marineMap.get(key).getCategory());
                    arr[i][7]= String.valueOf(Collection.marineMap.get(key).getColor());
                    arr[i][8]=String.valueOf(Collection.marineMap.get(key).getId());
                } else {
                }
            }
            return arr;
        }else {
            return new String[0][0];}
    }
}