package commands;

import java.util.Objects;

/**
 * Абстрактный класс команда
 *
 * @author darya
 */
public abstract class Command implements Commandable {
    private final String name;
    private final String description;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfo() {
        return description;
    }

    protected Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        Command that = (Command) other;
        return (getName() == that.getName() && getInfo() == that.getInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '{' + "name= " + this.getName() + ", description= " + this.getInfo() + '}';
    }
}
