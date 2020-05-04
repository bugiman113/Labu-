public class MaxCord {
    public String Max_by_coordinates() {
        StringBuilder builder = new StringBuilder();
        if (Collection.marineMap.size() != 0) {
            builder.append("Максимальные координаты имеет объект:");
            long k = 1;
            while (Collection.marineMap.get(k)==null){
                k++;
            }
            long kk = 1;
            int cr = Collection.marineMap.get(k).getCoordinates();
            int i = 0;
            while (i < Collection.marineMap.size()) {
                if (Collection.marineMap.get(k)!=null) {
                    if (cr < (Collection.marineMap.get(k).getCoordinates())) {
                        cr = Collection.marineMap.get(k).getCoordinates();
                        i++;
                        kk = k;
                    } else i++;
                    k++;
                }else k++;
            }
            builder.append(Collection.marineMap.get(kk));
        }else {builder.append("Коллекция пуста");}
        return builder.toString();
    }
}
