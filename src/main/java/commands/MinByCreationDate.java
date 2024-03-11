package commands;

public class MinByCreationDate extends Command{
    public MinByCreationDate(){
        super("min_by_creation_date", "вывести любой объект из коллекции, значение поля creationDate которого является минимальным");
    }

    @Override
    public void execute(String[] args) {

    }
}
