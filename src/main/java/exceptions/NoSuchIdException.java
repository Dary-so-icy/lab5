package exceptions;
/**
 * Исключение, которое пробрасывается при отсутствии элементов с заданным id
 *
 * @author darya
 */
public class NoSuchIdException extends RuntimeException{
    public NoSuchIdException(){
        super("Несущствующий id");
    }

    @Override
    public String toString() {
        return "Нет элемента из коллекции с таким id";
    }
}
