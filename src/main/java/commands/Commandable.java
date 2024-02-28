package commands;

public interface Commandable {
    String getName();
    void execute(String[] args);
    String getInfo();
}
