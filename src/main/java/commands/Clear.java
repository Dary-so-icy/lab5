package commands;

import managers.CollectionManager;
/**
 * Команда 'clear'. Очищает коллекцию
 * @author darya
 */
public class Clear extends Command{
    public Clear(){
        super("clear", "очистить коллекцию");
    }

    @Override
    public void execute(String args) {
        CollectionManager.getCollection().clear();
    }
}
