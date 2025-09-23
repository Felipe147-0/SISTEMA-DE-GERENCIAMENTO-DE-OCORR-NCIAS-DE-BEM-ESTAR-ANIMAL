package bem_estar_animal.tcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bem_estar_animal.tcc.model.Ficha;
import bem_estar_animal.tcc.record.FichaRecord;
import bem_estar_animal.tcc.service.FichaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ficha")
public class FichaController {

    private FichaService fichaService;

    public FichaController(FichaService fichaService){
        this.fichaService = fichaService;
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<Ficha>> getAllFichas() {
        List<Ficha> fichaList = fichaService.getAllFichas();
        return ResponseEntity.ok().body(fichaList);
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> createFicha(@RequestBody FichaRecord fichaRecord) {
        fichaService.createFicha(fichaRecord);
        return ResponseEntity.ok().build();
    }
    

}
