package menu.component;

import java.util.List;

public interface ShuffleFunction {
    <T> List<T> shuffle(List<T> target);
}
