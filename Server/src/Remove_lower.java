import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Remove_lower {
    StringBuilder builder = new StringBuilder();
    Iterator<Map.Entry<Long, SpaceMarine>> iterator = Collection.map.entrySet().iterator();
    public StringBuilder remove3(long key, int i,long us) throws SQLException {
        long s = 1;
        long a = 1;
        long ii = 1;
        int b=0;
        if (Collection.map.size() != 0) {
            if (Collection.marineMap.get(key).getUs()==us) {
                Map.Entry<Long, SpaceMarine> entry = iterator.next();
                while (ii != entry.getKey()) {
                    ii++;
                }
                long n = Collection.map.size();
                if (i == 1) {//имя
                    while (a <= n) {
                        if (Collection.map.get(ii) != null && Collection.map.get(ii).getUs() == us) {
                            if (Collection.map.get(ii).getName().length() < Collection.map.get(key).getName().length()) {
                                TableSP.delet(Collection.map.get(ii).getId());
                                Collection.map.remove(ii);
                                ii++;
                                b++;
                            } else ii++;
                        } else {
                            a++;
                            ii++;
                        }
                    }
                }
                if (i == 2) {//координата
                    while (a <= n) {
                        if (Collection.map.get(ii) != null) {
                            if (Collection.map.get(ii).getUs() == us) {
                                if (Collection.map.get(ii).getCoordinates() < Collection.map.get(key).getCoordinates()) {
                                    TableSP.delet(Collection.map.get(ii).getId());
                                    Collection.map.remove(ii);
                                    b++;
                                } else ii++;
                            } else {
                                a++;
                                ii++;

                            }
                        } else {
                            a++;
                            ii++;

                        }
                    }
                }
            }else {builder.append("Этот элемент принадлежит не вам, его удаление невозможно.");}
            if (b!=0){builder.append("Удаление завершено");}else {builder.append("Удаление не произошло,т.к нет элементов меньше");}
        } else builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
        return builder;
    }

    public StringBuilder remove1sc(Scanner ACD, File filik, int i,long us) throws FileNotFoundException {
        long s = 1;
        long a = 1;
        long ii = 1;
        int sc = 1;
        try {
            if (Collection.map.size() != 0) {
                Scanner scanner = new Scanner(filik);
                while (sc < i + 2) {
                    scanner.nextLine();
                    sc++;
                }
                long key = scanner.nextLong();
                if (Collection.marineMap.get(key).getUs()==us) {
                    int iii = scanner.nextInt();
                    if (Collection.map.size() != 0) {
                        Map.Entry<Long, SpaceMarine> entry = iterator.next();
                        while (ii != entry.getKey()) {
                            ii++;
                        }
                        long n = Collection.map.size();
                        if (iii == 1) {//имя
                            while (a <= n) {
                                if (Collection.map.get(ii) != null) {
                                    if (Collection.map.get(ii).getName().length() < Collection.map.get(key).getName().length()) {
                                        TableSP.delet(Collection.map.get(ii).getId());
                                        Collection.map.remove(ii);
                                    } else ii++;
                                } else {
                                    a++;
                                    ii++;
                                }
                            }
                        }
                        if (iii == 2) {//координата
                            while (a <= n) {
                                if (Collection.map.get(ii) != null) {
                                    if (Collection.map.get(ii).getCoordinates() < Collection.map.get(key).getCoordinates()) {
                                        TableSP.delet(Collection.map.get(ii).getId());
                                        Collection.map.remove(ii);
                                    } else ii++;
                                } else {
                                    a++;
                                    ii++;

                                }
                            }
                        }
                        builder.append("Удаление завершено");
                    } else {builder.append("Коллекция пуста,поэтому команда не может быть выполнена");
                    return builder;}
                }else {builder.append("Данный объект принадлежит не вам, его ужаление невозможно.");}
            }
        }catch (Exception e){
            builder.append("Данные заполнены неверно");
        }
        return builder;
    }
}