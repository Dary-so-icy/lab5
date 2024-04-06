package commands;

import exceptions.CommandRuntimeError;

import java.io.FileNotFoundException;

public interface Commandable {
    String getName();
    void execute(String arg) throws CommandRuntimeError, FileNotFoundException;
    String getInfo();
}
