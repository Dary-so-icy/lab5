package managers;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Класс хранящий сканер для программы
 * @author darb0ga
 */
@Getter
@Setter
public class ScannerManager {
    private static Scanner scanner_in = new Scanner(System.in);
    private static Scanner file_scanner;
    private static String path = null;
    public static Scanner getScannerIn() {
        return scanner_in;
    }
    public static Scanner getFileScanner(){
        return file_scanner;
    }

    public static void setFile_scanner(Scanner scanner) {
        file_scanner = scanner;
        //path =
        //тут что то надо сделать и положить поток из файла
    }


}
