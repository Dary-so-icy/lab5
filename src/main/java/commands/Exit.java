package commands;
/**
 * Команда 'exit'. Завершает программу(без сохранения в файл)
 * @author darya
 */
public class Exit extends Command {
    public Exit() {
        super("exit", "завершить программу(без сохранения в файл)");
    }

    @Override
    public void execute(String args) {
        System.out.print("Выход из программы");
        System.exit(0);
    }
}
