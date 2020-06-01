import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 * Класс описывает создание базы данных пользователей.
 * метод encryptThisString производит хэширование паролей.
 */
public class UserTab {
    //private static String URL = "jdbc:h2:file:C:\\Collection\\Spacemarine";
    //private static String Username = "root";
    //private static String Password = "1111";
    private static String URL = "jdbc:postgresql://pg:5432/studs";
    private static String Username = "s285660";
    private static String Password = "eoq659";
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
        dbConnection = DriverManager.getConnection(URL, Username,Password);
        statement = dbConnection.createStatement();
        String sql = "CREATE TABLE usertable " +
                "(ID SERIAL PRIMARY KEY NOT NULL," +
                "NAME           TEXT    NOT NULL, " +
                "PASSWORD        TEXT    NOT NULL," +
                "COLOR           INT     NOT NULL)";
        try {


            // выполнить SQL запрос
            statement.execute(sql);
            System.out.println("Table \"dbuser\" is created!");
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
    public static void uptable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        dbConnection = DriverManager.getConnection(URL, Username,Password);
        statement = dbConnection.createStatement();
        try {

            String insertTableSQL = "INSERT INTO usertable"
                    + "(NAME,PASSWORD) " + "VALUES"
                    + "('BBBB','22')";
            statement.executeUpdate(insertTableSQL);

            System.out.println("Элемент успешно добавлен");
        }catch (Exception e)
        {System.out.println("Элемент не может быть добавлен так как элемент с таким ID уже сущесвтует");}
    }
    public static void adduser(String username1,String password1,int color) throws SQLException {
            PreparedStatement preparedStatement = null;
            Connection dbConnection2= null;
            String answer ="";
            String sqlStatement = "INSERT INTO usertable (NAME,PASSWORD,COLOR) VALUES (?,?,?);";
            String password2 = UserTab.encryptThisString(password1);
            try {
                dbConnection2 = getDBConnection();;
                preparedStatement = dbConnection2.prepareStatement(sqlStatement);
                preparedStatement.setString(1,username1);
                preparedStatement.setString(2,password2);
                preparedStatement.setInt(3,color);
                preparedStatement.executeUpdate();
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
    public static String encryptThisString(String input) {
        try {
            // метод getInstance () вызывается с алгоритмом MD2
            MessageDigest md = MessageDigest.getInstance("MD2");
            // вызывается метод digest ()
            // вычислить дайджест сообщения из входной строки возвращается как массив байтов
            byte[] messageDigest = md.digest(input.getBytes());
            // Преобразование байтового массива в представление знака
            BigInteger no = new BigInteger(1, messageDigest);
            // Преобразуем дайджест сообщения в шестнадцатеричное значение
            String hashtext = no.toString(16);
            // Добавить предыдущие 0, чтобы сделать его 32-битным
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
