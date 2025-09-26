package bem_estar_animal.tcc.controller;

import org.springframework.web.bind.annotation.RestController;

import bem_estar_animal.tcc.model.Endereco;
import bem_estar_animal.tcc.record.EnderecoRecord;
import bem_estar_animal.tcc.service.EnderecoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Endereco>> getAllEndereco() {
        List<Endereco> enderecoList = enderecoService.getAllEndereco();
        return ResponseEntity.ok().body(enderecoList);
    }

    @PostMapping("/criar")
    public ResponseEntity<Endereco> createEndereco(@RequestBody EnderecoRecord enderecoRecord) {
        Endereco endereco = enderecoService.createEndereco(enderecoRecord);//TODO nao retornar o objeto criado. Colocar redirect
        return ResponseEntity.ok().body(endereco);
    }
    
    
}
