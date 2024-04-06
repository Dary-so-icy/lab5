package collection.Models;

import managers.ScannerManager;
import managers.StandartConsole;

import java.util.Scanner;
/**
 * Класс чтения объекта
 * @author darya
 */
public abstract class Model<T> {

    protected StandartConsole console = new StandartConsole();

    protected Scanner scanner = ScannerManager.getScannerIn();

    public abstract T build();

    public Integer askInteger(String name) {
        while (true) {
            console.println("Введите " + name + ": ");
            String input = scanner.nextLine().trim();
            try {
                int num = Integer.parseInt(input);
                return num;
            } catch (NumberFormatException e) {
                console.printError(name + " должно быть числом типа Integer!");
            }
        }
    }

    public Boolean askBoolean(String name) {
        while (true) {
            console.println(name + "(true/false): ");
            String input = scanner.nextLine().trim();
            try {
                if(input.equals("true")){
                    return true;
                } else if (input.equals("false")) {
                    return false;
                }
            } catch (NumberFormatException e) {
                console.printError(name + " должно быть полем типа Boolean!");
            }
        }
    }

    public Float askFloat(String name, Boolean MoreThanZero) {
        while (true) {
            console.println("Введите " + name + ": ");
            String input = scanner.nextLine().trim();
            try {
                Float num = Float.parseFloat(input);
                if (MoreThanZero) {
                    if (num > 0) return num;
                }else{
                    return num;
                }
            } catch (NumberFormatException e) {
                console.printError(name + " должно быть числом типа Float!");
            }
        }
    }

    public Double askDouble(String name) {
        while (true) {
            console.println("Введите " + name + ": ");
            String input = scanner.nextLine().trim();
            if (!input.equals("")){
                try {
                    double num = Double.parseDouble(input);
                    if (num <= 0) throw new IllegalArgumentException();
                    return num;
                } catch (NumberFormatException e) {
                    console.printError(name + " должно быть числом типа Double!");
                }
            } else {
                return null;
            }
        }
    }

    public <S extends Enum<S>> Enum<S> askEnum(String name, Enum<S>[] values) {
        while (true) {
            console.println("Введите " + name + ": ");
            for (Enum<S> value : values) {
                console.print(value + " ");
            }
            console.print("\n");
            String str = scanner.nextLine().trim();
            try {
                for (Enum<S> value : values) {
                    if (value.toString().equals(str)) {
                        return value;
                    }
                }
                console.printError(name + " такого значения нет в списке!");
            } catch (IllegalArgumentException e) {
                console.printError(name + " неверное значение поля!");
            }
        }
    }

}