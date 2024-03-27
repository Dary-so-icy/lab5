package commands;

import collection.Models.AskLabWork;
import collection.LabWork;
import exceptions.CommandRuntimeError;
import managers.CollectionManager;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 * @author darya
 */
public class Add extends Command{
    public Add(){
        super("add", "добавить новый элемент в коллекцию");
    }

    @Override
    public void execute(String args) throws CommandRuntimeError {
        AskLabWork newLab = new AskLabWork();
        if (args != null) throw new CommandRuntimeError();
        try {
            System.out.println("Создание объекта LabWork");
            LabWork lab0 = new AskLabWork().build();
            CollectionManager.addElement(lab0);
            System.out.println("Создание объекта LabWork окончено успешно!");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
