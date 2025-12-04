package bem_estar_animal.tcc.MVC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Funcionario;
import bem_estar_animal.tcc.MVC.repository.FuncionarioRepository;


@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void createFuncionario(Funcionario funcionarioRecebido) {
        Funcionario funcionario = new Funcionario(
            null,
            funcionarioRecebido.getNome(),
            funcionarioRecebido.getRegistro(),
            funcionarioRecebido.getFuncao(),
            null,
            funcionarioRecebido.getSetor(),
            funcionarioRecebido.getCpf(),
            funcionarioRecebido.getTelefone(),
            funcionarioRecebido.getEndereco()
        );

        funcionarioRepository.save(funcionario);
    }



    public boolean deleteFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).get();

        if (funcionario != null) {
            funcionarioRepository.delete(funcionario);
            return true;
        }else{
            return false;
        }
    }

}
