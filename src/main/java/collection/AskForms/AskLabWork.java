package collection.AskForms;

import collection.*;

public class AskLabWork extends Form<LabWork> {
    @Override
    public LabWork build(){
        int id = askInteger("id"); //тут что то не так
        // надо фйди по другому генерить
        console.println("Введите название: ");
        String name = scanner.nextLine().trim();
        Coordinates coord = new AskCoordinates().build();
        Float minpoint = askFloat("минимальное значение", true);
        Difficulty en = (Difficulty) askEnum("сложность", Difficulty.values());
        Person author = new AskPerson().build();
        return new LabWork(id, name, coord, minpoint, en,author);
    }
}
