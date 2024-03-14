package exceptions;

public class NoSuchIdException extends RuntimeException{
    @Override
    public String toString() {
        return "Нет элемента из коллекции с таким id";
    }
}
