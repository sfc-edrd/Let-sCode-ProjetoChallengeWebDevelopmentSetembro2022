package challengeWebDevelopementSetembro2022.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource
{
    @GetMapping("/test/hello")
    public ResponseEntity< String> getHello()
    {
        return (ResponseEntity.ok("Hello World"));
    }
}
