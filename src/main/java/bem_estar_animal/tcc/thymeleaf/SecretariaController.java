package bem_estar_animal.tcc.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.service.FichaService;
import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@SessionAttributes("ficha")//mantem o objeto em varias requisicoes
@RequestMapping("/secretaria")
public class SecretariaController {

    private FichaService fichaService;

    public SecretariaController(FichaService fichaService) {
        this.fichaService = fichaService;
    }

    @ModelAttribute(name = "ficha")//cria o objeto automaticamente 
    public Ficha ficha (){
        return new Ficha();
    }

    @GetMapping()
    public String viewHome(){
        return "secretaria-home";
    }

    @PostMapping("/novo")
    public String criarFicha(@Valid @ModelAttribute Ficha ficha, Errors errors, Model Model) {
        if (errors.hasErrors()) {
            return "home";
        }

        fichaService.createFicha(ficha);
        
        return "redirect:/secretaria-home";
    }
    
}
