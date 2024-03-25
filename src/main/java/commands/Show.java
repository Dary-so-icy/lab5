package commands;

import collection.LabWork;
import managers.CollectionManager;
import java.util.Set;


public class Show extends Command{
    public Show(){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    @Override
    public void execute(String args) {
        Set<LabWork> collection = CollectionManager.getCollection();
        if (collection.isEmpty()) {
            System.out.println("Коллекция пустая");
            return;
        }
        System.out.println("Элементы коллекции: ");
        for (LabWork s : collection) {
            try {
                System.out.println(s.toString());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

    }
}
