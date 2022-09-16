package challengeWebDevelopementSetembro2022.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/test/hello")
public class HelloResource
{
    @GetMapping()
    public ResponseEntity<String> getHello()
    {
        return (ResponseEntity.ok("Hello World"));
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<String> getHelloWithNameParam(@PathVariable("name") String name)
    {
        return (ResponseEntity.ok("Hello World and " + name));
    }

    @PostMapping(value = "/body", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBody> postBodyWithName(@Valid @RequestBody ApiRequestBody obj)
    {
        return (ResponseEntity.accepted().body(ResponseBody.builder()
                .message("Hello, " + obj.getName())
                .processedAt(LocalDateTime.now())
                .build()));
    }
}

@Data
class ApiRequestBody
{
    @NotNull
    private String name;
}

@Data
@Builder
@AllArgsConstructor
class ResponseBody
{
    private String message;
    private LocalDateTime processedAt;

    public LocalDateTime getProcessedAt()
    {
        return (processedAt.truncatedTo(ChronoUnit.SECONDS));
    }
}