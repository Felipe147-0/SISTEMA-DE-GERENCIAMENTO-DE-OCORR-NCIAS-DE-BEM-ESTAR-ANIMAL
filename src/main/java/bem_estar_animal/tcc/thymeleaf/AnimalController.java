package bem_estar_animal.tcc.thymeleaf;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import bem_estar_animal.tcc.MVC.model.Animal;
import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
    public String animalBuscar(Model model, @RequestParam(name = "query", required = false) String query) {
        List<Animal> animalList;

        if(query != null && !query.isEmpty()){
            animalList = animalService.busca(query);

            if(animalList.isEmpty()){
                animalList = animalService.getAllAnimais();
            }

        }else{
            animalList = animalService.getAllAnimais();
        }

        model.addAttribute("animalList", animalList);
        return "animal-buscar";
    }

    @GetMapping("/cadastro")
    public String cadastrarAnimal(Model model) {
        Animal animal = animalService.criarAnimal();
        model.addAttribute(animal);
        return "animal-cadastro";
    }

    @GetMapping("/perfil/{id}")
    public String animalPerfil(@PathVariable Long id, Model model) {
        Optional<Animal> animalOptional = animalService.encontrarPorId(id);

        if (animalOptional.isPresent()) {
            model.addAttribute("animal", animalOptional.get());
        }

        return "animal-perfil";
    }

    @PostMapping("/salvar")
    public String salvarAnimal(@ModelAttribute Animal animal, Errors errors) {
        animalService.salvarAnimal(animal);
        return "redirect:/animal/perfil/" + animal.getIdAnimal();
    }
    

}
