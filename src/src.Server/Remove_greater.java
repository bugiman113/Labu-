import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Remove_greater {
    StringBuilder builder = new StringBuilder();
    public StringBuilder remove2(long kkk,long us) {
        if (Collection.map.size() != 0) {
            try {
                long msk = Collection.map.size();
                while (kkk < msk + 1) {
                    if (Collection.marineMap.get(kkk)!=null) {
                        if (Collection.map.get(kkk).getUs() == us) {
                            if (kkk <= msk & (kkk >= 1)) {
                                TableSP.delet(Collection.map.get(kkk).getId());
                                Collection.getCollection().remove(kkk);
                            } else builder.append("Нет такого ключа");
                            kkk++;
                        } else {
                            kkk++;
                        }
                    }else builder.append("Нет такого ключа");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }builder.append("Элементы успешно удалены");
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
    public StringBuilder remove2sc(Scanner ACD, File filik, int i,long us) throws FileNotFoundException {
        int sc = 1;
        if (Collection.map.size() != 0) {
            Scanner scanner = new Scanner(filik);
            while (sc < i + 1) {
                scanner.nextLine();
                sc++;
            }
            long kkk = scanner.nextLong();
            if (Collection.marineMap.get(kkk).getUs()==us) {
                try {
                    long msk = Collection.map.size();
                    while (kkk < msk + 1) {
                        if (Collection.marineMap.get(kkk)!=null) {
                            if (Collection.map.get(kkk).getUs() == us) {
                                if (kkk <= msk & (kkk >= 1)) {
                                    TableSP.delet(Collection.map.get(kkk).getId());
                                    Collection.getCollection().remove(kkk);
                                } else builder.append("Нет такого ключа");
                                kkk++;
                            } else {
                                kkk++;
                            }
                        }else builder.append("Нет такого ключа");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else builder.append("Элемент с данным ключом принадлежит не вам, операция не вполнена.");
    } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }
}