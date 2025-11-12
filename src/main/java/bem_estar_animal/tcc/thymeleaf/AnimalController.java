package bem_estar_animal.tcc.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import bem_estar_animal.tcc.MVC.model.Animal;
import bem_estar_animal.tcc.MVC.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/animal")
@SessionAttributes("animal")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ModelAttribute("animal")
    public Animal animal() {
        return new Animal();
    }

    @GetMapping("/buscar")
    public String animalBuscar(Model model) {
        List<Animal> animalList = animalService.getAllAnimais();
        model.addAttribute(animalList);
        return "animal-buscar";
    }

    @GetMapping("/cadastro")
    public String cadastrarAnimal(Model model) {
        Animal animal = animalService.criarAnimal();
        model.addAttribute(animal);
        return "animal-cadastro";
    }

    @PostMapping("/salvar")
    public String salvarAnimal(@ModelAttribute Animal animal, Errors errors) {
        animalService.salvarAnimal(animal);
        return "redirect:/administracao";
    }
    

}
