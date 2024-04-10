package exceptions;
import java.io.IOException;

/**
 * Исключение, которое пробрасывается при вызове несуществующей команды
 *
 * @author darya
 */
public class NoSuchCommand extends IOException {
    @Override
    public String toString() {
        return "Нет такой команды";
    }
}
