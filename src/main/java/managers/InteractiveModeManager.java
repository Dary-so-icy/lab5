package managers;

import exceptions.CommandRuntimeError;
import exceptions.NoSuchCommand;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Класс обработки пользовательского ввода
 *
 * @author darya
 */
public class InteractiveModeManager {
    private final StandartConsole console;
    private final Commander commander;

    public InteractiveModeManager(StandartConsole console, Commander commandManager) {
        this.console = console;
        this.commander = commandManager;
    }

    public void interactiveMode() {
        Scanner userScanner = ScannerManager.getScannerIn();
        while (true) {
            try {
                if (!userScanner.hasNextLine()) {
                    commander.execute("exit", "");
                }
                ;
                String userCommand = userScanner.nextLine().trim() + " ";
                this.launch(userCommand.split(" ", 2));
                commander.addToHistory(userCommand);
            } catch (NoSuchCommand ex) {
                console.printError("Такой команды нет в списке");
            } catch (Exception exception) {
                console.printError("Пользовательский ввод не обнаружен!");
                console.printError("Введены неправильные аргументы команды");
                console.printError("Ошибка при исполнении команды");
            }
        }
    }

    public void launch(String[] userCommand) throws NoSuchCommand, CommandRuntimeError {
        if (userCommand[0].equals("")) return;
        var command = Commander.getCommands().get(userCommand[0]);
        if (command == null) {
            throw new NoSuchCommand();
        }
        try {
            String argument = userCommand[1];
            command.execute(argument);
            console.print("// Команда " + userCommand[0] + " выполнена //" + '\n');
        } catch (Exception e) {
            console.print(e);
        }
    }

}
