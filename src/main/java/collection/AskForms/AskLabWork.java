package collection.AskForms;

import collection.*;
import java.util.Date;

public class AskLabWork extends Form<LabWork> {
    @Override
    public LabWork build() {
        Integer id = askInteger("id"); //тут что то не так
        // надо aйди по другому генерить
        System.out.println("Введите название лабораторной работы: ");
        String name = scanner.nextLine().trim();
        Coordinates coord = new AskCoordinates().build();
        //Date date = askDate("локальная дата");
        Float minpoint = askFloat("минимальное значение", true);
        Difficulty en = (Difficulty) askEnum("сложность работы", Difficulty.values());
        Person author = new AskPerson().build();
        return new LabWork(id, name, coord, new Date(), minpoint, en, author);

        //return new LabWork(id, name, coord, minpoint, en, author);
    }
}
