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
        console.println("Хотите ли вводить рост человека? (true/false): ");
        String ask1 = scanner.nextLine().trim();
        if (ask1.equals("true")) {
            double h = askDouble("рост человека(необязательное поле)", false);
            console.println("Хотите ли вводить локацию человека? (true/false): ");
            String ask2 = scanner.nextLine().trim();
            if (ask2.equals("true")) {
                Location loc = new AskLocation().build();
                return new Person(name, h, loc);
            } else {
                return new Person(name, h);
            }

        } else {
            return new Person(name);
        }

    }
}
