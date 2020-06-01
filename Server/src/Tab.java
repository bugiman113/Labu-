import java.sql.SQLException;

/**
 * Данный класс использовался для создания или удаления баз данных
 */
public class Tab {
    public static void main() throws SQLException {
        TableSP.newtable();
        UserTab.newtable();
        //UserTab.delettable();
        //TableSP.delettable();
    }
}
