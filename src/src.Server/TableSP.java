import java.sql.*;

/**
 * Класс описывает методы для работы с базой данных
 */
public class TableSP {
    private static String URL = "jdbc:postgresql://pg:5432/studs";//"jdbc:h2:file:C:\\Collection\\Spacemarine";
    private static String Username = "s285660";//root
    private static String Password = "eoq659";//1111
        public static Connection getDBConnection() {
            Connection dbConnection = null;
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try {
                dbConnection = DriverManager.getConnection(URL, Username,Password);
                return dbConnection;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return dbConnection;
        }
        public static void newtable() throws SQLException {
            System.out.println("Создание базы данных клиентов.");
            Connection dbConnection = null;
            Statement statement = null;
            dbConnection = DriverManager.getConnection(URL, Username, Password);
            statement = dbConnection.createStatement();
            String sql = "CREATE TABLE spacemarine " +
                    "(ID SERIAL PRIMARY KEY NOT NULL," +
                    "NAME           TEXT    NOT NULL, " +
                    "X              INT    NOT NULL," +
                    "Y              INT    NOT NULL," +
                    "HEALTH         FLOAT  NOT NULL, " +
                    "LOYAL          TEXT   NOT NULL," +
                    "HEIGHT         FLOAT  NOT NULL, " +
                    "CATEGORY       TEXT   NOT NULL ," +
                    "CHAPTERNAME    TEXT   NOT NULL, " +
                    "PARENTLegion   TEXT   NOT NULL," +
                    "MARINESCount   INT   NOT NULL," +
                    "DATES          DATE ,"+
                    "US             INT)";
            try {
                // выполнить SQL запрос
                statement.execute(sql);
                System.out.println("Table \"spacemarine\" is created!");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
        }
        public static void delettable() throws SQLException {
            Connection dbConnection = null;
            Statement statement = null;
            dbConnection = DriverManager.getConnection(URL, Username,Password);
            statement = dbConnection.createStatement();
            String insertTableSQL = "drop table usertable;";
            statement.executeUpdate(insertTableSQL);
            System.out.println("Таблица успешно удалена");
        }

        public static void delet(Long id) throws SQLException {
            Connection dbConnection = null;
            Statement statement = null;
            dbConnection = DriverManager.getConnection(URL, Username,Password);
            statement = dbConnection.createStatement();
            String sql = "DELETE from spacemarine where ID="+id+";";
            statement.executeUpdate(sql);
            dbConnection.close();
            statement.close();
        }
    }

