package managers;
import lombok.Getter;

import java.util.Scanner;
/**
 * Класс хранящий сканер для программы
 */
@Getter
public class ScannerManager {
    private static Scanner scanner = new Scanner(System.in);
    public static Scanner getUserScanner() {
        return scanner;
    }

}