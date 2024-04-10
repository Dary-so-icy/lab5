package commands;

import collection.Models.AskLabWork;
import collection.LabWork;
import exceptions.IllegalParamException;
import exceptions.NoSuchIdException;
import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'update_id'. Обновляет значение элемента коллекции, id которого равен заданному
 *
 * @author darya
 */

public class UpdateID extends Command {
    public UpdateID() {
        super("update_id", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException, NoSuchIdException {
        try {
            LabWork lab = CollectionManager.findById(Integer.parseInt(args.trim()));
            if (lab != null) {
                CollectionManager.updateById(new AskLabWork().build(scan, isFile), Integer.parseInt(args.trim()));
            } else {
                throw new NoSuchIdException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalParamException("int");
        }
    }
}
