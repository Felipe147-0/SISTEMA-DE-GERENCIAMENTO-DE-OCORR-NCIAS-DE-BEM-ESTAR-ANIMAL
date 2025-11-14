package bem_estar_animal.tcc.MVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.model.ListaExclusao;
import bem_estar_animal.tcc.MVC.repository.DenuncianteRepository;
import bem_estar_animal.tcc.MVC.repository.ListaDeExclusaoRepository;
import jakarta.transaction.Transactional;

@Service
public class ListaExclusaoService {
    
    private ListaDeExclusaoRepository listaExclusaoRepository;
    private DenuncianteRepository denuncianteRepository;

    public ListaExclusaoService(ListaDeExclusaoRepository exclusaoRepository, DenuncianteRepository denuncianteRepository) {
        this.listaExclusaoRepository = exclusaoRepository;
        this.denuncianteRepository = denuncianteRepository;
    }

    public Optional<ListaExclusao> getListaByid(Long id) {
        return listaExclusaoRepository.findById(id);
    }

    public ListaExclusao getListaByDenunciante(Denunciante denunciante) {
        return listaExclusaoRepository.findByDenuncianteId(denunciante.getId_denunciante());
    }

    @Transactional
    public void removerDenuncianteDaLista(Long idDenunciante) {
        listaExclusaoRepository.deleteDenuncianteDaLista(idDenunciante);
     
        Denunciante denunciante = denuncianteRepository.findById(idDenunciante).get();
        denunciante.setEmLista(false);
        denuncianteRepository.save(denunciante);
    }
}
