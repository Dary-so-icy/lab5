package collection.AskForms;

import collection.*;
import java.util.Date;

public class AskLabWork extends Form<LabWork> {
    @Override
    public LabWork build() {
        int id = askInteger("id"); //тут что то не так
        // надо aйди по другому генерить
        console.println("Введите название: ");
        String name = scanner.nextLine().trim();
        Coordinates coord = new AskCoordinates().build();
        Date date = askDate("локальная дата");
        Float minpoint = askFloat("минимальное значение", true);
        Difficulty en = (Difficulty) askEnum("сложность", Difficulty.values());
        Person author = new AskPerson().build();
        if (date != null) {
            return new LabWork(id, name, coord, date, minpoint, en, author);
        }
        return new LabWork(id, name, coord, minpoint, en, author);
    }
}
