package commands;

import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'info'. Выводит в стандартный поток вывода информацию о коллекции
 * @author darya
 */
public class Info extends Command {
    public Info() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пока что пуста. Тип коллекции: " + CollectionManager.getCollection().getClass());
        }
        else {
            System.out.println("Тип коллекции: " + CollectionManager.getCollection().getClass());
            System.out.println("Количество элементов: " + CollectionManager.getCollection().size());
            System.out.println("Дата инициализации: " + CollectionManager.initializationTime);
        }
    }
}
