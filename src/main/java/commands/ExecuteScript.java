package commands;

import managers.Commander;
import managers.ScannerManager;
import managers.StandartConsole;

import java.io.Console;
import java.util.Scanner;

/**
 * Команда 'execute_script'. Считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 *
 * @author darya
 */
public class ExecuteScript extends Command {
    public ExecuteScript() {
        super("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public void execute(String file) {
        Scanner scanner = new Scanner(file);
        String out = "";
        while (scanner.hasNext()) {
            //Console console = new Console();
            Scanner fileReader = new Scanner(file);
            String s = "";
            s = fileReader.nextLine().trim();
            Command command = Commander.getCommands().get(s);
            if (command == null) {
                out += "Неизвестная команда " + s;
                //return false;
            }


        }
    }
}
