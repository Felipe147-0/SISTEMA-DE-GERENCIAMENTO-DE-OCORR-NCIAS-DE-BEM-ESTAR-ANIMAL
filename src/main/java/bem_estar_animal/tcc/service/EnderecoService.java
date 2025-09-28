package bem_estar_animal.tcc.service;

import java.util.List;
import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Endereco;
import bem_estar_animal.tcc.record.EnderecoRecord;
import bem_estar_animal.tcc.repository.EnderecoRepository;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getAllEndereco() {
        return enderecoRepository.findAll();
    }

    public Endereco createEndereco(EnderecoRecord enderecoRecord) {
        Endereco endereco = new Endereco(null, enderecoRecord.logradouro(), enderecoRecord.bairro(),
                enderecoRecord.ponto_de_referencia(), null);

        enderecoRepository.save(endereco);

        return endereco;
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.findById(id).ifPresent(endereco -> enderecoRepository.delete(endereco));
    }

    public Endereco updateEndereco(Long id, EnderecoRecord enderecoRecord) {
        Endereco enderecoUpdate = enderecoRepository.findById(id).get();

        if (enderecoRecord.logradouro() != null) {
            enderecoUpdate.setLogradouro(enderecoRecord.logradouro());
        }

        if (enderecoRecord.bairro() != null) {
            enderecoUpdate.setBairro(enderecoRecord.bairro());
        }

        if (enderecoRecord.ponto_de_referencia() != null) {
            enderecoUpdate.setPonto_de_referencia(enderecoRecord.ponto_de_referencia());
        }

        enderecoRepository.save(enderecoUpdate);

        return enderecoUpdate;
    }

}
