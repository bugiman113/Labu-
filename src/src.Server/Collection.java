import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Данный класс воссоздает все объекты Spacemarine,которые нвходятся в базе данных
 * И добовляет их в коллекцию marineMap,с которой в последуюшем и работает пользователь
 */

public class Collection {
    public static HashMap<Long, SpaceMarine> map =null;
    public static Map<Long, SpaceMarine> marineMap;
    public static ZonedDateTime time;
        public static HashMap<String, String> chet() throws SQLException {
            map =new HashMap<Long, SpaceMarine>();
            marineMap = Collections.synchronizedMap(map);
            long key=1;
            time=ZonedDateTime.now();
            Connection dbConnection2 = null;
            Statement statement2 = null;
            String selectTableSQL = "SELECT ID,NAME,X,Y,HEALTH,LOYAL,HEIGHT,CATEGORY,CHAPTERNAME,PARENTLEGION,MARINESCOUNT,US from spacemarine";
            try {
                dbConnection2 = TableSP.getDBConnection();
                statement2 = dbConnection2.createStatement();
                // выбираем данные с БД
                ResultSet rs = statement2.executeQuery(selectTableSQL);
                // И если что то было получено то цикл while сработает
                while (rs.next()) {
                    long id = rs.getLong(1);
                    String name = rs.getString(2);
                    int x = rs.getInt(3);
                    int y = rs.getInt(4);
                    float fl = rs.getFloat(5);
                    String category = rs.getString(8);
                    AstartesCategory categ=null;
                    if (category.equals("SCOUT")) {  categ = AstartesCategory.SCOUT; }
                    if (category.equals("ASSAULT")) { categ = AstartesCategory.ASSAULT; }
                    if (category.equals("TACTICAL")) { categ = AstartesCategory.TACTICAL; }
                    if (category.equals("TERMINATOR")) { categ = AstartesCategory.TERMINATOR; }
                    if (category.equals("LIBRARIAN")) { categ = AstartesCategory.LIBRARIAN; }
                    String loyal = rs.getString(6);
                    boolean bool;
                    if (loyal.equals("true")){bool = true;}else bool=false;
                    Float fl2 = rs.getFloat(7);
                    String name2 = rs.getString(9);
                    String name3 = rs.getString(10);
                    int inter = rs.getInt(11);
                    long us = rs.getLong(12);
                    marineMap.put(key,new SpaceMarine(name, new Coordinates(x, y), fl, bool, fl2, categ, new Chapter(name2, name3, inter),id,us));
                    key++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

    public static Map<Long, SpaceMarine> getCollection() {
        return marineMap;
    }

    public static ZonedDateTime getTime() {
        return time;
    }

}
