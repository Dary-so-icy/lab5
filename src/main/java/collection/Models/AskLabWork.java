package collection.Models;

import collection.*;

import java.util.Scanner;

/**
 * Класс для создания обьекта лабработы
 * @author darya
 */
public class AskLabWork extends Model<LabWork> {
    @Override
    public LabWork build(Scanner scan, boolean isFile) {
        if(!isFile) {
            System.out.println("Введите название лабораторной работы: ");
        }
        String name = scan.nextLine().trim();
        Coordinates coord = new AskCoordinates().build(scan, isFile);
        Float minpoint = askFloat("минимальное значение(должно быть больше 0)", true, scan, isFile);
        Difficulty en = (Difficulty) askEnum("сложность работы", Difficulty.values(), scan, isFile);
        Person author = new AskPerson().build(scan, isFile);
        return new LabWork(name, coord, minpoint, en, author);
    }
}
