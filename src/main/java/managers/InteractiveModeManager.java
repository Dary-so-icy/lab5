package managers;

import exceptions.NoSuchCommand;
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
        Scanner userScanner = new Scanner(System.in); //&?
        while (true) {
            try {
                if (!userScanner.hasNextLine()) {
                    commander.execute("exit", "", userScanner, false);
                }

                String userCommand = userScanner.nextLine().trim() ;
                var comm = userCommand.split(" ");
                if(comm.length > 1) {
                    this.launch(comm[0], comm[1], userScanner, false);
                }else{
                    this.launch(comm[0], "", userScanner, false);
                }
                commander.addToHistory(comm[0]);
            } catch (NoSuchCommand ex) {
                console.printError("Такой команды нет в списке");
            } catch (Exception exception) {
                console.printError("Пользовательский ввод не обнаружен!");
                console.printError("Введены неправильные аргументы команды");
                console.printError("Ошибка при исполнении команды");
            }
        }
    }

    public void launch(String comm, String args, Scanner scan, boolean isFile) throws NoSuchCommand {
        if (comm.equals("")) return;
        var command = Commander.getCommands().get(comm);
        if (command == null) {
            throw new NoSuchCommand();
        }
        try {
            command.execute(args, scan, isFile);
            console.print("// Команда " + comm + " выполнена //" + '\n');
        } catch (Exception e) {
            console.print(e.getMessage());
        }
    }

}
