package collection.AskForms;

import commandManagers.StandartConsole;

import java.util.Scanner;

public abstract class Form<T> {

    protected  StandartConsole console;

    protected Scanner scanner;

    public abstract T build();

    public Integer askInteger(String name){
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

    public Float askFloat(String name, Boolean MoreThanZero){
        while (true) {
            console.println("Введите " + name + ": ");
            String input = scanner.nextLine().trim();
            try {
                Float num = Float.parseFloat(input);
                if (MoreThanZero){if (num > 0) return num;}
                return num;
            } catch (NumberFormatException e) {
                console.printError(name + " должно быть числом типа Float!");
            }
        }
    }
    public Double askDouble(String name){
        while (true) {
            console.println("Введите " + name + ": ");
            String input = scanner.nextLine().trim();
            if (!(input.equals(""))) {
                try {
                    double num = Double.parseDouble(input);
                    if (num <= 0) throw new IllegalArgumentException();
                    return num;
                } catch (NumberFormatException e) {
                    console.printError(name + " должно быть числом типа Double!");
                }
            }else {
                return null;
            }
        }
    }
    public Enum askEnum(String name, Enum[] values) {
        while (true) {
            console.println("Введите " + name + ": ");
            for (Enum value : values) {
                console.print(value + " ");
            }
            String str = scanner.nextLine().trim();
            try {
                for (Enum value : values) {
                    if (value.toString().equals(str)) {
                        return value;
                    }
                }
                console.printError(name + " такого значения нет в списке!");
            }catch (IllegalArgumentException e){
                console.printError(name + " неверное значение поля!");
            }
        }
    }

}
