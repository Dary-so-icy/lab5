package commands;

public class ExecuteScript extends Command{
    public ExecuteScript(){
        super("execute_script", "осчитать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public void execute(String[] args) {

    }
}
