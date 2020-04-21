import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonoClient implements Runnable {

    private static Socket clientDialog;

    public MonoClient(Socket client) { MonoClient.clientDialog = client; }

    @Override
    public void run() {

        try {
            // инициируем каналы общения в сокете, для сервера
            // канал записи в сокет следует инициализировать сначала канал чтения для избежания блокировки выполнения программы на ожидании заголовка в сокете
            ObjectInputStream inn = new ObjectInputStream(clientDialog.getInputStream());
            clientDialog.isConnected();
            // канал чтения из сокета

            ObjectOutputStream outt = new ObjectOutputStream(clientDialog.getOutputStream());
                Object com = null;
            // начинаем диалог с подключенным клиентом в цикле, пока нет команды закрытия от клиента
                while (com != Comand.exit) {
                    com = inn.readObject();
                    String k = String.valueOf(com);
                    switch (k) {
                        case "show":
                            Object show = new Show().show();
                            outt.writeObject(show);
                            break;
                        case "start":
                            Collection.start();
                            Collection.zapis();
                            outt.writeObject(new Show().show());
                            break;
                        case "insert_key":
                            long keys;
                            keys = Key.keys();
                            SpaceMarine sp = null;
                            sp = (SpaceMarine) inn.readObject();
                            Collection.collection.put(keys, sp);
                            break;
                        case "update_id":
                            long key;
                            key = (long) inn.readObject();
                            if (Collection.collection.get(key) != null) {
                                SpaceMarine spaceMarine = null;
                                spaceMarine = (SpaceMarine) inn.readObject();
                                Collection.collection.put(key, spaceMarine);
                                outt.writeObject(new Show().show());
                            } else {
                                Object msg = String.valueOf("Вы ввели некоректное значение id. Для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "remove_key":
                            long kk = (long) inn.readObject();
                            if (Collection.collection.get(kk) != null) {
                                Object remove = new Remove_key().remove1(kk);
                                outt.writeObject(remove);
                            } else {
                                Object msg = String.valueOf("Вы ввели некоректное значение ключа. Для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "replace_if_lowe":
                            Scanner scanner = new Scanner(System.in);
                            long k7 = (long) inn.readObject();
                            int anInt = (int) inn.readObject();
                            if (Collection.collection.get(k7) != null) {
                                if (anInt == 1) {
                                    String name = (String) inn.readObject();
                                    int x = 0;
                                    int y = 0;
                                    float a3 = 0;
                                    new Replace().replace(scanner, k7, anInt, name, x, y, a3);
                                }
                                if (anInt == 2) {
                                    int x = (int) inn.readObject();
                                    int y = (int) inn.readObject();
                                    String name2 = null;
                                    float fl3 = 0;
                                    new Replace().replace(scanner, k7, anInt, name2, x, y, fl3);
                                }
                                if ((anInt == 3)) {
                                    float f = (float) inn.readObject();
                                    String name3 = null;
                                    int x = 0;
                                    int y = 0;
                                    new Replace().replace(scanner, k7, anInt, name3, x, y, f);
                                }
                                Object msg2 = String.valueOf("Элемент изменен,для проверки введите show");
                                outt.writeObject(msg2);
                            } else {
                                Object msg = String.valueOf("Вы ввели неверное значение,для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "remove_greater":
                            long kkk = (long) inn.readObject();
                            if (Collection.collection.get(kkk) != null) {
                                Object remg = new Remove_greater().remove2(kkk);
                                outt.writeObject(remg);
                            } else {
                                Object msg = String.valueOf("Вы ввели неверное значение,для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "remove_lower":
                            long key2 = (long) inn.readObject();
                            if (Collection.collection.get(key2) != null) {
                                int i = (int) inn.readObject();
                                Object reml = new Remove_lower().remove3(key2, i);
                                outt.writeObject(reml);
                            } else {
                                Object msg = String.valueOf("Вы ввели неверное значение,для того чтобы узнать все значения у элементов коллекции - введите команду show");
                                outt.writeObject(msg);
                            }
                            break;
                        case "help":
                            Object help = new Help().help();
                            outt.writeObject(help);
                            break;
                        case "info":
                            Object inf = new Info().inf();
                            outt.writeObject(inf);
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
                            Object script = new Script().script(file);
                            outt.writeObject(script);
                            break;
                        case "clear":
                            Object clear = new Clear().clear();
                            outt.writeObject(clear);
                            break;
                        case "exit":
                            System.out.println("Client иницаизировал отключение от сервера");
                            save();
                            clientDialog.close();
                            break;
                }
            }System.out.println("Cервер ждет нового на подключение нового клиента(-_-)");
        } catch (IOException | JAXBException | XMLStreamException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void save(){
        long k = 1;
        SpaceMarineList lists = new SpaceMarineList();
        List lst = new ArrayList();
        while (k <= Collection.collection.size()) {
            lst.add(Collection.collection.get(k));
            k++;
        }
        lists.setSpaceMarineList(lst);
        JAXBContext jaxbContext; //маршаллинг листа в хмл
        try {
            PrintWriter pw = new PrintWriter(new File("tekst.xml"));
            jaxbContext = JAXBContext.newInstance(SpaceMarineList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(lists, pw);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Сохранение коллекции завершено.");
    }
}