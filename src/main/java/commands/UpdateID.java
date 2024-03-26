package commands;

import collection.Models.AskLabWork;
import collection.LabWork;
import managers.CollectionManager;

public class UpdateID extends Command{
    public UpdateID(){
        super("update_id", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String args) {
        try {
            LabWork lab = CollectionManager.findById(Integer.parseInt(args));
            if (lab != null) {
                CollectionManager.updateById(new AskLabWork().build(), Integer.parseInt(args));
            }
        } catch (NumberFormatException e) {
            System.out.println("Введен неверный id. Поле должно быть числом!");
        }
    }
}
