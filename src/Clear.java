public class Clear {
    public String clear(){
        Collection.collection.clear();
        return ( "Коллекция очищена"+"\nколичество элементов: " + Collection.getCollection().size());
    }
}