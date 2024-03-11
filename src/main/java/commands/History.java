package commands;

public class History extends Command{
    public History(){
        super("history", "ывести последние 14 команд(без их аргументов)");
    }

    @Override
    public void execute(String[] args) {

    }
}
