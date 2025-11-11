package bem_estar_animal.tcc.MVC.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.model.ListaExclusao;
import bem_estar_animal.tcc.MVC.repository.DenuncianteRepository;
import bem_estar_animal.tcc.MVC.repository.ListaDeExclusaoRepository;

@Service
public class DenuncianteService {

    private DenuncianteRepository denuncianteRepository;
    private ListaDeExclusaoRepository listaExclusaoRepository;

    public DenuncianteService(DenuncianteRepository denuncianteRepository,
            ListaDeExclusaoRepository deExclusaoRepository) {
        this.denuncianteRepository = denuncianteRepository;
        this.listaExclusaoRepository = deExclusaoRepository;
    }

    public List<Denunciante> getAllDenunciante() {
        return denuncianteRepository.findAll();
    }

    public List<Denunciante> getDenunciantePorEmLista() {
        return denuncianteRepository.findByEmListaTrue();
    }

    public Optional<Denunciante> encontrarPorId(Long id) {
        return denuncianteRepository.findById(id);
    }

    public void createDenunciante(Denunciante denunciante) {
        denuncianteRepository.save(denunciante);
    }

    public void adicionarAListaDeExclusao(Denunciante denunciante, String observacao){
        ListaExclusao listaExclusao = new ListaExclusao();
        listaExclusao.setObservacao(observacao);
        listaExclusao.setDenunciante(denunciante);
        
        denunciante.setEmLista(true);
        
        listaExclusaoRepository.save(listaExclusao);
        denuncianteRepository.save(denunciante);
    }

    public List<Denunciante> busca(String query) {
        if (query.matches("\\d+")) {
            List<Denunciante> encontradoPorCpf = denuncianteRepository.findByCpf(query);

            if (!encontradoPorCpf.isEmpty()) {
                return encontradoPorCpf;
            }

        } else if (query.matches("\\w+")) {
            List<Denunciante> encontradoPorNome = denuncianteRepository.findByNome("%" + query + "%");

            if (!encontradoPorNome.isEmpty()) {
                return encontradoPorNome;
            }
        }

        return Collections.emptyList();
    }

    public boolean deleteDununciante(Long id) {
        Denunciante denunciante = denuncianteRepository.findById(id).get();

        if (denunciante != null) {
            denuncianteRepository.delete(denunciante);
            return true;
        } else {
            return false;
        }
    }
}
