import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Remove_key{
    StringBuilder builder = new StringBuilder();
    public StringBuilder remove1(long kk) {
        if (Collection.collection.size() != 0) {
//            if (Collection.collection.get(kk) != null) {
        if (Collection.collection.entrySet().stream().anyMatch((p) -> p.getKey() == kk)){
            Collection.collection.entrySet().stream().filter((p) -> p.getKey() == kk).forEach(Collection.collection::remove);
                Collection.getCollection().remove(kk);
                builder.append("Элемент успешно удален");
            } else builder.append("Нет такого ключа");
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
    public StringBuilder remove1sc(Scanner ACD, File filik, int i) throws FileNotFoundException {
        int sc = 1;
        if (Collection.collection.size() != 0) {
            Scanner scanner = new Scanner(filik);
            while (sc < i + 1) {
                scanner.nextLine();
                sc++;
            }
            long kk = scanner.nextLong();
            if (Collection.collection.get(kk) != null) {
                Collection.getCollection().remove(kk);
            } else builder.append("Нет такого ключа");
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
}