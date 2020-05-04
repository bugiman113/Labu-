import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
Класс используется для добавления нового объекта в базу данных spacemarine.
 */
public class AddTable {
    public static void add(SpaceMarine spaceMarine, Long us) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection dbConnection2= null;
        String sqlStatement = "INSERT INTO spacemarine"
                + "(NAME,X,Y,HEALTH,LOYAL,HEIGHT,CATEGORY,CHAPTERNAME,PARENTLEGION,MARINESCOUNT,DATES,US) " + "VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            dbConnection2 = TableSP.getDBConnection();;
            preparedStatement = dbConnection2.prepareStatement(sqlStatement);
            java.util.Date crDate = spaceMarine.getCreationDate();
            java.sql.Date sqlDate = new java.sql.Date(crDate.getTime());
            preparedStatement.setString(1, spaceMarine.getName());
            preparedStatement.setInt(2, spaceMarine.getCordinatesX());
            preparedStatement.setInt(3, spaceMarine.getCordinatesY());
            preparedStatement.setFloat(4, spaceMarine.getHeight());
            preparedStatement.setString(5,String.valueOf(spaceMarine.getLoyal()));
            preparedStatement.setFloat(6, spaceMarine.getHealth());
            preparedStatement.setString(7,String.valueOf(spaceMarine.getCategory()));
            preparedStatement.setString(8,spaceMarine.getChapter().getName());
            preparedStatement.setString(9,spaceMarine.getChapter().getParentLegion());
            preparedStatement.setInt(10,spaceMarine.getChapter().getMarinesCount());
            preparedStatement.setDate(11, sqlDate);
            preparedStatement.setLong(12,us);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("При регистрации возникла ошибка.");
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection2!= null) {
                dbConnection2.close();
            }
        }
    }
}
