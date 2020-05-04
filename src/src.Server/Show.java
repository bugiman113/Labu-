import java.sql.SQLException;

public class Show{
    public String show() throws SQLException {
        StringBuilder builder = new StringBuilder();
        Collection.chet();
        int a = 1;
        long key = 0;
        if (Collection.marineMap.size() != 0) {
            builder.append("Вот все элементы коллекции:!");
            key++;
            while (a <= Collection.marineMap.size()) {
                if (Collection.marineMap.get(key) != null) {
                    builder.append("Значение ключа:").append(key).append("Имя:").append(Collection.map.get(key).getName()).append(" Координаты (").append(Collection.map.get(key).getCordinatesX()).append(";").append(Collection.map.get(key).getCordinatesY()).append(")").append(" Количесвто жизней:").append(Collection.map.get(key).getHealth()).append(" Категория войск:").append(Collection.map.get(key).getCategory()).append(" Жив ли герой:").append(Collection.map.get(key).getLoyal()).append(" Параметры Chapter(").append(Collection.map.get(key).getChapter().getName()).append(";").append(Collection.map.get(key).getChapter().getParentLegion()).append(";").append(Collection.map.get(key).getChapter().getMarinesCount()).append(")").append(" ID = ").append(Collection.map.get(key).getId()).append(";").append("!");
                    key++;
                    a++;
                } else key++;
            }return builder.toString();
        } else builder.append("Коллекция пуста");
        return builder.toString();
    }
    public String myshow(Long us){
        StringBuilder builder = new StringBuilder();
        int a = 1;
        long key = 0;
        int b=0;
        if (Collection.map.size() != 0) {
            builder.append("Вот все элементы ваши коллекции:");
            key++;
            while (a <= Collection.map.size()) {
                if (Collection.map.get(key) != null && Collection.map.get(key).getUs()==us) {
                    builder.append("\nЗначение ключа:").append(key).append(" Имя:").append(Collection.map.get(key).getName()).append(" Координаты (").append(Collection.map.get(key).getCordinatesX()).append(";").append(Collection.map.get(key).getCordinatesY()).append(")").append(" Количесвто жизней:").append(Collection.map.get(key).getHealth()).append(" Категория войск:").append(Collection.map.get(key).getCategory()).append(" Жив ли герой:").append(Collection.map.get(key).getLoyal()).append(" Параметры Chapter(").append(Collection.map.get(key).getChapter().getName()).append(";").append(Collection.map.get(key).getChapter().getParentLegion()).append(";").append(Collection.map.get(key).getChapter().getMarinesCount()).append(")").append(" ID = ").append(Collection.map.get(key).getId()).append(";");
                    key++;
                    a++;
                    b++;
                } else {key++;
                a++;}
            }if (b==0){builder.append("\n       0--------0     ");
                builder.append("\nК сожалению вы ещё не создали ни одного элемента :-( \n Для создания нового элемента введите: insert_key");}
            return builder.toString();
        } else builder.append("Коллекция пуста");
        return builder.toString();
    }
}