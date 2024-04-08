package commands;

import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'filter_starts_with_name'. Выводит элементы, значение поля name которых начинается с заданной подстроки
 * @author darya
 */
public class FilterStartsWithName extends Command{
    public FilterStartsWithName(){
        super("filter_starts_with_name", "вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) {
        CollectionManager.getCollection().stream()
                .filter(sp -> sp.getName().startsWith(args.trim()))
                .forEach(System.out::println);

    }
}
