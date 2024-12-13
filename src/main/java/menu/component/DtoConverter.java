package menu.component;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.dto.CoachDto;

public class DtoConverter {
    public List<Coach> namesToCoaches(final List<String> coachNames) {
        return coachNames.stream()
                .map(Coach::from)
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
