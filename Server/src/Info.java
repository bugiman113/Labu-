public class Info {
    public String inf(){
        return ("Тип коллекции " + Collection.map.getClass() + "!Дата инициализации: " + Collection.getTime() + "!количество элементов: " + Collection.map.entrySet().stream().mapToInt((p)->1).sum());//Collection.getCollection().size()
    }
}
