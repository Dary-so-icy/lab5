package commands;

import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;

import java.io.IOException;

public class Save extends Command{
    public Save(){
        super("save", "сохранить коллекцию в файл");
    }

    @Override
    public void execute(String args) {
        try {
            CollectionManager.saveCollection("5.xml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
