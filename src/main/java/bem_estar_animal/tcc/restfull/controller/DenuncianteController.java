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

import bem_estar_animal.tcc.restfull.model.Denunciante;
import bem_estar_animal.tcc.restfull.record.DenuncianteRecord;
import bem_estar_animal.tcc.restfull.service.DenuncianteService;

@RestController
@RequestMapping("/denunciante")
public class DenuncianteController {

    private DenuncianteService denuncianteService;

    public DenuncianteController(DenuncianteService denuncianteService) {
        this.denuncianteService = denuncianteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Denunciante>> getAllDenunciante() {
        List<Denunciante> denuncianteList = denuncianteService.getAllDenunciante();
        return ResponseEntity.ok().body(denuncianteList);
    }

    @PostMapping("/criar")
    public ResponseEntity<Denunciante> createDenunciante(@RequestBody DenuncianteRecord denuncianteRecord) {
        Denunciante denunciante = denuncianteService.createDenunciante(denuncianteRecord);// TODO nao retornar o objeto
                                                                                          // criado. Colocar redirect
        return ResponseEntity.ok().body(denunciante);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Denunciante> updateDununciante(@PathVariable Long id, @RequestBody DenuncianteRecord denuncianteRecord) {
        Denunciante denunciante = denuncianteService.updateDununciante(id, denuncianteRecord);//TODO nao retornar o objeto criado. Colocar redirect
        return ResponseEntity.ok().body(denunciante);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDununciante (@PathVariable Long id){
        boolean deletedDununciante = denuncianteService.deleteDununciante(id);

        if (deletedDununciante == false) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
