import collection.*;
import collection.AskForms.AskLabWork;
import commandManagers.*;

import java.util.*;

public class Main {
    static List<LabWork> labwork = new ArrayList<LabWork>();

    public static void main(String[] args) {
        var console = new StandartConsole();
        labwork.add(new AskLabWork().build());

        for (var e : labwork) System.out.println(e);
    }
    // надо обьединить ипакеты мэнеэджер и коллектион мэнеджер

}