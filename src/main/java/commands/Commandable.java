package commands;

public interface Commandable {
    String getName();
    void execute(String arg);
    String getInfo();
}
