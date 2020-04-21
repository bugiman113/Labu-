public class Info {
    public String inf(){
        return ("Тип коллекции " + Collection.collection.getClass() + "\nДата инициализации: " + Collection.getTime() + "\nколичество элементов: " + Collection.collection.entrySet().stream().mapToInt((p)->1).sum());//Collection.getCollection().size()
    }
}
