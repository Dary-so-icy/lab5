package commands;

import collection.LabWork;
import exceptions.IllegalParamException;
import managers.CollectionManager;

import java.util.Scanner;
import java.util.Set;

/**
 * Команда 'show'. Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 * @author darya
 */
public class Show extends Command{
    public Show(){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException {
        if (!args.isBlank()) throw new IllegalParamException("*ничего*");
        Set<LabWork> collection = CollectionManager.getCollection();
        if (collection.isEmpty()) {
            System.out.println("Коллекция пустая");
            return;
        }
        System.out.println("Элементы коллекции: ");
        for (LabWork s : collection) {
            try {
                System.out.println(s.toString());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

    }
}
