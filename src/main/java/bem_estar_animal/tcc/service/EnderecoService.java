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

    public Endereco findById(Long id) {
        return findById(id);
    }

}
