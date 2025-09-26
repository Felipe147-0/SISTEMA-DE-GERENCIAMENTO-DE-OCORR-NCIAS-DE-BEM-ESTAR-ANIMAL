package bem_estar_animal.tcc.service;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Funcionario;
import bem_estar_animal.tcc.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario findFuncionarioById(Long funcionarioId) {
        Funcionario funcionarioFound = funcionarioRepository.findById(funcionarioId).get();
        return funcionarioFound;
    }
}
