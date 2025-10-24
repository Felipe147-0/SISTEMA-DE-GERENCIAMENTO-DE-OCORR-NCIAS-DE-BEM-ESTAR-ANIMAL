package bem_estar_animal.tcc.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/ouvidoria")
public class OuvidoriaController {

    @GetMapping()
    public String viewHome() {
        return "ouvidoria-home";
    }
}
