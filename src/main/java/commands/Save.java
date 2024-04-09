package commands;

import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'save'. Сохраняет коллекцию в файл
 * @author darya
 */
public class Save extends Command{
    public Save(){
        super("save", "сохранить коллекцию в файл");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) {
        try {
            System.out.println("CHANGE DIRECTORY");
            CollectionManager.saveCollection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
