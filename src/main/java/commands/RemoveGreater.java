package commands;

import collection.LabWork;
import collection.Models.AskLabWork;
import managers.CollectionManager;
import managers.StandartConsole;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class RemoveGreater extends Command{
    public RemoveGreater(){
        super("remove_greater", "удалить из коллекции все элементы, превышающие заданный");
    }

    @Override
    public void execute(String args) {
        StandartConsole console = new StandartConsole();
        //if (!args.isBlank()) throw new IllegalArguments();
        try {
            LabWork newElement = new AskLabWork().build();
            console.println("Создание заданного объекта LabWork окончено успешно!");
            Collection<LabWork> toRemove = CollectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    //.filter(LabWork-> collection.LabWork)
                    .toList();
            CollectionManager.removeElements(toRemove);
            console.println("Объекты успешно удалены");

        } catch (NumberFormatException e) {
            System.out.println("Формат введеного id неверен");
            System.out.println("The format of the argument is not right, collects an Integer Id");

        }

    }
}
