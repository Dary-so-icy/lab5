package commands;

import exceptions.IllegalParamException;
import managers.Commander;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Команда 'history'. Выводит последние 14 команд(без их аргументов)
 * @author darya
 */
public class History extends Command{
    public History(){
        super("history", "вывести последние 14 команд(без их аргументов)");
    }

    @Override
    public void execute(String args, Scanner scan, boolean isFile) throws IllegalParamException{
        if (!args.isBlank()) throw new IllegalParamException("*ничего*");
        ArrayList<String> history = Commander.getCommandHistory();
        if (!history.isEmpty()){
            System.out.println("Введенные команды: ");
            for (String command: history.subList(Math.max(0, history.size() - 14), history.size())){
                System.out.println(command);
            }
        } else {
            System.out.println("Вы еще не ввели ни одной команды!");
        }
    }
}
