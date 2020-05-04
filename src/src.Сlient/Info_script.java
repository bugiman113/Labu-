public class Info_script {
    public void inf() throws InterruptedException {
        System.out.println("Вот краткое инструкция по написанию файла для команды скрипт:");
        System.out.println("После всех команд не нужно ставить пробел,иначе команда не будет выполнена!)");
        Thread.sleep(1000);
        System.out.println("1)Если вы хотите вывести команды о коллекции,а это такие команды как:");
        System.out.println("help,info,show,min_by_creation_date,max_by_coordinates,print_unique_chapter");
        System.out.println("То вам необходимо просто написать название этой команды(самое главное правильно)");
        Thread.sleep(1000);
        System.out.println("2)Если вы хотите воспользоваться такими командами как:");
        System.out.println("remove_greater_key,remove_key");
        System.out.println("То вам необходимо ввести название этой команды,а в следующей строчке ввести число(именно число,иначе возникнет ошибка.)");
        Thread.sleep(1000);
        System.out.println("3)Если вы хотите воспользоваться командой insert_key,то вот шаблон элемента.");
        Thread.sleep(700);
        System.out.println("В 1 строке пишется имя-");
        System.out.println("Во 2 строке пишется координата x(число)-");
        System.out.println("В 3 строке пишется координата у(число)-");
        System.out.println("В 4 строке пишется количество жизней(число)-");
        System.out.println("В 5 строке пишется жив ли ваш герой(true если да, false если нет)-");
        System.out.println("В 6 строке пишется высота героя(число)-");
        System.out.println("В 7 строке пишется к какому ввиду войск относится ваш герой(слово),все ввиды перечислены:\n(1.SCOUT,\" +\n" +
                "                        \"    2.ASSAULT,\" +\n" +
                "                        \"    3.TACTICAL,\" +\n" +
                "                        \"    4.TERMINATOR,\" +\n" +
                "                        \"    5.LIBRARIAN,): \"");
        System.out.println("В 8 строке пишется имя помощница(слово)-");
        System.out.println("В 9 строке пишется икличка помощница(слово)-");
        System.out.println("В 10 строке пишется уровень жизни(число)-");
        Thread.sleep(1000);
        System.out.println("4)Если необходимо воспользоваться командой update_id:");
        System.out.println("То необходимо ввести команду,в следующей строчке число(id элемнта у которого нужно изменить),и затем шаблон из команды insert_key:");
        Thread.sleep(700);
        System.out.println("Вот пример:\n"+"1\n" +
                "Aple" +
                "11\n" +
                "...\n"+
                "123");
        Thread.sleep(1000);
        System.out.println("5)Если вы хотите воспользоваться командой remove_if_lower: ");
        System.out.println("То вам необходимо ввести название командой, в следующей строчке число(ключ), и в следующей строчке число (1 или 2)");
        Thread.sleep(1000);
        System.out.println("6)Если вы хотите воспользоваться командой replace_if_lowe key:");
        System.out.println("То вам необходимо ввести название командой, в следующей строчке число(ключ), в следующей строчке число (1,2,3), и дальше необходимое значение.");
        Thread.sleep(700);
        System.out.println("Пример записи:\n"+"2\n"+"1\n"+"xyz");
        Thread.sleep(1500);
        System.out.println("Обратите внимание что изменять и удалять элменты можно только вами созданные элементы!!!");
        System.out.println("Вот краткое объяснение как делать делать файл для читения из скрипт)");
        System.out.println("Хотелось бы верить что это понятно,но верится с трудом.....");
    }
}
