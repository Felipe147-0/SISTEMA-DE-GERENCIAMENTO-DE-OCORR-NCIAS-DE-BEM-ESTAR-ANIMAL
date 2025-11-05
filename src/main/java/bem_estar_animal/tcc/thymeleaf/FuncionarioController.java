package bem_estar_animal.tcc.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import bem_estar_animal.tcc.MVC.model.Funcionario;
import bem_estar_animal.tcc.MVC.model.Setor;
import bem_estar_animal.tcc.MVC.service.FuncionarioService;
import bem_estar_animal.tcc.MVC.service.SetorService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private SetorService setorService;

    public FuncionarioController (FuncionarioService funcionarioService, SetorService setorService){
        this.funcionarioService = funcionarioService;
        this.setorService = setorService;
    }

    @GetMapping("/criar")
    public String criarFuncioanarioView(Model model) {
        Funcionario funcionario = new Funcionario();

        List<Setor> setoresList = setorService.getAllSetores();
        
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("setoresList", setoresList);

        return "funcionario-criarFuncionario";
    }

    @PostMapping("/criar")
    public String criarFuncioanario(@Valid @ModelAttribute Funcionario funcionario, Errors errors) {
        funcionarioService.createFuncionario(funcionario);
        return "redirect:/administracao";
    }
    
    
}
