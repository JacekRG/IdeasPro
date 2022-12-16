import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class RequestMappingExample {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(){
        return "Welcome EAI Team!";
    }

    @PostMapping
    public String post(){
        return  "post-method";
    }
    @PutMapping
    public String put(){
        return  "put-method";
    }
    @GetMapping(value = "get")
    public String get(){
        return  "get-method";
    }


}
