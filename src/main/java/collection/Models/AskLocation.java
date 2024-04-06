package collection.Models;

import collection.Location;

/**
 * Класс для создания локации
 *
 * @author darya
 */
public class AskLocation extends Model<Location> {
    @Override
    public Location build() {
        int a = askInteger("Integer координата y(локация)");
        float b = askFloat("Float координата x(локация)", false);
        Boolean ask = askBoolean("Хотите ли вводить наименование локации?");
        if (ask) {
            console.println("Введите имя локации: ");
            String name = scanner.nextLine().trim();
            return new Location(a, b, name);
        } else {
            return new Location(a, b);
        }
    }
}
