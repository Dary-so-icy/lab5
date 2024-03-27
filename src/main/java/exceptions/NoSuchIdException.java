package exceptions;
/**
 * Класс исключения для несуществующих элементов с таким id
 */
public class NoSuchIdException extends RuntimeException{
    @Override
    public String toString() {
        return "Нет элемента из коллекции с таким id";
    }
}
