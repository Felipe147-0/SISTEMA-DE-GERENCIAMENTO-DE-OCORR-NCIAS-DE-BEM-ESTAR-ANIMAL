package bem_estar_animal.tcc.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import bem_estar_animal.tcc.MVC.model.Animal;
import bem_estar_animal.tcc.MVC.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/animal")
@SessionAttributes("animal")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController (AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("/buscar")
    public String animalBuscar(Model model) {
        List<Animal> animalList = animalService.getAllAnimais();
        model.addAttribute(animalList);
        return "animal-buscar";
    }
    

}
