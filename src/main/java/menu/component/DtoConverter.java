package menu.component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import menu.domain.Coach;
import menu.dto.CoachDto;
import menu.enums.Menu;

public class DtoConverter {
    public List<Coach> convertCoaches(final List<String> coachNames, final List<List<Menu>> cantEatMenus) {
        return IntStream.range(0, coachNames.size())
                .mapToObj(i -> Coach.of(coachNames.get(i), cantEatMenus.get(i)))
                .collect(Collectors.toList());
    }

    public List<CoachDto> convertCoachDtos(final List<Coach> coaches) {
        return coaches.stream()
                .map(this::convertCoachDto)
                .collect(Collectors.toList());
    }

    private CoachDto convertCoachDto(final Coach coach) {
        return CoachDto.of(coach.getName(), coach.getRecommendMenus());
    }
}
