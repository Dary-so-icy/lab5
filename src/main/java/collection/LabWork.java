package collection;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import managers.DateAdapter;
import managers.Validatable;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LabWork implements Validatable {
    @XmlAttribute
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement(name="name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name="coordinates")
    private Coordinates coordinates; //Поле не может быть null
    //@XmlJavaTypeAdapter(using = Date .class)
    @XmlElement(name = "creationDate", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement(name="minimalpoint")
    private float minimalPoint; //Значение поля должно быть больше 0
    @XmlElement(name="difficulty")
    private Difficulty difficulty; //Поле не может быть null
    @XmlElement(name="person")
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
    @Override
    public int compareTo(LabWork o) {
        return Float.compare(minimalPoint, o.getMinimalPoint());
    }
}
