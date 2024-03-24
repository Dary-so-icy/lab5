package commands;

import managers.Commander;

import java.util.Collection;

public class Help extends Command{
    public Help() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void execute(String[] args){
        Commander commander = new Commander();
        Collection<Command> commands = commander.getCommands().values();
        System.out.println("Доступны команды:");
        for (Command command : commands) {
            System.out.println(command.getName() + ": " + command.getInfo());
        }
    }

}
