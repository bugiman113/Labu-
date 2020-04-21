import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InterruptedException, IOException {
        try(Socket socket = new Socket("localhost", 28553);// запускаем подключение сокета
            //для того чтобы можно было что-то туда послать
            ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
            )
        {BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client успешно начал работать");
            while(!socket.isOutputShutdown()|| br.ready()) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Для отключения от сервера введите exit.");
                    System.out.println("Введите название файла из которого будет создана коллекция");
                    System.out.println("Вы начали рабоать с коллекцией Spacemarine");
                    System.out.println("Введите одну из команд(для того чтобы увидеть список всех команд введите help)");
                    Thread.sleep(1000);
                    Comand colCommand = null;
                    ObjectInputStream inn = new ObjectInputStream(socket.getInputStream());
                    Scanner commandReader = new Scanner(System.in);
                    String userCommand = "";
                    while (!userCommand.equals("exit")) {
                        userCommand = commandReader.nextLine();
                        Comand comand = null;
                        switch (userCommand) {
                            case ("info"):
                                comand = Comand.info;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object inf = inn.readObject();
                                System.out.println(inf);
                                break;
                            case "info_script":
                                new Info_script().inf();
                                break;
                            case ("remove_key"):
                                comand = Comand.remove_key;
                                System.out.println("Введите значение ключа");
                                Scanner com = new Scanner(System.in);
                                try {
                                    long k = com.nextLong();
                                    outToClient.writeObject(new AComands(comand, k).getComand());
                                    outToClient.flush();
                                    outToClient.writeObject(new AComands(comand, k).getL());
                                    outToClient.flush();
                                    Object rem = inn.readObject();
                                    System.out.println(rem);
                                } catch (RuntimeException e) {
                                    System.out.println("Данные ведены неверно(вам требуется ввести число).");
                                    System.out.println("Выполнение команда прервано.");
                                }
                                break;
                            case ("remove_greater_key"):
                                comand = Comand.remove_greater;
                                System.out.println("Введите значение ключа");
                                Scanner com4 = new Scanner(System.in);
                                try {
                                    long kk = com4.nextLong();
                                    outToClient.writeObject(new AComands(comand, kk).getComand());
                                    outToClient.flush();
                                    outToClient.writeObject(new AComands(comand, kk).getL());
                                    outToClient.flush();
                                    Object reml = inn.readObject();
                                    System.out.println(reml);
                                } catch (RuntimeException e) {
                                    System.out.println("Данные ведены неверно(вам требуется ввести число).");
                                    System.out.println("Выполнение команда прервано.");
                                }
                                break;
                            case "replace_if_lowe":
                                comand = Comand.replace_if_lowe;
                                Scanner comp = new Scanner(System.in);
                                try {
                                    System.out.println("Введите значение ключа");
                                    outToClient.writeObject(new AComands(comand).getComand());
                                    long ke = comp.nextLong();
                                    outToClient.writeObject(new AComands(comand, ke).getL());
                                    outToClient.flush();
                                    System.out.println("Введите что вы хотите изменить:1-Имя;2-кординаты;3-количесвто жизней");
                                    int anInt = comp.nextInt();
                                    while (anInt != 1 && anInt != 2 && anInt != 3) {
                                        System.out.println("Вы ввели неверное значение");
                                        System.out.println("Введите что вы хотите изменить:1-Имя;2-кординаты;3-количесвто жизней");
                                        anInt = comp.nextInt();
                                    }
                                    outToClient.writeObject(new AComands(comand, anInt).getI());
                                    if (anInt == 1) {
                                        System.out.println("Введите новое имя");
                                        String name2 = comp.next();
                                        outToClient.writeObject(new AComands(comand, name2).getString());
                                    }
                                    if (anInt == 2) {
                                        System.out.println("Введите новые координаты:");
                                        System.out.println("x:");
                                        int x2 = comp.nextInt();
                                        outToClient.writeObject(new AComands(comand, x2).getI());
                                        System.out.println("y:");
                                        int y2 = comp.nextInt();
                                        outToClient.writeObject(new AComands(comand, y2).getI());
                                    }
                                    if ((anInt == 3)) {
                                        System.out.println("Введите новое количество жизней:");
                                        Float hel = comp.nextFloat();
                                        outToClient.writeObject(new AComands(comand, hel).getParam());
                                    }
                                    outToClient.writeObject(new AComands(comand, anInt).getI());
                                    outToClient.flush();
                                    Object repl = inn.readObject();
                                    System.out.println(repl);
                                } catch (RuntimeException e) {
                                    System.out.println("Данные ведены неверно(вам требуется ввести число).");
                                    System.out.println("Выполнение команда прервано.");
                                }
                                break;
                            case "remove_if_lower":
                                comand = Comand.remove_lower;
                                Scanner com3 = new Scanner(System.in);
                                try {
                                    System.out.println("Введите значение ключа");
                                    long l = com3.nextLong();
                                    outToClient.writeObject(new AComands(comand, l).getComand());
                                    outToClient.flush();
                                    outToClient.writeObject(new AComands(comand, l).getL());
                                    outToClient.flush();
                                    System.out.println("Введите по какому параметру сравнивать:1-Имя;2-кординаты");
                                    int i = com3.nextInt();
                                    while (i > 2 || i < 0) {
                                        System.out.println("Вы вели неверное значение(значение i должно быть число 1 или 2)");
                                        i = com3.nextInt();
                                    }
                                    outToClient.writeObject(new AComands(comand, l, i).getI());
                                    outToClient.flush();
                                    Object remg = inn.readObject();
                                    System.out.println(remg);
                                } catch (RuntimeException e) {
                                    System.out.println("Данные ведены неверно(вам требуется ввести число).");
                                    System.out.println("Выполнение команда прервано.");
                                }
                                break;
                            case ("help"):
                                comand = Comand.help;
                                outToClient.writeObject(new AComands(comand).getComand());
                                outToClient.flush();
                                Object hl = inn.readObject();
                                System.out.println(hl);
                                break;
                            case ("show"):
                                comand = Comand.show;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Thread.sleep(500);
                                Object sh = inn.readObject();
                                System.out.println(sh);
                                break;
                            case ("insert_key"):
                                comand = Comand.insert_key;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Thread.sleep(500);
                                outToClient.writeObject(Insert_key2.Scan2(scan));
                                System.out.println("Элемент успешно добавлен введит show для проверки");
                                break;
                            case "update_id":
                                comand = Comand.update_id;
                                Thread.sleep(500);
                                System.out.println("Введите значение ключа");
                                Scanner com2 = new Scanner(System.in);
                                try {
                                    long l1 = com2.nextLong();
                                    outToClient.writeObject(comand);
                                    outToClient.flush();
                                    outToClient.writeObject(new AComands(comand, l1).getL());
                                    outToClient.flush();
                                    outToClient.writeObject(Insert_key2.Scan2(scan));
                                    outToClient.flush();
                                    Object up = inn.readObject();
                                    System.out.println(up);
                                } catch (RuntimeException e) {
                                    System.out.println("Данные ведены неверно(вам требуется ввести число).");
                                    System.out.println("Выполнение команда прервано.");
                                }
                                break;
                            case ("print_unique_chapter"):
                                comand = Comand.print;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object pr = inn.readObject();
                                System.out.println(pr);
                                break;
                            case ("max_by_coordinates"):
                                comand = Comand.MaxCord;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object maxcord = inn.readObject();
                                System.out.println(maxcord);
                                break;
                            case ("min_by_creation_date"):
                                comand = Comand.mindate;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object min = inn.readObject();
                                System.out.println(min);
                                break;
                            case ("clear"):
                                comand = Comand.clear;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object cl = inn.readObject();
                                System.out.println(cl);
                                System.out.println("Для того чтобы заполнить коллекцию базовыми данными введите команду start");
                                break;
                            case "start":
                                comand = Comand.start;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                Object st = inn.readObject();
                                System.out.println(st);
                                break;
                            case "execute_script":
                                comand = Comand.script;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                System.out.println("Введите навзванеи файла из которого должны считываться данные");
                                String file = scan.nextLine();
                                AComands sc = new AComands(comand, file);
                                outToClient.writeObject(sc.getString());
                                Object sc2 = inn.readObject();
                                System.out.println(sc2);
                                break;
                            case ("exit"):
                                comand = Comand.exit;
                                outToClient.writeObject(comand);
                                outToClient.flush();
                                socket.close();
                                br.close();
                                inn.close();
                                outToClient.close();
                                break;
                            default:
                                System.out.println("Неопознанная команда. Наберите 'help' для того чтобы увидеть перечень команд");
                        }
                    }
                    break;
            }
            System.out.println("Отсоединение произошло успешно");
            System.out.println("До новых встреч!");
        } catch (Exception e ) {
            System.out.println("Сервер работает некорректно");
            System.out.println("Повторите попытку подключения попозднее");
        }
    }
}

