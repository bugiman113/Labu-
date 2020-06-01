import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class BServer {
    static ExecutorService service = Executors.newFixedThreadPool(5);
    public static void main(String[] args) {
        // стартуем сервер на порту 3345 и инициализируем переменную для обработки консольных команд с самого сервера
        try (ServerSocket server = new ServerSocket(28571);) {
            System.out.println("Сервер успешно начал работу");
            while (true) {
                while (!server.isClosed()) {
                    Socket client = server.accept();// становимся в ожидание подключения к сокету под именем - "client" на серверной стороне
                            service.execute(new MonoClient(client));
                    System.out.println("Connection....");
                    Thread.sleep(300);
                }service.shutdown(); }
            // закрытие пула нитей после завершения работы всех нитей
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}