package commands;

import managers.CollectionManager;

import java.util.Arrays;

public class FilterStartsWithName extends Command{
    public FilterStartsWithName(){
        super("filter_starts_with_name", "вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public void execute(String[] args) {
        CollectionManager.getCollection().stream()
                .filter(sp -> sp.getName().startsWith(Arrays.toString(args)))
                .forEach(System.out::println);

    }
}
