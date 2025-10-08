package bem_estar_animal.tcc.restfull.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bem_estar_animal.tcc.MVC.model.Funcionario;
import bem_estar_animal.tcc.MVC.service.FuncionarioService;
import bem_estar_animal.tcc.restfull.record.FuncionarioRecord;

@RestController
@RequestMapping("/api/funcionario")
public class RestFuncionarioController {

    private FuncionarioService funcionarioService;

    public RestFuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
        List<Funcionario> funcionarioList = funcionarioService.getAllFuncionarios();
        return ResponseEntity.ok().body(funcionarioList);
    }

    @PostMapping("/criar")
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody FuncionarioRecord funcionarioRecord) {

        Funcionario funcionario = funcionarioService.createFuncionario(funcionarioRecord);
        return ResponseEntity.ok().body(funcionario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id,
            @RequestBody FuncionarioRecord funcionarioRecord) {

        Funcionario funcionario = funcionarioService.updateFuncionario(id, funcionarioRecord);
        return ResponseEntity.ok().body(funcionario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        boolean deletedFuncionario = funcionarioService.deleteFuncionario(id);

        if (deletedFuncionario == false) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

}
