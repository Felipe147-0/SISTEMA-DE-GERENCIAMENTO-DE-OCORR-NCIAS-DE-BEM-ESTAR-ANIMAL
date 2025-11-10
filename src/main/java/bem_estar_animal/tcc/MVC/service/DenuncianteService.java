package bem_estar_animal.tcc.MVC.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.repository.DenuncianteRepository;
import bem_estar_animal.tcc.MVC.repository.EnderecoRepository;
import bem_estar_animal.tcc.MVC.repository.FichaRepository;

@Service
public class DenuncianteService {

    private DenuncianteRepository denuncianteRepository;
    private EnderecoRepository enderecoRepository;
    private FichaRepository fichaRepository;

    public DenuncianteService(DenuncianteRepository denuncianteRepository, EnderecoRepository enderecoRepository,
            FichaRepository fichaRepository) {
        this.denuncianteRepository = denuncianteRepository;
        this.enderecoRepository = enderecoRepository;
        this.fichaRepository = fichaRepository;
    }

    public List<Denunciante> getAllDenunciante() {
        return denuncianteRepository.findAll();
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

    public void createDenunciante(Denunciante denunciante) {
        denuncianteRepository.save(denunciante);
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

    public Optional<Denunciante> encontrarPorId(Long id) {
        return denuncianteRepository.findById(id);
    }

}
