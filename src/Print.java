import java.util.ArrayList;
import java.util.List;
public class Print {
    public String print() {
        StringBuilder builder = new StringBuilder();
        if (Collection.collection.size() != 0) {
            List<Long> x = new ArrayList<Long>();
            builder.append("Вот список уникальных значений Chapter:");
            long i = 1;
            long a = 1;
            while (a <= (Collection.collection.size())) {
                if (Collection.collection.get(i) != null) {
                    long j = i + 1;
                    while (j <= Collection.collection.size()) {
                        if (Collection.collection.get(j) != null) {
                            if (Collection.collection.get(i).getChapter().getName().equals(Collection.collection.get(j).getChapter().getName())) {
                                x.add(j);
                                j++;
                            } else j++;
                        } else j++;
                    }
                    if (!x.contains(i)) {
                        builder.append(System.lineSeparator()+Collection.collection.get(i).getChapter().getName());
                    }
                    i++;
                    a++;
                } else i++;
            }return builder.toString();
        } else {builder.append("Коллекция пуста");
            return builder.toString();}
    }
}
