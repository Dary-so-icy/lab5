import collection.*;
import collection.AskForms.AskLabWork;
import managers.Commander;
import managers.RuntimeManager;
import managers.StandartConsole;

import java.io.Console;
import java.util.*;

public class Main {
    static List<LabWork> labwork = new ArrayList<LabWork>();

    public static void main(String[] args) {
        StandartConsole console = new StandartConsole();
        RuntimeManager now = new RuntimeManager(console, new Commander());
        now.interactiveMode();
    }
    /*
    info - вывод изменить
     */

}