package commands;

import exceptions.CommandRuntimeError;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Commandable {
    String getName();
    void execute(String arg, Scanner scan, boolean isFile) throws CommandRuntimeError, FileNotFoundException;
    String getInfo();
}
