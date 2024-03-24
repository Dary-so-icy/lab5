package commands;

public class AddIfMin extends Command{
    public AddIfMin(){
        super("add_if_min", "добавить новый элемент коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }

    @Override
    public void execute(String[] args) {
        Person groupAdmin = studyGroup.getGroupAdmin();
        if (groupAdmin != null) {
            boolean result = state.hasPersonWithPassportId(groupAdmin.getPassportID());
            if (result) {
                return Result.error("Вы пытались добавить groupAdmin с уже существующем passportId");
            }
        }
        Collection<StudyGroup> collection = state.getCollection();
        List<StudyGroup> collectionStudyGroup = new ArrayList<>(collection);
        Collections.sort(collectionStudyGroup);
        if (collectionStudyGroup.isEmpty()) {
            return Result.error("Вам не с чем сравнивать");
        }
        StudyGroup firstElement = collectionStudyGroup.get(0);
        if (studyGroup.compareTo(firstElement) < 0) {
            state.addElement(studyGroup);
        } else {
            return Result.error("Не получилось добавить элемент в коллекцию. Значение вашего элемента больше, чем у наименьшего элемента коллекции. ");
        }
        return Result.success("Вы успешно добавили элемент коллекции");
    }


}
}
