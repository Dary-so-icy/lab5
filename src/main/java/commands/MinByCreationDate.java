package commands;

import collection.LabWork;
import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда 'min_by_creation_date'. Выводит любой объект из коллекции, значение поля creationDate которого является минимальным
 * @author darya
 */
public class MinByCreationDate extends Command{
    public MinByCreationDate(){
        super("min_by_creation_date", "вывести любой объект из коллекции, значение поля creationDate которого является минимальным");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            LabWork minDate = null;
            for (LabWork lab : CollectionManager.getCollection()) {
                if ((minDate == null) || (lab.getCreationDate().compareTo(minDate.getCreationDate())) < 0 ) {
                    minDate = lab;
                }
            }
            if (minDate == null) {
                System.out.println("Минимальной даты не обнаружено.");
            } else {
                System.out.println("Минимальная дата: " + minDate.getCreationDate() + ". Элемент: " + minDate);
            }


    }
}}
