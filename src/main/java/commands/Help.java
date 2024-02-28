package commands;

public class Help extends Command{
    protected Help(String name, String description) {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void execute(String[] args){
        //console smth
    }

}
