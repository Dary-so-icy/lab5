
import managers.CollectionManager;
import managers.Commander;
import managers.InteractiveModeManager;
import managers.StandartConsole;



public class Main {

    public static void main(String[] args) {
        StandartConsole console = new StandartConsole();
        InteractiveModeManager now = new InteractiveModeManager(console, new Commander());
//        if (args.length == 0) {
//            console.println("Необходимо указать имя файла. Невозможно запустить приложение");
//            System.exit(1);
//        }
//        String filename = args[0];
        String filename= "1.xml";
        try {
            CollectionManager.readCollection(filename);
        } catch (Exception e) {
            console.printError(e.toString());
        }
        now.interactiveMode();
    }

}