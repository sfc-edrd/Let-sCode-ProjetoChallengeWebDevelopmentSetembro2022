package challengeWebDevelopementSetembro2022.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Builder
@Data
public class Movie
{
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime registeredAt;

    public LocalDateTime getRegisteredAt()
    {
        return (registeredAt.truncatedTo(ChronoUnit.SECONDS));
    }
}
