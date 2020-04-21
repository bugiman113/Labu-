public class Key {
    public static long keys() {
        int i = 0;
        long id = 0;
        while (i <= Collection.collection.size() ) {
            i++;
            id = id + 1;
        }
        return id;
    }
}