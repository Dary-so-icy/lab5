package commands;

import exceptions.IllegalParamException;
import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'clear'. Очищает коллекцию
 * @author darya
 */
public class Clear extends Command{
    public Clear(){
        super("clear", "очистить коллекцию");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException{
        if (!args.isBlank()) throw new IllegalParamException("*ничего*");
        CollectionManager.getCollection().clear();
    }
}
