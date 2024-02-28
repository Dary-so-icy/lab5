package collection;

public enum Difficulty {
    VERY_EASY,
    EASY,
    HARD,
    HOPELESS,
    TERRIBLE;

    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var dragonType : values()) {
            nameList.append(dragonType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
