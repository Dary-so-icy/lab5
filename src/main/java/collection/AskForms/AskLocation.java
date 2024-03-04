package collection.AskForms;

import collection.Coordinates;
import collection.Location;

public class AskLocation extends Form<Location>{
    @Override
    public Location build() {
        int a = askInteger("Integer координата y");
        float b = askFloat("Float координата x", false);
        console.println("Введите название локации(необязательное поле): ");
        String name = scanner.nextLine().trim();
        return new Location(a, b, name);
    }
}
