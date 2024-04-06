package commands;

import managers.Commander;
import managers.ScannerManager;

import java.io.File;
import java.io.FileNotFoundException;
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
    public void execute(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        String s = "";
        ScannerManager.setFile_scanner(scanner);
        while (scanner.hasNext()) {
            try {
                s = scanner.nextLine().trim();
                System.out.println(s);
                String[] cmd = (s + " ").split(" ", 2);
                if (cmd[0].isBlank()) return;
                if (cmd[0].equals("execute_script")) {
                    continue;
                }
                System.out.println("Выполнение команды " + cmd[0]);
                Commander comm = new Commander();
                comm.execute(cmd[0], cmd[1]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }


        }
    }
