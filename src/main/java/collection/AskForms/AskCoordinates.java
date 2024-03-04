package collection.AskForms;

import collection.Coordinates;

public class AskCoordinates extends Form<Coordinates> {
    @Override
    public Coordinates build() {
        float x = askFloat("Float координата x", false);
        int y = askInteger("Integer координата y");
        return new Coordinates(x, y);
    }
}
