package commands;

import collection.LabWork;
import collection.Person;
import managers.CollectionManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * Команда 'print_field_ascending_author'. Выводит значения поля author всех элементов в порядке возрастания
 * @author darya
 */
public class PrintFieldAscendingAuthor extends Command{
    public PrintFieldAscendingAuthor(){
        super("print_field_ascending_author", "вывести значения поля author всех элементов в порядке возрастания");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            ArrayList<Person> people = new ArrayList<>();
            for (LabWork element: CollectionManager.getCollection()){
                people.add(element.getAuthor());
            }
            Comparator<Person> compareByName = Comparator
                    .comparing(Person::getName);

            ArrayList<Person> sortedPerson = people.stream()
                    .sorted(compareByName)
                    .collect(Collectors.toCollection(ArrayList::new));

            System.out.println("Поле Author в порядке убывания:");
            for (Person person: sortedPerson){
                System.out.print(person + "\n");
            }
        }
    }
}
