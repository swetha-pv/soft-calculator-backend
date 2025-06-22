
import org.springframework.web.bind.annotation.*;
import javax.script.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CalculatorController {

    @PostMapping("/calculate")
    public String calculate(@RequestBody String expression) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            Object result = engine.eval(expression);
            return result.toString();
        } catch (Exception e) {
            return "Error";
        }
    }
}
