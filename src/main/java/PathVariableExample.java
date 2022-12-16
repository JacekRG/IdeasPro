import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("path-variable-example")
public class PathVariableExample {

    @GetMapping
    String mainPath() {
        return "main-path";
    }

    @GetMapping("{id}")
    String withSingleVariable(@PathVariable String id) {
        return "single variable => " + id;
    }

    @GetMapping("/int/{id}")
    String withSingleIntVariable(@PathVariable int id) {
        return "single int variable => " + id;
    }

    @GetMapping("/without-mapping/{id}")
    String withSingleVariableWithoutMapping(String id) {
        return "single variable without mapping => " + id;
    }

}
