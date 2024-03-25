package commands;

import collection.LabWork;
import managers.CollectionManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MinByCreationDate extends Command{
    public MinByCreationDate(){
        super("min_by_creation_date", "вывести любой объект из коллекции, значение поля creationDate которого является минимальным");
    }

    @Override
    public void execute(String args) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            Set<LabWork> labs = CollectionManager.getCollection();

//            Collections.sort(labs, new Comparator<LabWork>() {
//                public int compare(LabWork lab1, LabWork lab2) {
//                    if (lab1.getCreationDate() == null){
//                        return 1;
//                    }
//                    if (lab2.getCreationDate() == null){
//                        return -1;
//                    }
//                    return Long.valueOf(lab1.getCreationDate() - lab2.getCreationDate());
//                }
//            });

            //System.out.println(labs.getLast().toString());

    }
}}
