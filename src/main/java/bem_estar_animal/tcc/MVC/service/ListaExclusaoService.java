package bem_estar_animal.tcc.MVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.model.ListaExclusao;
import bem_estar_animal.tcc.MVC.repository.ListaDeExclusaoRepository;

@Service
public class ListaExclusaoService {
    
    private ListaDeExclusaoRepository listaExclusaoRepository;

    public ListaExclusaoService(ListaDeExclusaoRepository exclusaoRepository) {
        this.listaExclusaoRepository = exclusaoRepository;
    }

    public Optional<ListaExclusao> getListaByid(Long id) {
        return listaExclusaoRepository.findById(id);
    }

    public ListaExclusao getListaByDenunciante(Denunciante denunciante) {
        return listaExclusaoRepository.findByDenuncianteId(denunciante.getId_denunciante());
    }
}
