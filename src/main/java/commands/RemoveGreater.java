package commands;

import managers.CollectionManager;

import java.util.Arrays;

public class RemoveGreater extends Command{
    public RemoveGreater(){
        super("remove_greater", "удалить из коллекции все элементы, превышающие заданный");
    }

    @Override
    public void execute(String[] args) {
        try {
            CollectionManager.getCollection().removeIf(s -> s.getId() < Integer.parseInt(Arrays.toString(args)));

        } catch (NumberFormatException e) {
            System.out.println("Формат введеного id неверен");
            System.out.println("The format of the argument is not right, collects an Integer Id");

        }

    }
}
