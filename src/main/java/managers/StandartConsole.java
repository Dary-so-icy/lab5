package managers;

import lombok.Getter;
import lombok.Setter;

/**
 * Консоль
 * @author darb0ga
 */
public class StandartConsole {
    @Getter
    @Setter
    private static boolean fileMode = false;
    public void print(Object obj) {
        System.out.print(obj);
    }

    public void println(Object obj) {
        System.out.println(obj);
    }

    public void printError(Object obj) {
        System.err.println("Error: " + obj);
    }


}
