package collection.Models;

import collection.Location;
import collection.Person;

/**
 * Класс для создания человека
 *
 * @author darya
 */

public class AskPerson extends Model<Person> {

    @Override
    public Person build() {
        console.println("Введите имя человека: ");
        String name = scanner.nextLine().trim();
        double h = 0;
        Location loc = null;
        Boolean ask_height = askBoolean("Хотите ли вводить рост человека?");
        if (ask_height) {
            h = askDouble("рост человека");
        }
        Boolean ask_loc = askBoolean("Хотите ли вводить локацию человека?");
        if (ask_loc) {
            loc = new AskLocation().build();
        }
        if(!(h==0) & !(loc == null)){
            return new Person(name, h, loc);
        }else if(!(h==0)){
            return new Person(name, h);
        }else if(!(loc==null)){
            return new Person(name, loc);
        }
        return new Person(name);



    }
}
