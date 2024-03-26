package collection;


import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Класс энума сложности
 * @author darya
 */
@Getter
@AllArgsConstructor
public enum Difficulty {
    VERY_EASY,
    EASY,
    HARD,
    HOPELESS,
    TERRIBLE;
}
