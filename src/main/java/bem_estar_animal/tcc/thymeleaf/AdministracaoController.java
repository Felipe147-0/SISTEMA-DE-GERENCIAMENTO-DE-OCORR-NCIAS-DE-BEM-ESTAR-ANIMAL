package bem_estar_animal.tcc.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/administracao")
public class AdministracaoController {

    @GetMapping()
    public String viewHome() {
        return "administracao-home";
    }
    

}
