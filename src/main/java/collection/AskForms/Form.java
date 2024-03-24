package collection.AskForms;

import managers.StandartConsole;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.Scanner;

public abstract class Form<T> {

    protected StandartConsole console;

    protected Scanner scanner;

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

    public Float askFloat(String name, Boolean MoreThanZero) {
        while (true) {
            console.println("Введите " + name + ": ");
            String input = scanner.nextLine().trim();
            try {
                Float num = Float.parseFloat(input);
                if (MoreThanZero) {
                    if (num > 0) return num;
                }
                return num;
            } catch (NumberFormatException e) {
                console.printError(name + " должно быть числом типа Float!");
            }
        }
    }

    public Double askDouble(String name) {
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
            } else {
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
            } catch (IllegalArgumentException e) {
                console.printError(name + " неверное значение поля!");
            }
        }
    }

    public Date askDate(String name) {
        while (true) {

            console.println("Введите дату в формате 2024-03-10(год-месяц-день): ");

            String input = scanner.nextLine().trim();
            if (!(input.equals(""))) {
                try {
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat(input);
                    String stringDate = formatter.format(date);
                    return date;
                } catch (DateTimeException e) {
                    console.printError(name + " должно быть в формате год-месяц-день!");
                }
            } else {
                return null;
            }

        }
    }
}