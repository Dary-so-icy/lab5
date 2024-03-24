package commands;

import managers.CollectionManager;

import java.util.Arrays;

public class RemoveByID extends Command{
    public RemoveByID(){
        super("remove_by_id", "удалить элемент из коллекции по его id");
    }

    @Override
    public void execute(String[] args) {
        try {
            System.out.println();
            CollectionManager.removeById(Integer.parseInt(Arrays.toString(args)));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Формат введенного id неверен. Введите целое число!");
        }
    }
}
