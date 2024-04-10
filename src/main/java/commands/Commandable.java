package commands;

import exceptions.CommandRuntimeError;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Интерфейс всех команд
 *
 * @author darya
 */
public interface Commandable {
    String getName();
    void execute(String arg, Scanner scan, boolean isFile) throws CommandRuntimeError, FileNotFoundException;
    String getInfo();
}
