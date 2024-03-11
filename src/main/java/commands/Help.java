package commands;

public class Help extends Command{
    public Help() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void execute(String[] args){
        //console smth
    }

}
