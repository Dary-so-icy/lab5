package commands;

import exceptions.CommandRuntimeError;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Команда 'execute_script'. Считывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 *
 * @author darya
 */
public interface Commandable {
    String getName();
    void execute(String arg, Scanner scan, boolean isFile) throws CommandRuntimeError, FileNotFoundException;
    String getInfo();
}
