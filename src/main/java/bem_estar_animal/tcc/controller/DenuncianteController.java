package bem_estar_animal.tcc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bem_estar_animal.tcc.model.Denunciante;
import bem_estar_animal.tcc.record.DenuncianteRecord;
import bem_estar_animal.tcc.service.DenuncianteService;

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

        Denunciante denunciante = denuncianteService.createDenunciante(denuncianteRecord);//TODO nao retornar o objeto criado. Colocar redirect
        return ResponseEntity.ok().body(denunciante);
    }

}
