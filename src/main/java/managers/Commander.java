package managers;

import commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Commander {
    List<String> commands = new ArrayList<>(); // просто список всех команд
    // а надо еще сто бы сохранялась история чтобы список хранил по хронологии значения
    public void addCommand(Command command){
        commands.add(command.getName());
    }

}
