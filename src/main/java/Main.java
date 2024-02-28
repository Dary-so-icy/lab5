import collection.*;
import commandManagers.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.zip.DataFormatException;

public class Main {
    static List<LabWork> labwork = new ArrayList<LabWork>();

    public static void main(String[] args) throws Ask.AskBreak {
        var console = new StandartConsole();
        labwork.add(Ask.askLabWork(console, 100));

        for (var e : labwork) System.out.println(e);
    }
}

class Ask {
    public static class AskBreak extends Exception {
    }

    public static LabWork askLabWork(Console console, int id) throws AskBreak {
        try {
            String name;
            while (true) {
                console.print("name: ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
                if (!name.isEmpty()) break;
            }
            LocalDate creationDate;
            while (true) {
                console.print("data (Exemple: " + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " ): ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (line.equals("")) {
                    creationDate = null;
                    break;
                }
                try {
                    //creationDate =  DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
                    creationDate = LocalDate.parse(line, DateTimeFormatter.ISO_DATE);
                    break;
                } catch (DateTimeParseException e) {
                }
                try {
                    //creationDate = LocalDate.parse(line+ "T00:00:00.0000", DateTimeFormatter.ISO_DATE);
                    break;
                } catch (DateTimeParseException e) {
                }
            }
            var coordinates = askCoordinates(console);
            var Difficult = askDifficulty(console);
            var auth = askPerson(console);
            //передвать надо creation date
            return new LabWork(id, name, coordinates, new Date(), 5, Difficult, auth);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Coordinates askCoordinates(Console console) throws AskBreak {
        try {
            float x;
            while (true) {
                console.print("coordinates.x: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        x = Float.parseFloat(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            int y;
            while (true) {
                console.print("coordinates.y: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        y = Integer.parseInt(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            return new Coordinates(x, y);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Location askLocation(Console console) throws AskBreak {
        try {
            int x;
            while (true) {
                console.print("coordinates.x: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        x = Integer.parseInt(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            float y;
            while (true) {
                console.print("coordinates.y: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        y = Float.parseFloat(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            String name;
            console.print("name: ");
            name = console.readln().trim();
            if (name.equals("exit")) throw new AskBreak();

            return new Location(x, y, name);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Difficulty askDifficulty(Console console) throws AskBreak {
        try {
            Difficulty d;
            while (true) {
                console.print("Difficulty (" + Difficulty.names() + "): ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        d = Difficulty.valueOf(line);
                        break;
                    } catch (NullPointerException | IllegalArgumentException e) {
                    }
                } else return null;
            }
            return d;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Person askPerson(Console console) throws AskBreak {
        try {
            String name;
            while (true) {
                console.print("Person's name: ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
                if (!name.isEmpty()) break;
            }
            double h;
            while (true) {
                console.print("height: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        h = Double.parseDouble(line);
                        break;
                    } catch (NumberFormatException e) {
                        throw new AskBreak();
                    }
                }
            }
            var loc = askLocation(console);
            return new Person(name, h, loc);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }
}


