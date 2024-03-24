package commands;

import managers.Commander;
import managers.ScannerManager;

public class ExecuteScript extends Command{
    public ExecuteScript(){
        super("execute_script", "осчитать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public void execute(String[] args) {
        String commandName = null;
        String arg;
        while (ScannerManager.getUserScanner().hasNextLine()) {
            commandName = ScannerManager.getUserScanner().nextLine();
            if (commandName.split(",").length > 1) {
                arg = commandName.split(",")[1];
            } else {
                arg = "no args";
            }
            try {
                for (Command command : Commander.getCommands().values()) {
                    if (command.getName().equalsIgnoreCase(commandName.split(",")[0])) {
                        command.execute(args);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
