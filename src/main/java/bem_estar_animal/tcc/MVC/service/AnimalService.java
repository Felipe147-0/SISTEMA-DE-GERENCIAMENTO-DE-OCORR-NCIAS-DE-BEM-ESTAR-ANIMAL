package bem_estar_animal.tcc.MVC.service;

import java.time.MonthDay;
import java.time.Year;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Animal;
import bem_estar_animal.tcc.MVC.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

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
        int ano = Year.now().getValue();
        int mes = MonthDay.now().getMonthValue();
        int dia = MonthDay.now().getDayOfMonth();
        int numero = 1;

        String chip;
        do {
            chip = String.format("CHIP-%d%d%d-%04d", ano, mes, dia, numero);
            numero++;
        } while (animalRepository.existsByNumeroChip(chip));

        return chip;
    }

    public Animal criarAnimal() {
        Animal animal = new Animal();
        animal.setRegistro(gerarRegistro());
        animal.setPossuiChip(false);
        return animal;
    }

    public void salvarAnimal(Animal animal) {
        if (animal.getNumeroChip() == null || animal.getNumeroChip().isBlank()) {
            animal.setPossuiChip(false);
        } else {
            animal.setPossuiChip(true);
        }

        animalRepository.save(animal);
    }

    public void removerChip(Long idAnimal) {
        Optional<Animal> animalOpt = animalRepository.findById(idAnimal);
        animalOpt.ifPresent(animal -> {
            animal.setNumeroChip(null);
            animal.setPossuiChip(false);
            animalRepository.save(animal);
        });
    }

    public Optional<Animal> encontrarPorId(Long id) {
        return animalRepository.findById(id);
    }

    public List<Animal> busca(String query) {
        if (query.matches("\\d+")) {
            List<Animal> encontradoPorChip = animalRepository.findByNumeroChipContaining(query);
            if (!encontradoPorChip.isEmpty()) {
                return encontradoPorChip;
            }
        } else {
            List<Animal> encontradoPorRegistro = animalRepository.findByRegistroContainingIgnoreCase(query);
            if (!encontradoPorRegistro.isEmpty()) {
                return encontradoPorRegistro;
            }
        }

        return Collections.emptyList();
    }
}
