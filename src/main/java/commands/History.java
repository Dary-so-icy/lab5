package commands;

import managers.Commander;
import managers.StandartConsole;

import java.util.ArrayList;

public class History extends Command{
    public History(){
        super("history", "вывести последние 14 команд(без их аргументов)");
    }

    @Override
    public void execute(String[] args) {
        ArrayList<String> history = Commander.getCommandHistory();
        if (!history.isEmpty()){
            for (String command: history.subList(Math.max(0, history.size() - 10), history.size())){
                System.out.println(command);
            }
        } else {
            System.out.println("Вы еще не ввели ни одной команды!");
        }
//        commander.getCommands().values().forEach(command -> {
//            console.printTable(command.getName(), command.getDescription());
//        });
    }
}
