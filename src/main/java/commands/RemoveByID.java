package commands;

import exceptions.IllegalParamException;
import managers.CollectionManager;
import java.util.Scanner;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции по его id
 * @author darya
 */
public class RemoveByID extends Command{
    public RemoveByID(){
        super("remove_by_id", "удалить элемент из коллекции по его id");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException{

        try {
            int id = Integer.parseInt(args.trim());
            CollectionManager.removeById(id);
        } catch (NumberFormatException e) {
            throw new IllegalParamException("int");
        }
    }
}
