import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Remove_key{
    StringBuilder builder = new StringBuilder();
    public StringBuilder remove1(long kk) throws SQLException {
        if (Collection.marineMap.size() != 0) {
        if (Collection.marineMap.get(kk)!=null){
            Collection.marineMap.entrySet().stream().filter((p) -> p.getKey() == kk).forEach(Collection.marineMap::remove);
            TableSP.delet(Collection.marineMap.get(kk).getId());
                Collection.marineMap.remove(kk);
                builder.append("Элемент успешно удален");
            } else builder.append("Нет такого ключа");
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
    public StringBuilder remove1sc(Scanner ACD, File filik, int i,long us) throws FileNotFoundException, SQLException {
        int sc = 1;
        if (Collection.marineMap.size() != 0) {
            Scanner scanner = new Scanner(filik);
            while (sc < i + 1) {
                scanner.nextLine();
                sc++;
            }
            long kk = scanner.nextLong();
            if (Collection.marineMap.get(kk).getUs()==us) {
                if (Collection.marineMap.get(kk) != null) {
                    TableSP.delet(Collection.map.get(kk).getId());
                    Collection.getCollection().remove(kk);
                } else builder.append("Нет такого ключа");
            }else builder.append("Этот элемент принадлежит не вам,его удаление невозможно.");
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
}