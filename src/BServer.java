import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BServer {

    static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        // стартуем сервер на порту 3345 и инициализируем переменную для обработки консольных команд с самого сервера
        try (ServerSocket server = new ServerSocket(28553);) {
            System.out.println("Сервер успешно начал работу");
            String filename = "";
            while (true) {
//                try {
//                    for (String str : args) {
//                        filename = filename + str;
//                    Collection.chet(filename);
//                        Collection.zapis();}
//                } catch (Exception e) {
//                    System.out.println("Не удается создать коллекцию из указаного файла.");
//                    System.out.println("Попробуйте зайти ещё раз");
//                    break;
//                }
                filename="tekst.xml";
                Collection.chet(filename);
                       Collection.zapis();
                while (!server.isClosed()) {
                    Thread.sleep(500);
                    Socket client = server.accept();// становимся в ожидание подключения к сокету под именем - "client" на серверной стороне
                    System.out.println("Подключение нового клиента произошло");

                    executeIt.execute(new MonoClient(client));
                    System.out.println("Connection....");
                    Thread.sleep(300);
                }executeIt.shutdown();
            }
            // закрытие пула нитей после завершения работы всех нитей
        } catch (IOException | InterruptedException | JAXBException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}