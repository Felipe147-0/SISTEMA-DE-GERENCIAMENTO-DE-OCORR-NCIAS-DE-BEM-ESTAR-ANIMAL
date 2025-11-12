package bem_estar_animal.tcc.MVC.service;

import java.time.MonthDay;
import java.time.Year;
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

    public String gerarRegistro() {
        int numero = animalRepository.contarAnimais() + 1; 
        int ano = Year.now().getValue();
        int mes = MonthDay.now().getMonthValue();
        int dia = MonthDay.now().getDayOfMonth();
        return String.format("ANI-%d%d%d-%04d", ano, mes, dia, numero);
    }

    public String gerarChip() {
        int numero = animalRepository.contarAnimais() + 1; 
        int ano = Year.now().getValue();
        int mes = MonthDay.now().getMonthValue();
        int dia = MonthDay.now().getDayOfMonth();
        return String.format("CHIP-%d%d%d-%04d", ano, mes, dia, numero);
    }

    public Animal criarAnimal(){
        Animal animal = new Animal();

        String registro = gerarRegistro();
        String chip = gerarChip();
        
        animal.setRegistro(registro);
        animal.setNumeroChip(chip);

        return animal;
    }

    public void salvarAnimal(Animal animal) {
        animalRepository.save(animal);
    }

}
