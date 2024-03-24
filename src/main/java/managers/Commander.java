package managers;

import commands.*;
import commands.Command;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс )))
 * @author darb0ga
 */

public class Commander {
    private static Map<String, Command> commands;

    private static ArrayList<String> history = new ArrayList<>();// просто список всех команд
    // а надо еще сто бы сохранялась история чтобы список хранил по хронологии значения
    public Commander(){
        commands = new LinkedHashMap<>();

        commands.put("add", new Add());
        commands.put("add_if_min", new AddIfMin());
        commands.put("clean", new Clear());
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

    public void execute(String name, String[] args) { //throws NoSuchCommand, IllegalArguments, CommandRuntimeError, ExitObliged {
        Command command = commands.get(name);
        //if (command == null) throw new NoSuchCommand();
        command.execute(args);
    }

    public void addToHistory(String userCommand) {
        if(commands.containsKey(userCommand)){
            history.add(userCommand);
        }
        //Command command = commands.get(userCommand);
        //history.add(command.getName());
        //history.add(userCommand);
    }

    /**
     * @return История команд.
     */
    public static ArrayList<String> getCommandHistory() {
        return history;
    }

    public static Map<String, Command> getCommands() {
        return commands;
    }
}
