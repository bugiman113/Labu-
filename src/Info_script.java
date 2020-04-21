public class Info_script {
    public void inf() throws InterruptedException {
        System.out.println("Вот краткое инструкция по написанию файла для команды скрипт:");
        System.out.println("После всех команд не нужно ставить пробел,иначе команда не работает!)");
        Thread.sleep(1000);
        System.out.println("1)Если вы хотите вывести команды о коллекции,а это такие команды как:");
        System.out.println("help,info,show,min_by_creation_date,max_by_coordinates,print_unique_chapter");
        System.out.println("То вам необходимо просто написать название этой команды(самое главное правильно)");
        Thread.sleep(1000);
        System.out.println("2)Если вы хотите воспользоваться такими командами как:");
        System.out.println("remove_greater_key,remove_key");
        System.out.println("То вам необходимо ввести название этой команды,а в следующей строчке ввести число(именно число,иначе возникнет ошибка.)");
        Thread.sleep(1000);
        System.out.println("3)Если вы хотите воспользоваться командой insert_key,то вот шаблон элемента(скопируйте шаблон и замените *** на необходимые значение)");
        Thread.sleep(700);
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + "<lists>\n" +
                "    <spaceMarineList>\n" +
                "        <name>***</name>\n" +
                "        <id>***</id>\n" +
                "        <coordinates>\n" +
                "            <x>***</x>\n" +
                "            <y>***</y>\n" +
                "        </coordinates>\n" +
                "        <creationDate>2020-03-26T16:01:53.362+03:00</creationDate>\n" +
                "        <health>***</health>\n" +
                "        <loyal>***</loyal>\n" +
                "        <height>***</height>\n" +
                "        <category>***</category>\n" +
                "        <chapter>\n" +
                "            <name>***</name>\n" +
                "            <parentLegion>***</parentLegion>\n" +
                "            <marinesCount>***</marinesCount>\n" +
                "        </chapter>\n" +
                "    </spaceMarineList>\n" + "</lists>");
        Thread.sleep(1000);
        System.out.println("4)Если необходимо воспользоваться командой update_id:");
        System.out.println("То необходимо ввести команду,в следующей строчке число(id элемнта у которого нужно изменить),и затем шаблон из коианды insert_key:");
        Thread.sleep(700);
        System.out.println("Вот пример:\n"+"1\n" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<lists>\n" +
                "...\n"+
                "</lists>");
        Thread.sleep(1000);
        System.out.println("5)Если вы хотите воспользоваться командой remove_if_lower: ");
        System.out.println("То вам необходимо ввести название командой, в следующей строчке число(ключ), и в следующей строчке число (1 или 2)");
        Thread.sleep(1000);
        System.out.println("6)Если вы хотите воспользоваться командой replace_if_lowe key:");
        System.out.println("То вам необходимо ввести название командой, в следующей строчке число(ключ), в следующей строчке число (1,2,3), и дальше необходимое значение.");
        Thread.sleep(700);
        System.out.println("Пример записи:\n"+"2\n"+"1\n"+"xyz");
        Thread.sleep(1500);
        System.out.println("Вот краткое объяснение как делать делать файл для читения из скрипт)");
        System.out.println("Хотелось бы верить что это понятно,но верится с трудом.....");
    }
}
