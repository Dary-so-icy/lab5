package collection;

public class Location {
    private Integer x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private String name; //Поле может быть null

    public Location(int x, float y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Location(int x, float y){
        this.x = x;
        this.y = y;
        this.name = null;
    }

    @Override
    public String toString() {
        return "Location{\"x\": " + x + ", " +
                "\"y\": \"" + y + "\", " +
                "\"name\": \"" + name + "}";
    }
}
