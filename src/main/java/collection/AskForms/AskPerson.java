package collection.AskForms;

import collection.Location;
import collection.Person;

public class AskPerson extends Form<Person>{

    @Override
    public Person build(){
        console.println("Введите имя человека: ");
        String name = scanner.nextLine().trim();
        double h = askDouble("рост человека(необязательное поле)");
        Location loc = new AskLocation().build();
        return new Person(name, h, loc);

    }
}
