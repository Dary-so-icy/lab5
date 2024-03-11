import collection.*;
import collection.AskForms.AskLabWork;
import commandManagers.*;

import java.util.*;

public class Main {
    static List<LabWork> labwork = new ArrayList<LabWork>();

    public static void main(String[] args) throws Ask.AskBreak {
        var console = new StandartConsole();
        labwork.add(new AskLabWork().build());

        for (var e : labwork) System.out.println(e);
    }
}

class Ask {
    public static class AskBreak extends Exception {
    }


    }