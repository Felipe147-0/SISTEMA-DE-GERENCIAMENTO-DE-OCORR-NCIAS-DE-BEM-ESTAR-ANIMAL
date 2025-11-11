package bem_estar_animal.tcc.thymeleaf;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.service.DenuncianteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/denunciante")
@SessionAttributes("denunciante")
public class DenuncianteController {

    private DenuncianteService denuncianteService;

    public DenuncianteController(DenuncianteService denuncianteService) {
        this.denuncianteService = denuncianteService;
    }

    @ModelAttribute("denunciante")
    public Denunciante denunciante(){
        return new Denunciante();
    }

    @GetMapping("/buscar")
    public String denunciantesListar(Model model, @RequestParam(name = "query", required = false) String query) {
        List<Denunciante> denuncianteList;

        if (query != null && !query.isEmpty()) {
            denuncianteList = denuncianteService.busca(query);

            if (denuncianteList.isEmpty()) {
                denuncianteList = denuncianteService.getAllDenunciante();
            }

        } else {
            denuncianteList = denuncianteService.getAllDenunciante();
        }

        model.addAttribute("denuncianteList", denuncianteList);

        return "denunciante-buscar";
    }

    @GetMapping("/perfil/{id}")
    public String denunciantePerfil(@PathVariable Long id, Model model) {
        Optional<Denunciante> denunciante = denuncianteService.encontrarPorId(id);

        model.addAttribute("denunciante", denunciante.get());
        
        return "denunciante-perfil";
    }

    @PostMapping("/aprovar/{id}")
    public String colocarDenuncianteListaExclusao(@PathVariable("id") Long id, @RequestParam("em_lista") String em_lista) {
        Optional<Denunciante> denuncianteOpt = denuncianteService.encontrarPorId(id);

        if(denuncianteOpt.isPresent() && em_lista.equals("true")){
            Denunciante denunciante = denuncianteOpt.get();
            denunciante.setEmLista(true);
            denuncianteService.createDenunciante(denunciante);
        }
        return "redirect:/denunciante/perfil/" + id;
    }
    
}
