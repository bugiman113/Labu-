public class Show{
    public String show(){
        StringBuilder builder = new StringBuilder();
        int a = 1;
        long key = 0;
        if (Collection.collection.size() != 0) {
            builder.append("Вот все элементы коллекции:");
            key++;
            while (a <= Collection.collection.size()) {
                if (Collection.collection.get(key) != null) {
                    builder.append("\nЗначение ключа:").append(key).append(" Имя:").append(Collection.collection.get(key).getName()).append(" Координаты (").append(Collection.collection.get(key).getCordinatesX()).append(";").append(Collection.collection.get(key).getCordinatesY()).append(")").append(" Количесвто жизней:").append(Collection.collection.get(key).getHealth()).append(" Категория войск:").append(Collection.collection.get(key).getCategory()).append(" Жив ли герой:").append(Collection.collection.get(key).getLoyal()).append(" Параметры Chapter(").append(Collection.collection.get(key).getChapter().getName()).append(";").append(Collection.collection.get(key).getChapter().getParentLegion()).append(";").append(Collection.collection.get(key).getChapter().getMarinesCount()).append(")");
                    key++;
                    a++;
                } else key++;
            }return builder.toString();
        } else builder.append("Коллекция пуста");
        return builder.toString();
    }
}