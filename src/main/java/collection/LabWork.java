package collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import managers.Validatable;

import java.util.Date;
import jakarta.xml.bind.*;
import org.eclipse.persistence;
@Getter
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LabWork implements Validatable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float minimalPoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле не может быть null
    private Person author; //Поле не может быть null

    public LabWork(int id, String name, Coordinates coordinates, float minimalPoint, Difficulty difficulty, Person author){
        this(id, name, coordinates, new Date(), minimalPoint, difficulty, author);
    }

    @Override
    public String toString() {
        return "LabWork{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"coordinates\": \"" + coordinates + "\", " +
                "\"creationDate\": \"" + creationDate + "\", " +
                "\"minimalPoint\": \"" + minimalPoint + "\", " +
                "\"difficulty\": \"" + difficulty + "\", " +
                "\"author\": " +  author + "}";
    }

    @Override
    public boolean validate() {
        return false;
    }
}
