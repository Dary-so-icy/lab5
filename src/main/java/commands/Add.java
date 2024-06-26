package commands;

import collection.Models.AskLabWork;
import collection.LabWork;
import exceptions.IllegalParamException;
import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 * @author darya
 */
public class Add extends Command{
    public Add(){
        super("add", "добавить новый элемент в коллекцию");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException {
        if (!args.isBlank()) throw new IllegalParamException("*ничего*");
        try {
            System.out.println("Создание объекта LabWork");
            LabWork lab0 = new AskLabWork().build(scan, isFile);
            CollectionManager.addElement(lab0);
            System.out.println("Создание объекта LabWork окончено успешно!");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
