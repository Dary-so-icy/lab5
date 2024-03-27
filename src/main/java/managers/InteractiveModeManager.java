package managers;

import exceptions.CommandRuntimeError;
import exceptions.NoSuchCommand;

import java.util.Scanner;


/**
 * Класс обработки пользовательского ввода
 * @author darya
 */
public class InteractiveModeManager {
    private final StandartConsole console;
    private final Commander commander;

    public InteractiveModeManager(StandartConsole console, Commander commandManager) {
        this.console = console;
        this.commander = commandManager;
    }
    public void interactiveMode(){
        Scanner userScanner = ScannerManager.getUserScanner();
        while (true) {
            try{
                if (!userScanner.hasNextLine()) {commander.execute("exit", "");};
                String userCommand = userScanner.nextLine().trim() + " ";
                this.launch(userCommand.split(" ", 2));
                commander.addToHistory(userCommand);
            } catch (Exception exception) {
                console.printError("Пользовательский ввод не обнаружен!");
                console.printError("Такой команды нет в списке");
                console.printError("Введены неправильные аргументы команды");
                console.printError("Ошибка при исполнении команды");
                return;
            }
        }
    }

    public  void launch(String[] userCommand)throws NoSuchCommand, CommandRuntimeError {
        if (userCommand[0].equals("")) return;
        var command = Commander.getCommands().get(userCommand[0]);
        if (command == null) {
            return ;
        }
        try {
            String argument = userCommand[1];
            command.execute(argument);
            console.print("// Команда " + userCommand[0] + " выполнена //"+'\n');
        }catch (Exception e){
            console.print(e);
        }
    }

}
