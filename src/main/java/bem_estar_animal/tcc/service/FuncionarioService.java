package bem_estar_animal.tcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Funcionario;
import bem_estar_animal.tcc.model.Login;
import bem_estar_animal.tcc.record.FuncionarioRecord;
import bem_estar_animal.tcc.repository.FuncionarioRepository;
import bem_estar_animal.tcc.repository.LoginRepository;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private LoginRepository loginRepository;
    
    public FuncionarioService(FuncionarioRepository funcionarioRepository, LoginRepository loginRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.loginRepository = loginRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario createFuncionario(Long id, FuncionarioRecord funcionarioRecord) {
        Funcionario funcionario = new Funcionario(
            null,
            funcionarioRecord.nome(),
            funcionarioRecord.registro(),
            funcionarioRecord.funcao(),
            null,
            null 
        );

        if (funcionarioRecord.loginId() != null && funcionarioRecord.loginId() != 0) {
            Login loginFound = loginRepository.findById(funcionarioRecord.loginId()).get();
            funcionario.setLogin(loginFound);
        }

        funcionarioRepository.save(funcionario);

        return funcionario;
    }

    public Funcionario updateFuncionario(Long id, FuncionarioRecord funcionarioRecord) {
        Funcionario funcionario = funcionarioRepository.findById(id).get();

        if (funcionarioRecord.nome() != null && funcionarioRecord.nome().isBlank()) {
            funcionario.setNome(funcionarioRecord.nome());
        }

        if (funcionarioRecord.registro() != null && funcionarioRecord.registro().isBlank()) {
            funcionario.setRegistro(funcionarioRecord.registro());
        }

        if (funcionarioRecord.funcao() != null && funcionarioRecord.funcao().isBlank()) {
            funcionario.setFuncao(funcionarioRecord.funcao());
        }

        if (funcionarioRecord.loginId() != null && funcionarioRecord.loginId() != 0) {
            Login loginFound = loginRepository.findById(funcionarioRecord.loginId()).get();
            funcionario.setLogin(loginFound);
        }

        funcionarioRepository.save(funcionario);

        return funcionario;
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
