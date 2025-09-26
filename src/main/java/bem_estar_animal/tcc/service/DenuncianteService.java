package bem_estar_animal.tcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Denunciante;
import bem_estar_animal.tcc.model.Endereco;
import bem_estar_animal.tcc.record.DenuncianteRecord;
import bem_estar_animal.tcc.repository.DenuncianteRepository;

@Service
public class DenuncianteService {

    private DenuncianteRepository denuncianteRepository;
    private EnderecoService enderecoService;

    public DenuncianteService(DenuncianteRepository denuncianteRepository, EnderecoService enderecoService) {
        this.denuncianteRepository = denuncianteRepository;
        this.enderecoService = enderecoService;
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

        Endereco enderecoFound = enderecoService.findEnderecoById(denuncianteRecord.endereco());
        denunciante.setEndereco(enderecoFound);

        denuncianteRepository.save(denunciante);

        return denunciante;
    }

}
