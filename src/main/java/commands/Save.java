package commands;

import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;

public class Save extends Command{
    public Save(){
        super("update_id", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String[] args) {
        try {
            CollectionManager.saveCollection();
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }
}
