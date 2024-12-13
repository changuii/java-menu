package menu.component;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomShuffleFunction implements ShuffleFunction {
    @Override
    public <T> List<T> shuffle(List<T> target) {
        return Randoms.shuffle(target);
    }
}
