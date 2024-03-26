package collection.Models;

import collection.Coordinates;
/**
 * Класс создания коорднат
 * @author darya
 */
public class AskCoordinates extends Model<Coordinates> {
    @Override
    public Coordinates build() {
        float x = askFloat("Float координата x", false);
        int y = askInteger("Integer координата y");
        return new Coordinates(x, y);
    }
}
