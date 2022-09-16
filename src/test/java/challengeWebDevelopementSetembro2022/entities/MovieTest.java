package challengeWebDevelopementSetembro2022.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@SpringBootTest
class MovieTest
{
    @Test
    @DisplayName("Test registeredAt format equals to 2022-08-30T06:00:00")
    public void testRegisteredAtFormat()
    {
        String registeredTimeString;

        registeredTimeString = Movie.builder()
                .id(1)
                .title("Pulp Fiction")
                .description("Pulp Fiction is a 1994 American crime film written and directed by Quentin Tarantino, who conceived it with Roger Avary.[4] " +
                        "Starring John Travolta, Samuel L. Jackson, Bruce Willis, Tim Roth, Ving Rhames, and Uma Thurman, it tells several stories of crime " +
                        "in Los Angeles. The title refers to the pulp magazines and hardboiled crime novels popular during the mid-20th century, " +
                        "known for their graphic violence and punchy dialogue.")
                .registeredAt(LocalDateTime.now())
                .build().getRegisteredAt().toString();
        Assert.isTrue(registeredTimeString.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}"), "Wrong Format");
    }
}