package managers;

import commands.*;
import commands.Command;
import exceptions.CommandRuntimeError;
import exceptions.NoSuchCommand;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс команд и их истории
 *
 * @author darya
 */

public class Commander {
    private static Map<String, Command> commands;

    public static ArrayList<String> history = new ArrayList<>();

    public Commander() {
        commands = new LinkedHashMap<>();

        commands.put("add", new Add());
        commands.put("add_if_min", new AddIfMin());
        commands.put("clear", new Clear());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("filter_starts_with_name", new FilterStartsWithName());
        commands.put("help", new Help());
        commands.put("history", new History());
        commands.put("info", new Info());
        commands.put("min_by_creation_date", new MinByCreationDate());
        commands.put("print_field_ascending_author", new PrintFieldAscendingAuthor());
        commands.put("remove_by_id", new RemoveByID());
        commands.put("remove_greater", new RemoveGreater());
        commands.put("save", new Save());
        commands.put("show", new Show());
        commands.put("update_id", new UpdateID());
    }

    public static void execute(String name, String args, Scanner scan, boolean isFile) throws NoSuchCommand, CommandRuntimeError {
        Command command = commands.get(name);
        if (command == null) throw new NoSuchCommand();
        try {
            command.execute(args.trim(), scan, isFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void addToHistory(String userCommand) {
        history.add(userCommand);
        if (history.size() >= 14) {
            history.remove(0);
        }
    }

    public static ArrayList<String> getCommandHistory() {
        return history;
    }

    public static Map<String, Command> getCommands() {
        return commands;
    }
}
