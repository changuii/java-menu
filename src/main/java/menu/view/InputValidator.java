package menu.view;

import java.util.List;
import java.util.regex.Pattern;
import menu.enums.ErrorMessage;

public class InputValidator {
    private static final String COACH_NAMES_REGEX = "^([가-힣]+)(,[가-힣]+)*$";
    private static final Pattern COACH_NAMES_FORMAT = Pattern.compile(COACH_NAMES_REGEX);
    private static final int COACH_NAMES_COUNT_MIN = 2;
    private static final int COACH_NAMES_COUNT_MAX = 5;
    private static final int COACH_NAME_LENGTH_MIN = 2;
    private static final int COACH_NAME_LENGTH_MAX = 4;

    public void validateCoachNamesText(final String coachNamesText) {
        if (!COACH_NAMES_FORMAT.matcher(coachNamesText).matches()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAMES_INVALID.getMessage());
        }
    }

    public void validateCoachNames(final List<String> coachNames) {
        validateCoachCountRange(coachNames);
        validateCoachNameDuplication(coachNames);
        coachNames.forEach(this::validateCoachNameLengthSize);
    }

    private void validateCoachCountRange(final List<String> coachNames) {
        if (coachNames.size() < COACH_NAMES_COUNT_MIN || COACH_NAMES_COUNT_MAX < coachNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAMES_INVALID.getMessage());
        }
    }

    private void validateCoachNameLengthSize(final String coachName) {
        if (coachName.length() < COACH_NAME_LENGTH_MIN || COACH_NAME_LENGTH_MAX < coachName.length()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAMES_INVALID.getMessage());
        }
    }

    private void validateCoachNameDuplication(final List<String> coachNames) {
        if (coachNames.stream().distinct().count() != coachNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAMES_INVALID.getMessage());
        }
    }
}
