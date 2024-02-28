package collection;

public class Coordinates {
    private Float x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    public Coordinates(float x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }
}
