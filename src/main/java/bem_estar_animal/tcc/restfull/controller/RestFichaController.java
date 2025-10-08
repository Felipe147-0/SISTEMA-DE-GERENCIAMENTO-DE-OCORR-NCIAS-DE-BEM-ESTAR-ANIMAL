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

import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.service.FichaService;
import bem_estar_animal.tcc.restfull.record.FichaRecord;

@RestController
@RequestMapping("/api/ficha")
public class RestFichaController {

    private FichaService fichaService;

    public RestFichaController(FichaService fichaService) {
        this.fichaService = fichaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Ficha>> getAllFichas() {
        List<Ficha> fichaList = fichaService.getAllFichas();
        return ResponseEntity.ok().body(fichaList);
    }

    @PostMapping("/criar")
    public ResponseEntity<Ficha> createFicha(@RequestBody FichaRecord fichaRecord) {
        Ficha ficha = fichaService.createFicha(fichaRecord);
        return ResponseEntity.ok().body(ficha);// TODO nao retornar o objeto criado. Colocar redirect
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ficha> updateFicha(@PathVariable Long id, @RequestBody FichaRecord fichaRecord) {
        Ficha ficha = fichaService.updateFicha(id, fichaRecord);
        return ResponseEntity.ok().body(ficha);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFicha(@PathVariable Long id){
        fichaService.deleteFicha(id);
        return ResponseEntity.noContent().build();
    }

}
