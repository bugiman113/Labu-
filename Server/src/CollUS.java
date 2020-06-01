import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Данный класс создает коллекцию пользователь, которая используется для авторизации пользователя
 */
public class CollUS {
    public static HashMap<Long, User> collus;
    public static Map<Long, User> mapus;
    public static HashMap<String, String> collection() throws SQLException {
        collus=new HashMap<>();
        mapus = Collections.synchronizedMap(collus);
        long key = 1;
        Connection dbConnection2 = null;
        Statement statement2 = null;
        String selectTableSQL = "SELECT ID,NAME,PASSWORD,COLOR from usertable";
        try {
            dbConnection2 = UserTab.getDBConnection();
            statement2 = dbConnection2.createStatement();
            // выбираем данные с БД
            ResultSet rs = statement2.executeQuery(selectTableSQL);
            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String username = rs.getString("NAME");
                Long id  = rs.getLong("ID");
                String password = rs.getString("PASSWORD");
                int color = rs.getInt("COLOR");
                User user1 = new User(username,password,id,color);
                mapus.putIfAbsent(key,user1);
                key++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Long indkey(String log){
        long i =1;
        while (i< mapus.size()){
            if (mapus.get(i).getLogin().equals(log)){
                return i;
            }else {i++;}
        }
        return i;
    }
}

