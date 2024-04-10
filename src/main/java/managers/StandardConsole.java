package managers;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс с методами консоли и указателем на режим аботы программмы
 * @author darya
 */
public class StandardConsole {
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
