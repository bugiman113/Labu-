import java.sql.SQLException;

/**
 * Здесь происходит удаление всех элементов пользователя
 */
public class Clear {
    public String clear(Long us) throws SQLException {
        int i=1;
        long l=1;
        int col = Collection.marineMap.size();
        while (i<= col){
            if (Collection.marineMap.get(l)!=null) {
                if (Collection.marineMap.get(l).getUs() == us) {
                    TableSP.delet(Collection.marineMap.get(l).getId());
                    Collection.marineMap.remove(l);
                    i++;
                } else {
                    i++;
                    l++;
                }
            }else {l++;}
        }
        return ("Все ваши элементы удалены из коллекции.");
    }
}