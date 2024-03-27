package commands;

import exceptions.CommandRuntimeError;

public interface Commandable {
    String getName();
    void execute(String arg) throws CommandRuntimeError;
    String getInfo();
}
