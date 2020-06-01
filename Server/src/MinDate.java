import java.util.Date;

public class MinDate {
    public String Min_date() {
        StringBuilder builder = new StringBuilder();
        if (Collection.marineMap.size() != 0) {
            builder.append("Значение поля creationDate которого является минимальным у элемента: ");
            long dk = 1;
            while (Collection.marineMap.get(dk)==null){
                dk++;
            }
            long kk=dk;
            Date dt = Collection.marineMap.get(dk).getDate();
            int i = 0;
            while (i < Collection.marineMap.size()) {
                if (Collection.marineMap.get(dk) != null) {
                    if (dt.compareTo(Collection.marineMap.get(dk).getDate()) > 0) {
                        dt = Collection.marineMap.get(dk).getDate();
                        i++;
                        kk = dk;
                    } else i++;
                    dk++;
                }else dk++;
            }
            builder.append(Collection.marineMap.get(kk));return builder.toString();
        }else {builder.append("Коллекция пуста");
            return builder.toString();}
    }
}