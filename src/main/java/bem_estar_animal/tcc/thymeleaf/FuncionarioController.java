package bem_estar_animal.tcc.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bem_estar_animal.tcc.MVC.model.Funcionario;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @GetMapping("/criar")
    public String criarFuncioanrio(Model model) {
        Funcionario funcionario = new Funcionario();
        model.addAttribute(funcionario);
        return "funcionario-criarFuncionario";
    }
    
}
