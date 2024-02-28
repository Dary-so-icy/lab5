package commands;

public class Info extends Command {
    protected Info(String name, String description) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
    }

    @Override
    public void execute(String[] args) {
        // что то сделать тут тоже надо
    }
}
