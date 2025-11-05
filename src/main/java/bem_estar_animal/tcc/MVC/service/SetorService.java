package bem_estar_animal.tcc.MVC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Setor;
import bem_estar_animal.tcc.MVC.repository.SetorRepository;

@Service
public class SetorService {
  
    private SetorRepository setorRepository;

    public SetorService (SetorRepository setorRepository){
        this.setorRepository = setorRepository;
    }

    public List<Setor> getAllSetores(){
        return setorRepository.findAll();
    }
}
