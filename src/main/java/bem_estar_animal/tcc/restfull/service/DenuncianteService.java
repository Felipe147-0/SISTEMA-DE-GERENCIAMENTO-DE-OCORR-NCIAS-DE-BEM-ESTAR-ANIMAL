package bem_estar_animal.tcc.restfull.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.restfull.model.Denunciante;
import bem_estar_animal.tcc.restfull.model.Endereco;
import bem_estar_animal.tcc.restfull.model.Ficha;
import bem_estar_animal.tcc.restfull.record.DenuncianteRecord;
import bem_estar_animal.tcc.restfull.repository.DenuncianteRepository;
import bem_estar_animal.tcc.restfull.repository.EnderecoRepository;
import bem_estar_animal.tcc.restfull.repository.FichaRepository;

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

    public Denunciante createDenunciante(DenuncianteRecord denuncianteRecord) {
        Denunciante denunciante = new Denunciante(null,
                denuncianteRecord.nome(),
                denuncianteRecord.telefone(),
                null,
                null);

        if (denuncianteRecord.fichaId() != null && denuncianteRecord.fichaId() != 0) {
            Ficha fichaFound = fichaRepository.findById(denuncianteRecord.fichaId()).get();
            denunciante.setFicha(fichaFound);
        }

        if (denuncianteRecord.enderecoId() != null && denuncianteRecord.enderecoId() != 0) {
            Endereco enderecoFound = enderecoRepository.findById(denuncianteRecord.enderecoId()).get();
            denunciante.setEndereco(enderecoFound);
        }

        denuncianteRepository.save(denunciante);

        return denunciante;
    }

    public Denunciante updateDununciante(Long id, DenuncianteRecord denuncianteRecord) {
        Denunciante denunciante = denuncianteRepository.findById(id).get();

        if (denuncianteRecord.nome() != null && !denuncianteRecord.nome().isBlank()) {
            denunciante.setNome(denuncianteRecord.nome());
        }

        if (denuncianteRecord.telefone() != null && !denuncianteRecord.telefone().isBlank()) {
            denunciante.setTelefone(denuncianteRecord.telefone());
        }

        if (denuncianteRecord.nome() != null && !denuncianteRecord.nome().isBlank()) {
            denunciante.setNome(denuncianteRecord.nome());
        }

        denuncianteRepository.save(denunciante);

        return denunciante;
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
