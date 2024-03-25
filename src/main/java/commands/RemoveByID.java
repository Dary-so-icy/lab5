package commands;

import managers.CollectionManager;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveByID extends Command{
    public RemoveByID(){
        super("remove_by_id", "удалить элемент из коллекции по его id");
    }

    @Override
    public void execute(String args) {

        try {
            int id = Integer.parseInt(args.trim());
            CollectionManager.removeById(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Формат введенного id неверен. Введите целое число!");
        }
    }
}
