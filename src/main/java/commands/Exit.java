package commands;

public class Exit extends Command {
    public Exit() {
        super("exit", "завершить программу(без сохранения в файл)");
    }

    @Override
    public void execute(String[] args) {
        System.out.print("Выход из программы");
        System.exit(0);
    }
}
