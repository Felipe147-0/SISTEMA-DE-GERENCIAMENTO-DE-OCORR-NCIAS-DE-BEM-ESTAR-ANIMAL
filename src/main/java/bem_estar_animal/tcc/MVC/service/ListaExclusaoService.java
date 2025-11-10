package bem_estar_animal.tcc.MVC.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.ListaExclusao;
import bem_estar_animal.tcc.MVC.repository.ListaDeExclusaoRepository;

@Service
public class ListaExclusaoService {
    
    private ListaDeExclusaoRepository exclusaoRepository;

    public ListaExclusaoService(ListaDeExclusaoRepository exclusaoRepository) {
        this.exclusaoRepository = exclusaoRepository;
    }

    public Optional<ListaExclusao> getListaByid(Long id) {
        return exclusaoRepository.findById(id);
    }
}
