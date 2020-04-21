import java.io.Serializable;
import java.util.Scanner;

public class Insert_key2 implements Serializable {
        public static SpaceMarine Scan2(Scanner scan) {
            try {
                System.out.print("Введите имя: ");
                System.out.println();
                String name = scan.nextLine();
                while (name.equals("")){
                    System.out.println("Вы вели пустое имя,введите имя повторно");
                    name=scan.next();
                }
                System.out.print("Введите координату x: ");
                Integer x = scan.nextInt();
                System.out.print("Введите координату y: ");
                Integer y = scan.nextInt();
                while (y<-463) {
                    System.out.println("Введите новое значение для y  (y>-463)");
                    y=scan.nextInt();}
                System.out.print("Введите количество жизней: ");
                Float fl = scan.nextFloat();
                scan.nextLine();
                while (fl<=0){
                    System.out.println("Количество жизней должно быть положительно(>0),введите число заново");
                    fl = scan.nextFloat();
                }
                System.out.print("Жив ли ваш герой(если герой мертв введите 0,иначе другое натуральное число): ");
                int b = scan.nextInt();
                boolean bool;
                if (b!=0){bool=true;}
                else bool=false;
                scan.nextLine();
                System.out.print("Введите высоту героя: ");
                Float fl2 = scan.nextFloat();
                scan.nextLine();
                System.out.print("Введите к какому ввиду войск относится ваш герой(число)(1.SCOUT," +
                        "    2.ASSAULT," +
                        "    3.TACTICAL," +
                        "    4.TERMINATOR," +
                        "    5.LIBRARIAN,): ");
                Integer in = scan.nextInt();
                while (in>5){
                    System.out.println("число введено неверно,необходимо ввести номер вашего ответа(целое число от 1 до 5):");
                    System.out.println("Введите к какому ввиду войск относится ваш герой(число)(1.SCOUT," +
                            "    2.ASSAULT," +
                            "    3.TACTICAL," +
                            "    4.TERMINATOR," +
                            "    5.LIBRARIAN,): ");
                    in = scan.nextInt();
                }
                AstartesCategory categ = null;
                if (in == 1) {  categ = AstartesCategory.SCOUT; }
                if (in == 2) { categ = AstartesCategory.ASSAULT; }
                if (in == 3) { categ = AstartesCategory.TACTICAL; }
                if (in == 4) { categ = AstartesCategory.TERMINATOR; }
                if (in == 5) { categ = AstartesCategory.LIBRARIAN; }
                AstartesCategory categ1 = categ;
                scan.nextLine();
                System.out.print("Введите имя помощника: ");
                String name2 = scan.nextLine();
                while (name2.equals("")) {
                    System.out.println("Вы вели пустое имя,введите имя повторно");
                    name2 = scan.nextLine();
                }
                System.out.print("Введите его кличку: ");
                String name3 = scan.nextLine();
                while (name3.equals("")) {
                    System.out.println("Вы вели пустое имя,введите имя повторно");
                    name3 = scan.next();
                }
                System.out.print("Введите его уровень жизни: ");
                Integer inter = scan.nextInt();
                while ((inter<=0) || (inter>10000)){
                    System.out.println("Значение должно быть больше 0,но меньше 10000");
                    inter = scan.nextInt();
                }
                scan.nextLine();
                SpaceMarine abc = new SpaceMarine(name, new Coordinates(x, y), fl, bool, fl2, categ1, new Chapter(name2, name3, inter));
                return abc;
            }
            catch (Exception ex) {
                System.out.println("Данные заполнены неверно,в следующий раз будьте аккуратны при заполнении");
            }
            return null;
        }
    }
