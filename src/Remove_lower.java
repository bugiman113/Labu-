import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Remove_lower {
    StringBuilder builder = new StringBuilder();
    Iterator<Map.Entry<Long, SpaceMarine>> iterator = Collection.collection.entrySet().iterator();
    public StringBuilder remove3(long key, int i) {
        long s = 1;
        long a = 1;
        long ii = 1;
        if (Collection.collection.size() != 0) {
            Map.Entry<Long, SpaceMarine> entry = iterator.next();
            while (ii != entry.getKey()) {
                ii++;
            }
            long n = Collection.collection.size();
            if (i == 1) {//имя
                while (a <= n) {
                    if (Collection.collection.get(ii) != null) {
                        if (Collection.collection.get(ii).getName().length() < Collection.collection.get(key).getName().length()) {
                            Collection.collection.remove(ii);
                        } else ii++;
                    } else {
                        a++;
                        ii++;
                    }
                }
            }
            if (i == 2) {//координата
                while (a <= n) {
                    if (Collection.collection.get(ii) != null) {
                        if (Collection.collection.get(ii).getCoordinates() < Collection.collection.get(key).getCoordinates()) {
                            Collection.collection.remove(ii);
                        } else ii++;
                    } else {
                        a++;
                        ii++;

                    }
                }
            }
            builder.append("Удаление завершено");
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }

    public StringBuilder remove1sc(Scanner ACD, File filik, int i) throws FileNotFoundException {
        long s = 1;
        long a = 1;
        long ii = 1;
        int sc = 1;
        try {
            if (Collection.collection.size() != 0) {
                Scanner scanner = new Scanner(filik);
                while (sc < i + 2) {
                    scanner.nextLine();
                    sc++;
                }
                long key = scanner.nextLong();
                int iii = scanner.nextInt();
                if (Collection.collection.size() != 0) {
                    Map.Entry<Long, SpaceMarine> entry = iterator.next();
                    while (ii != entry.getKey()) {
                        ii++;
                    }
                    long n = Collection.collection.size();
                    if (iii == 1) {//имя
                        while (a <= n) {
                            if (Collection.collection.get(ii) != null) {
                                if (Collection.collection.get(ii).getName().length() < Collection.collection.get(key).getName().length()) {
                                    Collection.collection.remove(ii);
                                } else ii++;
                            } else {
                                a++;
                                ii++;
                            }
                        }
                    }
                    if (iii == 2) {//координата
                        while (a <= n) {
                            if (Collection.collection.get(ii) != null) {
                                if (Collection.collection.get(ii).getCoordinates() < Collection.collection.get(key).getCoordinates()) {
                                    Collection.collection.remove(ii);
                                } else ii++;
                            } else {
                                a++;
                                ii++;

                            }
                        }
                    }
                    builder.append("Удаление завершено");
                } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
                return builder;
            }
        }catch (Exception e){
            builder.append("Данные заполнены неверно");
        }
        return builder;
    }
}