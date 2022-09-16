package challengeWebDevelopementSetembro2022.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
