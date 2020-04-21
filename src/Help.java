public class Help {
    public StringBuilder help() {
        StringBuilder builder = new StringBuilder();
        builder.append("Доступные команды:");
        builder.append(System.lineSeparator()+"help : вывести справку по доступным командам");
        builder.append(System.lineSeparator()+"info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов");
        builder.append(System.lineSeparator()+"show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        builder.append(System.lineSeparator()+"insert_key {element} : добавить новый элемент с заданным ключом");
        builder.append(System.lineSeparator()+"update_id {element} : обновить значение элемента коллекции, id которого равен заданному");
        builder.append(System.lineSeparator()+"remove_key key : удалить элемент из коллекции по его ключу");
        builder.append(System.lineSeparator()+"clear : очистить коллекцию");
        builder.append(System.lineSeparator()+"execute_script (file_name) : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        builder.append(System.lineSeparator()+"exit : завершить программу (с сохранением в файл)");
        builder.append(System.lineSeparator()+"remove_if_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
        builder.append(System.lineSeparator()+"replace_if_lowe key {element} : заменить значение по ключу, если новое значение меньше старого");
        builder.append(System.lineSeparator()+"remove_greater_key key : удалить из коллекции все элементы, ключ которых превышает заданный");
        builder.append(System.lineSeparator()+"min_by_creation_date : вывести любой объект из коллекции, значение поля creationDate которого является минимальным");
        builder.append(System.lineSeparator()+"max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным");
        builder.append(System.lineSeparator()+"print_unique_chapter chapter : вывести уникальные значения поля chapter");
        return builder;
    }
}
