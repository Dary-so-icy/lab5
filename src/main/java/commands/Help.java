package commands;

import exceptions.IllegalParamException;
import managers.Commander;

import java.util.Collection;
import java.util.Scanner;

/**
 * Команда 'help'. Выводит справку по доступным командам
 *
 * @author darya
 */
public class Help extends Command {
    public Help() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException {
        if (!args.isBlank()) throw new IllegalParamException("*ничего*");
        Collection<Command> commands = Commander.getCommands().values();
        System.out.println("Доступны команды:");
        for (Command command : commands) {
            System.out.println(command.getName() + ": " + command.getInfo());
        }
    }

}
