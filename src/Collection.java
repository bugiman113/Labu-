import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.time.ZonedDateTime;
import java.util.*;


public class Collection {
    public static ArrayDeque<SpaceMarine> collection2 = new ArrayDeque<>();
    public static HashMap<Long, SpaceMarine> collection=null;
    private static ZonedDateTime time;

    public static void chet(String file) throws FileNotFoundException, JAXBException {
        FileReader fr = new FileReader(file);
        Scanner scanner = new Scanner(fr);
        String date = new String();
        while (scanner.hasNext()) {
            date = date + scanner.nextLine();
        }
        scanner.close();
        StringReader sr = new StringReader(date);
        JAXBContext jaxbContext = JAXBContext.newInstance(SpaceMarineList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SpaceMarineList lists1 = (SpaceMarineList) unmarshaller.unmarshal(sr);
        if (lists1.SpaceMarineList != null) {
            collection2.addAll(lists1.SpaceMarineList);
            System.out.println("Файл считан ,создана коллекция состоящая из:" +Collection.collection2.stream().mapToInt((p)->1).sum()+" элементов.");
        } else {
            System.out.println("Коллекция созданная из данного файла пуста");
            System.out.println("Если вы хотите заполнить коллекцию стандартыми элементами введите команду start");
        }
    }

    public static void zapis() throws FileNotFoundException, XMLStreamException {
        collection = new HashMap<Long, SpaceMarine>();
        long keys;
        while (collection2.size() != 0) {
            keys = Key.keys();
            collection.put(keys, collection2.getFirst());
            collection2.removeFirst();
        }
        long i = 1;
        int n = collection.size();
//        if (collection.size() != 0){
//            while (i <= n) {
//                System.out.print(" IDэлемента" + collection.get(i) + ":" + collection.get(i).getId()); без лямбда
//                i++;}
//            System.out.println();}
        collection.forEach((k, v) -> System.out.println("ID = "+k + " " +"имеет элемент - "+ v));// Лямбда выражение!!!
        time = ZonedDateTime.now();
    }
    public static void start() throws FileNotFoundException, JAXBException {
        Scanner scanner = new Scanner(new File("tekst2.xml"));
        String date2 = new String();
        while (scanner.hasNext()) {
            date2 = date2 + scanner.nextLine();
        }
        scanner.close();
        StringReader sr = new StringReader(date2);
        JAXBContext jaxbContext = JAXBContext.newInstance(SpaceMarineList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SpaceMarineList lists1 = (SpaceMarineList) unmarshaller.unmarshal(sr);
        if (lists1.SpaceMarineList != null) {
            collection2.addAll(lists1.SpaceMarineList);
            System.out.println("Файл считан полностю,создана коллекция:");
            System.out.println(collection2);
        } else {
            System.out.println("Коллекция созданная из данного файла пуста");
            System.out.println("Если вы хотите заполнить коллекцию стандартыми элементами введите команду start");
        }
    }
    public static HashMap<Long, SpaceMarine> getCollection() {
        return collection;
    }
    public static ZonedDateTime getTime() {
        return time;
    }

}
