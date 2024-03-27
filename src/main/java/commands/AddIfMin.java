package commands;

import collection.Models.AskLabWork;
import collection.LabWork;
import exceptions.CommandRuntimeError;
import managers.CollectionManager;
import managers.StandartConsole;
import java.util.Objects;

/**
 * Команда 'add_if_min'. Добавляет новый элемент коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 * @author darya
 */
public class AddIfMin extends Command{
    public AddIfMin(){
        super("add_if_min", "добавить новый элемент коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }

    @Override
    public void execute(String args) throws CommandRuntimeError {
        StandartConsole console = new StandartConsole();
        if (!args.isBlank()) throw new CommandRuntimeError();
        try {
            console.println("Создание объекта LabWork");
            LabWork newElement = new AskLabWork().build();
            console.println("Создание объекта LabWork окончено успешно!");
            if (newElement.compareTo(Objects.requireNonNull(CollectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    .min(LabWork::compareTo)
                    .orElse(null))) <= 0){
                CollectionManager.addElement(newElement);
                console.println("Объект успешно добавлен");
            } else {
                console.println("Элемент больше минимального! Невозможно добавить(");
            }
        } catch (Exception invalidForm) {
            console.printError("Поля объекта не валидны! Объект не создан!");
        }

}
}
