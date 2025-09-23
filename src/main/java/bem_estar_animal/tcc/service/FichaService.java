package bem_estar_animal.tcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Ficha;
import bem_estar_animal.tcc.repository.FichaRepository;

@Service
public class FichaService {

    private FichaRepository fichaRepository;

    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }

    public List<Ficha> getAllFichas() {
        return null;
    }

}
