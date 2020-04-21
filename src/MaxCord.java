public class MaxCord {
    public String Max_by_coordinates() {
        StringBuilder builder = new StringBuilder();
        if (Collection.collection.size() != 0) {
            builder.append("Максимальные координаты имеет объект:");
            long k = 1;
            while (Collection.collection.get(k)==null){
                k++;
            }
            long kk = 1;
            int cr = Collection.collection.get(k).getCoordinates();
            int i = 0;
            while (i < Collection.collection.size()) {
                if (Collection.collection.get(k)!=null) {
                    if (cr < (Collection.collection.get(k).getCoordinates())) {
                        cr = Collection.collection.get(k).getCoordinates();
                        i++;
                        kk = k;
                    } else i++;
                    k++;
                }else k++;
            }
            builder.append(Collection.collection.get(kk));
        }else {builder.append("Коллекция пуста");}
        return builder.toString();
    }
}
