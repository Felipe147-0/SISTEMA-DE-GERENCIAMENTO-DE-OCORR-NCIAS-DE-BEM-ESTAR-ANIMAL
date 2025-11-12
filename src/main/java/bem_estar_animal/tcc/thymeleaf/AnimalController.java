package bem_estar_animal.tcc.thymeleaf;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import bem_estar_animal.tcc.MVC.model.Animal;
import bem_estar_animal.tcc.MVC.model.TipoAnimalEnum;
import bem_estar_animal.tcc.MVC.service.AnimalService;

@Controller
@RequestMapping("/animal")
@SessionAttributes("animal")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ModelAttribute("animal")
    public Animal animal() {
        return new Animal();
    }

    @GetMapping("/buscar")
    public String animalBuscar(Model model,
                               @RequestParam(name = "query", required = false) String query) {
        List<Animal> animalList;

        if (query != null && !query.isEmpty()) {
            animalList = animalService.busca(query);

            if (animalList.isEmpty()) {
                animalList = animalService.getAllAnimais();
            }
        } else {
            animalList = animalService.getAllAnimais();
        }

        model.addAttribute("animalList", animalList);
        return "animal-buscar";
    }

    @GetMapping("/cadastro")
    public String cadastrarAnimal(Model model) {
        Animal animal = animalService.criarAnimal();
        List<TipoAnimalEnum> tipoAnimalEnums = Arrays.asList(TipoAnimalEnum.values());

        model.addAttribute("animal", animal);
        model.addAttribute("tipoAnimalEnums", tipoAnimalEnums);
        return "animal-cadastro";
    }

    @GetMapping("/perfil/{id}")
    public String animalPerfil(@PathVariable Long id, Model model) {
        Optional<Animal> animalOptional = animalService.encontrarPorId(id);
        if (animalOptional.isPresent()) {
            model.addAttribute("animal", animalOptional.get());
        }

        List<TipoAnimalEnum> tipoAnimalEnums = Arrays.asList(TipoAnimalEnum.values());
        model.addAttribute("tipoAnimalEnums", tipoAnimalEnums);

        return "animal-perfil";
    }

    @PostMapping("/salvar")
    public String salvarAnimal(@ModelAttribute Animal animal, Errors errors) {
        animalService.salvarAnimal(animal);
        return "redirect:/animal/perfil/" + animal.getIdAnimal();
    }

    @GetMapping("/animais/gerar-chip")
    @ResponseBody
    public String gerarChip(@RequestParam(required = false) Long idAnimal) {
        Animal animal;

        if (idAnimal != null) { 
            Optional<Animal> animalOpt = animalService.encontrarPorId(idAnimal);
            if (animalOpt.isEmpty()) return "ERRO";
            animal = animalOpt.get();
        } else { 
            animal = new Animal(); 
        }

        String chip = animalService.gerarChip();
        animal.setNumeroChip(chip);
        animal.setPossuiChip(true);

        if (idAnimal != null) {
            animalService.salvarAnimal(animal);
        }

        return chip;
    }

    @PostMapping("/animais/remover-chip")
    @ResponseBody
    public String removerChip(@RequestParam Long idAnimal) {
        animalService.removerChip(idAnimal);
        return "OK";
    }
}
