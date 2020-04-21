import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Remove_greater {
    StringBuilder builder = new StringBuilder();
    public StringBuilder remove2(long kkk) {
        if (Collection.collection.size() != 0) {
            try {
                long msk = Collection.collection.size();
                while (kkk < msk + 1) {
                    if (kkk <= msk & (kkk >= 1)) {
                        Collection.getCollection().remove(kkk);
                    } else builder.append("Нет такого ключа");
                    kkk++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }builder.append("Элменты успешно удалены");
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
    public StringBuilder remove2sc(Scanner ACD, File filik, int i) throws FileNotFoundException {
        int sc = 1;
        if (Collection.collection.size() != 0) {
            Scanner scanner = new Scanner(filik);
            while (sc < i + 1) {
                scanner.nextLine();
                sc++;
            }
            long kkk = scanner.nextLong();
            try {
            long msk = Collection.collection.size();
            while (kkk < msk + 1) {
                if (kkk <= msk & (kkk >= 1)) {
                    Collection.getCollection().remove(kkk);
                } else builder.append("Нет такого ключа");
                kkk++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }builder.append("Элменты успешно удалены");
    } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
}