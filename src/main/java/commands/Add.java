package commands;

import collection.AskForms.AskLabWork;
import collection.LabWork;
import managers.CollectionManager;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Add extends Command{
    public Add(){
        super("add", "добавить новый элемент в коллекцию");
    }

    @Override
    public void execute(String[] args) {
        AskLabWork newLab = new AskLabWork();
        try {
            LabWork buildedLab = newLab.build();
            if (!CollectionManager.getCollection().contains(buildedLab)){
                CollectionManager.getCollection().add(buildedLab);
                HashSet<LabWork> sortedHashSet = CollectionManager.getCollection().stream()
                        .sorted()
                        //.collect();//Collectors.toCollection()); //?
                System.out.println("Элемент добавлен в коллекцию!");
            }
            else {
                System.out.println("Такой элемент уже есть в коллекции.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
