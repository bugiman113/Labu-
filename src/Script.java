import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Script {
    StringBuilder builder = new StringBuilder();
    Scanner scan = new Scanner(System.in);
    private ArrayList<Integer> history = new ArrayList<Integer>();
    private int h = 0;

    public StringBuilder script(String filik) throws JAXBException {
        int sk = 0;
        int c = 0;
        ArrayList<String> list = new ArrayList<String>();
        h++;
        history.add(h);
        if (history.size() < 8) {
            try {
                FileReader fr = new FileReader(filik);
                Scanner ois = new Scanner(fr);
                String k = "";
                int i = 0;
                builder.append("вызвана команда скрипт");
                while (ois.hasNextLine() ) {
                    try {
                        k = ois.nextLine();
                        switch (k) {
                            case "info":
                                builder.append(System.lineSeparator() + "Сработала команда info" + System.lineSeparator());
                                builder.append(new Info().inf());
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "help":
                                builder.append(System.lineSeparator() + "Сработала команда help" + System.lineSeparator());
                                builder.append(new Help().help());
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "insert_key":
                                sk = i;
                                builder.append(System.lineSeparator() + "Сработала команда inset_key");
                                builder.append(insert_key3(scan, filik, sk));
                                builder.append(System.lineSeparator() + "Команда выполнена+для проверки введите команду show" + System.lineSeparator());
                                i = i + 22;
                                i++;
                                break;
                            case "show":
                                builder.append(System.lineSeparator() + "Сработала команда  show" + System.lineSeparator());
                                builder.append(new Show().show());
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "print_unique_chapter":
                                builder.append(System.lineSeparator() + "Сработала команда print_unique_chapter " + System.lineSeparator());
                                builder.append(new Print().print());
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "remove_lower":
                                builder.append(System.lineSeparator() + "Сработала команда remove_lower " + System.lineSeparator());
                                builder.append(new Remove_lower().remove1sc(scan, new File(filik), i));
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "remove_greater_key":
                                builder.append(System.lineSeparator() + "Сработала команда remove_greater_key " + System.lineSeparator());
                                builder.append(new Remove_greater().remove2sc(scan, new File(filik), i));
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "max_by_coordinates":
                                builder.append(System.lineSeparator() + "Сработала команда max_by_coordinates " + System.lineSeparator());
                                builder.append(new MaxCord().Max_by_coordinates());
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "update_id":
                                builder.append(System.lineSeparator() + "Сработала команда update_id " + System.lineSeparator());
                                insert_key4(scan, filik, i);
                                builder.append("Команда выполнена" + System.lineSeparator());
                                i = i + 23;
                                i++;
                                break;
                            case "min_by_creation_date":
                                builder.append(System.lineSeparator() + "Сработала команда min_by_creation_date " + System.lineSeparator());
                                builder.append(new MinDate().Min_date());
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "remove_key":
                                builder.append(System.lineSeparator() + "Сработала команда remove_key ");
                                new Remove_key().remove1sc(scan, new File(filik), i);
                                i = i + 2;
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                break;
                            case "replace_if_lowe":
                                builder.append(System.lineSeparator() + "Сработала команда replace_if_lowe " + System.lineSeparator());
                                builder.append(new Remove_lower().remove1sc(scan, new File(filik), i));
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i = i + 3;
                                break;
                            case "script":
                                builder.append(System.lineSeparator() + "Повторно вызвана команда скрипт" + System.lineSeparator());
                                String fil = filik;
                                script(fil);
                                i++;
                                break;
                        }
                    } catch (RuntimeException e) {
                    builder.append("При выполнении команды возникла ошибка");
                    builder.append(System.lineSeparator() + "Проверьте правильно вы вели данные в скрипте");
                    builder.append(System.lineSeparator()+"Для того чтобы проверить правильно вы вели данные воспользуетесь командой info_script");
                    break;
                }
                }
                return builder;
            } catch (IOException e) {
                builder.append("Невозможно считать данные,проверьте файл и воспользуйтесь снова командой script.");
                builder.append("Выполнение команды script завершено.");
            }
        } else builder.append("script не может вызываться больше чем 7 раз");
        return builder.append("Произошел сбой при чтении файлов");
    }

    public StringBuilder insert_key3(Scanner scan, String filik, int sk) throws FileNotFoundException, JAXBException {
        int ik = 1;
        int skk = sk;
        Scanner scanner = new Scanner(new File(filik));
        String date = new String();
            while (ik <= sk + 1) {
                scanner.nextLine();
                ik++;
            }
            while (sk < skk + 21) {
                date = date + scanner.nextLine();
                sk++;
            }
            scanner.close();
            StringReader sr = new StringReader(date);
            JAXBContext jaxbContext = JAXBContext.newInstance(SpaceMarineList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SpaceMarineList lists1 = (SpaceMarineList) unmarshaller.unmarshal(sr);
            if (lists1.SpaceMarineList != null) {
                Collection.collection2.addAll(lists1.SpaceMarineList);
                System.out.println(Collection.collection2);
            } else {
                builder.append("Коллекция созданная из данного файла пуста");
            }
            if (Collection.collection2 != null) {
                while (Collection.collection2.size() != 0) {
                    long keys;
                    keys = Key.keys();
                    Collection.collection.put(keys, Collection.collection2.getFirst());
                    Collection.collection2.removeFirst();
                }
            }
            return builder;
    }

    public StringBuilder insert_key4(Scanner scan, String filik, int sk) throws FileNotFoundException, JAXBException {
        int ik = 1;
        int skk = sk;
        Scanner scanner = new Scanner(new File(filik));
        String date = new String();
            while (ik < sk + 2) {
                scanner.nextLine();
                ik++;
            }
            long keys = scanner.nextLong();
            while (sk < skk + 22) {
                date = date + scanner.nextLine();
                sk++;
            }
            scanner.close();
            StringReader sr = new StringReader(date);
            JAXBContext jaxbContext = JAXBContext.newInstance(SpaceMarineList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SpaceMarineList lists1 = (SpaceMarineList) unmarshaller.unmarshal(sr);
            if (lists1.SpaceMarineList != null) {
                Collection.collection2.addAll(lists1.SpaceMarineList);
                System.out.println(Collection.collection2);
            } else {
                builder.append("Коллекция созданная из данного файла пуста");
            }
            if (Collection.collection2 != null) {
                while (Collection.collection2.size() != 0) {
                    Collection.collection.put(keys, Collection.collection2.getFirst());
                    Collection.collection2.removeFirst();
                }
            }
            return builder;
    }
}