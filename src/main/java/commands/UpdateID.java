package commands;

import collection.Models.AskLabWork;
import collection.LabWork;
import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'update_id'. Обновляет значение элемента коллекции, id которого равен заданному
 * @author darya
 */

public class UpdateID extends Command{
    public UpdateID(){
        super("update_id", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) {
        try {
            LabWork lab = CollectionManager.findById(Integer.parseInt(args.trim()));
            if (lab != null) {
                CollectionManager.updateById(new AskLabWork().build(scan, isFile), Integer.parseInt(args.trim()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Введен неверный id. Поле должно быть целым положительным числом!");
        }
    }
}
