package commands;

import collection.LabWork;
import collection.Models.AskLabWork;
import exceptions.IllegalParamException;
import managers.CollectionManager;
import managers.StandartConsole;
import java.util.Collection;
import java.util.Scanner;
/**
 * Команда 'remove_greater'. Удаляет элементы из коллекции, превосходящие данный
 *
 * @author darya
 */
public class RemoveGreater extends Command{
    public RemoveGreater(){
        super("remove_greater", "удалить из коллекции все элементы, превышающие заданный");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException{
        StandartConsole console = new StandartConsole();
        if (!args.isBlank()) throw new IllegalParamException("*ничего*");
        try {
            LabWork newElement = new AskLabWork().build(scan, isFile);
            console.println("Создание заданного объекта для сравнения LabWork окончено успешно!");
            Collection<LabWork> toRemove = null;
            for (LabWork el : CollectionManager.getCollection()){
                if (newElement.compareTo(el) < 0){
                    toRemove.add(el);
                }
            }

            CollectionManager.removeElements(toRemove);
            console.println("Объекты успешно удалены");

        } catch (NumberFormatException e) {
            throw new IllegalParamException("int");

        }

    }
}
