import collection.*;
import managers.CollectionManager;
import managers.Commander;
import managers.InteractiveModeManager;
import managers.StandartConsole;

import java.util.*;

public class Main {
    static List<LabWork> labwork = new ArrayList<LabWork>();

    public static void main(String[] args) {
        StandartConsole console = new StandartConsole();
        InteractiveModeManager now = new InteractiveModeManager(console, new Commander());
        //if (args.length == 0){
        //    console.println("Вы не указали имя файла. Запуск невозможен.");
        //    System.exit(1);
        //}
        //String filename = args[0];
        try {
            //CollectionManager.readCollection(filename);
            CollectionManager.readCollection("1.xml");
        }catch(Exception e){
            console.printError(e.toString());
        }
        now.interactiveMode();
    }

}