package bem_estar_animal.tcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Funcionario;
import bem_estar_animal.tcc.model.Login;
import bem_estar_animal.tcc.model.Role;
import bem_estar_animal.tcc.record.LoginRecord;
import bem_estar_animal.tcc.repository.FuncionarioRepository;
import bem_estar_animal.tcc.repository.LoginRepository;
import bem_estar_animal.tcc.repository.RoleRepository;

@Service
public class LoginService {

    private LoginRepository loginRepository;
    private FuncionarioRepository funcionarioRepository;
    private RoleRepository roleRepository;

    public LoginService(LoginRepository loginRepository, FuncionarioRepository funcionarioRepository,
            RoleRepository roleRepository) {
        this.loginRepository = loginRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.roleRepository = roleRepository;
    }

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    public Login createLogin(LoginRecord loginRecord) {
        Login login = new Login(
                null,
                loginRecord.username(),
                loginRecord.password(),
                null,
                null);

        if (loginRecord.funcionarioId() != null && loginRecord.funcionarioId() != 0) {
            Funcionario funcionarioFound = funcionarioRepository.findById(loginRecord.funcionarioId()).get();
            login.setFuncionario(funcionarioFound);
        }

        if (loginRecord.roleId() != null && loginRecord.roleId() != 0) {
            Role roleFound = roleRepository.findById(loginRecord.roleId()).get();
            login.setRole(roleFound);
        }
        
        loginRepository.save(login);

        return login;
    }

    public Login updateLogin(Long id, LoginRecord loginRecord) {
        Login login = loginRepository.findById(id).get();
        
        if (loginRecord.username() != null && !loginRecord.username().isBlank()) {
            login.setUsername(loginRecord.username());
        }

        if (loginRecord.password() != null && !loginRecord.password().isBlank()) {
            login.setPassword(loginRecord.password());
        }

        if (loginRecord.funcionarioId() != null && loginRecord.funcionarioId() != 0) {
            Funcionario funcionarioId = funcionarioRepository.findById(loginRecord.funcionarioId()).get();
            login.setFuncionario(funcionarioId);
        }

        if (loginRecord.roleId() != null && loginRecord.roleId() != 0) {
            Role roleId = roleRepository.findById(loginRecord.roleId()).get();
            login.setRole(roleId);
        }

        loginRepository.save(login);

        return login;
    }

    public boolean deleteLogin(Long id) {
        Login loginFound = loginRepository.findById(id).get();

        if (loginFound != null) {
            loginRepository.delete(loginFound);
            return true;
        }else{
            return false;
        }
    }

}
