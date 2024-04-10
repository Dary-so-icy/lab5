package exceptions;

import java.io.IOException;

/**
 * Класс исключения для ошибки во время выполнения команды
 *
 * @author darya
 */
public class CommandRuntimeError extends IOException {
    public CommandRuntimeError(String message){
        super(message);
    }
}