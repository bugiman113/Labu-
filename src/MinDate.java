import java.util.Date;

public class MinDate {
    public String Min_date() {
        StringBuilder builder = new StringBuilder();
        if (Collection.collection.size() != 0) {
            builder.append("Значение поля creationDate которого является минимальным у элемента: ");
            long dk = 1;
            while (Collection.collection.get(dk)==null){
                dk++;
            }
            long kk=dk;
            Date dt = Collection.collection.get(dk).getDate();
            int i = 0;
            while (i < Collection.collection.size()) {
                if (Collection.collection.get(dk) != null) {
                    if (dt.compareTo(Collection.collection.get(dk).getDate()) > 0) {
                        dt = Collection.collection.get(dk).getDate();
                        i++;
                        kk = dk;
                    } else i++;
                    dk++;
                }else dk++;
            }
            builder.append(Collection.collection.get(kk));return builder.toString();
        }else {builder.append("Коллекция пуста");
            return builder.toString();}
    }
}