public class Help {
    public String help() {
        StringBuilder builder = new StringBuilder();
        builder.append("Доступные команды:");
        builder.append("help : вывести справку по доступным командам!");
        builder.append("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов!");
        builder.append("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении!");
        builder.append("insert_key {element} : добавить новый элемент с заданным ключом!");
        builder.append("update_id {element} : обновить значение элемента коллекции, id которого равен заданному!");
        builder.append("remove_key key : удалить элемент из коллекции по его ключу!");
        builder.append("clear : очистить коллекцию!");
        builder.append("execute_script (file_name) : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме!");
        builder.append("exit : завершить программу (с сохранением в файл)");
        builder.append("remove_if_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный!");
        builder.append("replace_if_lowe key {element} : заменить значение по ключу, если новое значение меньше старого!");
        builder.append("remove_greater_key key : удалить из коллекции все элементы, ключ которых превышает заданный!");
        builder.append("min_by_creation_date : вывести любой объект из коллекции, значение поля creationDate которого является минимальным!");
        builder.append("max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным!");
        builder.append("print_unique_chapter chapter : вывести уникальные значения поля chapter!");
        return builder.toString();
    }
}
