package collection.Models;

import collection.LabWork;
import jakarta.xml.bind.annotation.*;
import lombok.*;
import java.util.HashSet;
/**
 * Класс для парсинга объекта
 * @author darya
 */
@Getter
@Setter
@XmlRootElement(name = "labworks")
@XmlAccessorType(XmlAccessType.FIELD)
public class LabForReading{
    @XmlElement(name="labwork", type = LabWork.class)
    private HashSet<LabWork> collectionOfLabs;

}
