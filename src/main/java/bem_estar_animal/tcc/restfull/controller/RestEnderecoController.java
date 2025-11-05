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

import bem_estar_animal.tcc.MVC.model.Endereco;
import bem_estar_animal.tcc.MVC.service.EnderecoService;
import bem_estar_animal.tcc.restfull.record.EnderecoRecord;

@RestController
@RequestMapping("/api/endereco")
public class RestEnderecoController {

    // private EnderecoService enderecoService;

    // public RestEnderecoController(EnderecoService enderecoService) {
    //     this.enderecoService = enderecoService;
    // }

    // @GetMapping("/listar")
    // public ResponseEntity<List<Endereco>> getAllEndereco() {
    //     List<Endereco> enderecoList = enderecoService.getAllEndereco();
    //     return ResponseEntity.ok().body(enderecoList);
    // }

    // @PostMapping("/criar")
    // public ResponseEntity<Endereco> createEndereco(@RequestBody EnderecoRecord enderecoRecord) {
    //     Endereco endereco = enderecoService.createEndereco(enderecoRecord);// TODO nao retornar o objeto criado. Colocar
    //                                                                        // redirect
    //     return ResponseEntity.ok().body(endereco);
    // }

    // @PutMapping("/update/{id}")
    // public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id,
    //         @RequestBody EnderecoRecord enderecoRecord) {
    //     Endereco endereco = enderecoService.updateEndereco(id, enderecoRecord);
    //     return ResponseEntity.ok().body(endereco);
    // }

    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
    //     enderecoService.deleteEndereco(id);
    //     return ResponseEntity.noContent().build();
    // }
}
