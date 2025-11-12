package bem_estar_animal.tcc.MVC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Animal;
import bem_estar_animal.tcc.MVC.repository.AnimalRepository;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimais() {
        return animalRepository.findAll();
    }

}
