package bem_estar_animal.tcc.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.service.DenuncianteService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/denunciante")
public class DenuncianteController {

    private DenuncianteService denuncianteService;

    public DenuncianteController(DenuncianteService denuncianteService) {
        this.denuncianteService = denuncianteService;
    }

    @GetMapping("/listar")
    public String getAllDenunciantes() {
        List<Denunciante> denuncianteList = denuncianteService.getAllDenunciante();
        return "home";
    }

}
