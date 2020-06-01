import javax.xml.bind.JAXBException;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Script {
    StringBuilder builder = new StringBuilder();
    Scanner scan = new Scanner(System.in);
    private ArrayList<Integer> history = new ArrayList<Integer>();
    private int h = 0;

    public StringBuilder script(String filik,long us,int color) throws JAXBException {
        ForkJoinPool pool = new ForkJoinPool(MonoClient.numpool);
        int sk = 0;
        int c = 0;
        ArrayList<String> list = new ArrayList<String>();
        h++;
        history.add(h);
        if (history.size() < 8) {
            try {
                FileReader fr = new FileReader(filik);
                Scanner ois = new Scanner(fr);
                String k = "";
                int i = 0;
                builder.append("Вызвана команда скрипт");
                while (ois.hasNextLine() ) {
                    try {
                        k = ois.nextLine();
                        switch (k) {
                            case "info":
                                builder.append(System.lineSeparator() + "Сработала команда info" + System.lineSeparator());
                                String inf = new Info().inf();
                                builder.append(pool.invoke(new MonoClient.MyFork(0,inf)));
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "help":
                                builder.append(System.lineSeparator() + "Сработала команда help" + System.lineSeparator());
                                String h = new Help().help();
                                builder.append(pool.invoke(new MonoClient.MyFork(0,h)));
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "insert_key":
                                sk = i;
                                builder.append(System.lineSeparator() + "Сработала команда inset_key");
                                insert_key3(scan, filik, sk,us,color);
                                builder.append(System.lineSeparator() + "Команда выполнена+для проверки введите команду show" + System.lineSeparator());
                                i = i +10;
                                i++;
                                break;
                            case "show":
                                builder.append(System.lineSeparator() + "Сработала команда  show" + System.lineSeparator());
                                String s =new Show().show();
                                builder.append(pool.invoke(new MonoClient.MyFork(0,s)));
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "print_unique_chapter":
                                builder.append(System.lineSeparator() + "Сработала команда print_unique_chapter " + System.lineSeparator());
                                builder.append(new Print().print());
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "remove_lower":
                                builder.append(System.lineSeparator() + "Сработала команда remove_lower " + System.lineSeparator());
                                builder.append(new Remove_lower().remove1sc(scan, new File(filik), i,us));
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "remove_greater_key":
                                builder.append(System.lineSeparator() + "Сработала команда remove_greater_key " + System.lineSeparator());
                                builder.append(new Remove_greater().remove2sc(scan, new File(filik), i,us));
                                builder.append(System.lineSeparator() + "Команда выполнена");
                                i++;
                                break;
                            case "max_by_coordinates":
                                builder.append(System.lineSeparator() + "Сработала команда max_by_coordinates " + System.lineSeparator());
                                builder.append(new MaxCord().Max_by_coordinates());
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "update_id":
                                builder.append(System.lineSeparator() + "Сработала команда update_id " + System.lineSeparator());
                                int p =insert_key4(scan, filik, i,us,color);
                                if (p==1){ builder.append("Команда выполнена" + System.lineSeparator());}
                                else {builder.append("Команда не выолнена,так как элемент с данным ключом принадлежит не вам или ключ указан неверно.");}
                                i = i + 11;
                                i++;
                                break;
                            case "min_by_creation_date":
                                builder.append(System.lineSeparator() + "Сработала команда min_by_creation_date " + System.lineSeparator());
                                builder.append(new MinDate().Min_date());
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i++;
                                break;
                            case "remove_key":
                                builder.append(System.lineSeparator() + "Сработала команда remove_key ");
                                new Remove_key().remove1sc(scan, new File(filik), i,us);
                                i = i + 2;
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                break;
                            case "replace_if_lowe":
                                builder.append(System.lineSeparator() + "Сработала команда replace_if_lowe " + System.lineSeparator());
                                builder.append(new Remove_lower().remove1sc(scan, new File(filik), i,us));
                                builder.append(System.lineSeparator() + "Команда выполнена" + System.lineSeparator());
                                i = i + 3;
                                break;
                            case "script":
                                builder.append(System.lineSeparator() + "Повторно вызвана команда скрипт" + System.lineSeparator());
                                String fil = filik;
                                script(fil,us,color);
                                i++;
                                break;
                        }
                    } catch (RuntimeException e) {
                    builder.append(System.lineSeparator() + "При выполнении команды возникла ошибка");
                    builder.append(System.lineSeparator() + "Проверьте правильно вы вели данные в скрипте");
                    builder.append(System.lineSeparator()+"Для того чтобы проверить правильно вы вели данные воспользуетесь командой info_script");
                    break;
                } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                return builder;
            } catch (IOException e) {
                builder.append(System.lineSeparator()+"Невозможно считать данные,проверьте файл и воспользуйтесь снова командой script.");
                builder.append(System.lineSeparator()+"Выполнение команды script завершено.");
            }
        } else builder.append("script не может вызываться больше чем 7 раз");
        return builder.append("Произошел сбой при чтении файлов");
    }

    public void insert_key3(Scanner scan, String filik, int sk,Long us,int color) throws FileNotFoundException, JAXBException, SQLException {
        int ik = 1;
        int skk = sk;
        Scanner scanner = new Scanner(new File(filik));
        String date = new String();
            while (ik <= sk + 1) {
                scanner.nextLine();
                ik++;
            }
        String name1 = scanner.nextLine();
            String name = name1.trim();
        Integer x = scanner.nextInt();
        Integer y = scanner.nextInt();
        scanner.nextLine();
        String s1 = scanner.nextLine();
        float fl = Float.parseFloat(s1.trim());
        String b = scanner.nextLine();
        boolean bool;
        if ((b.trim()).equals("true")){bool=true;}
        else bool=false;
        String s2 = scanner.nextLine();
        float fl2 = Float.parseFloat(s2);
        String in1 = scanner.nextLine();
        String in = in1.trim();
        AstartesCategory categ = null;
        if (in.equals("SCOUT")) {  categ = AstartesCategory.SCOUT; }
        if (in.equals("ASSAULT")) { categ = AstartesCategory.ASSAULT; }
        if (in.equals("TACTICAL")) { categ = AstartesCategory.TACTICAL; }
        if (in.equals("TERMINATOR")) { categ = AstartesCategory.TERMINATOR; }
        if (in.equals("LIBRARIAN")) { categ = AstartesCategory.LIBRARIAN; }
        AstartesCategory categ1 = categ;
        String name2 = scanner.nextLine();
        String name3 = scanner.nextLine();
        Integer inter = scanner.nextInt();
        SpaceMarine abc = new SpaceMarine(name, new Coordinates(x, y), fl, bool, fl2, categ1, new Chapter(name2.trim(), name3.trim(), inter),color);
        AddTable.add(abc,us);
    }

    public int insert_key4(Scanner scan, String filik, int sk, long us,int color) throws FileNotFoundException, JAXBException, SQLException {
        int ik = 1;
        int skk = sk;
        Scanner scanner = new Scanner(new File(filik));
        String date = new String();
            while (ik < sk + 2) {
                scanner.nextLine();
                ik++;
            }
            long keys = scanner.nextLong();
            if (Collection.marineMap.get(keys).getUs()==us){
        String name1 = scanner.nextLine();
        String name = name1.trim();
        Integer x = scanner.nextInt();
        Integer y = scanner.nextInt();
        scanner.nextLine();
        String s1 = scanner.nextLine();
        float fl = Float.parseFloat(s1.trim());
        String b = scanner.nextLine();
        boolean bool;
        if ((b.trim()).equals("true")){bool=true;}
        else bool=false;
        String s2 = scanner.nextLine();
        float fl2 = Float.parseFloat(s2);
        String in1 = scanner.nextLine();
        String in = in1.trim();
        AstartesCategory categ = null;
        if (in.equals("SCOUT")) {  categ = AstartesCategory.SCOUT; }
        if (in.equals("ASSAULT")) { categ = AstartesCategory.ASSAULT; }
        if (in.equals("TACTICAL")) { categ = AstartesCategory.TACTICAL; }
        if (in.equals("TERMINATOR")) { categ = AstartesCategory.TERMINATOR; }
        if (in.equals("LIBRARIAN")) { categ = AstartesCategory.LIBRARIAN; }
        AstartesCategory categ1 = categ;
        String name2 = scanner.nextLine();
        String name3 = scanner.nextLine();
        Integer inter = scanner.nextInt();
        SpaceMarine abc = new SpaceMarine(name, new Coordinates(x, y), fl, bool, fl2, categ1, new Chapter(name2.trim(), name3.trim(), inter),color);
        AddTable.add(abc,us);
            return 1;}
            else {return 0;}
    }
}