package collection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    private Location location; //Поле может быть null

    public Person(String name, double height, Location location){
        this.name =name;
        this.height = height;
        this.location = location;
    }
    public Person(String name, double height){
        this.name =name;
        this.height = height;
        this.location = null;
    }
    @Override
    public String toString() {
        return "Person{\"name\": " + name + ", " +
                "\"height\": \"" + height + "\", " +
                "\"location\": \"" + location + "}";
    }
}
