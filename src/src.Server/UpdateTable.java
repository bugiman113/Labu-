import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {
    public static void up(SpaceMarine spaceMarine, Long id) throws SQLException {
        Connection dbConnection2 = null;
        dbConnection2 = TableSP.getDBConnection();
        String sql = "UPDATE spacemarine SET NAME=?,X=?,Y=?,HEALTH=?,LOYAL=?,HEIGHT=?,CATEGORY=?,CHAPTERNAME=?,PARENTLEGION=?,MARINESCOUNT=?,DATES=? WHERE ID="+id+";";//
        PreparedStatement preparedStatement = dbConnection2.prepareStatement(sql);
        try {
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
            preparedStatement.execute();
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
