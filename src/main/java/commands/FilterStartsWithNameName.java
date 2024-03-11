package commands;

public class FilterStartsWithNameName extends Command{
    public FilterStartsWithNameName(){
        super("filter_starts_with_name_name", "вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public void execute(String[] args) {

    }
}
