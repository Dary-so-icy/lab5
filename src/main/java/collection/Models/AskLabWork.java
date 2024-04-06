package collection.Models;

import collection.*;
/**
 * Класс для создания обьекта лабработы
 * @author darya
 */
public class AskLabWork extends Model<LabWork> {
    @Override
    public LabWork build() {
        System.out.println("Введите название лабораторной работы: ");
        String name = scanner.nextLine().trim();
        Coordinates coord = new AskCoordinates().build();
        Float minpoint = askFloat("минимальное значение(должно быть больше 0)", true);
        Difficulty en = (Difficulty) askEnum("сложность работы", Difficulty.values());
        Person author = new AskPerson().build();
        return new LabWork(name, coord, minpoint, en, author);
    }
}
