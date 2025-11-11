package bem_estar_animal.tcc.thymeleaf;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.model.ListaExclusao;
import bem_estar_animal.tcc.MVC.service.DenuncianteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/listaExclusao")
public class ListaExclusaoController {

    private DenuncianteService denuncianteService;

    public ListaExclusaoController(DenuncianteService denuncianteService) {
        this.denuncianteService = denuncianteService;
    }

    @ModelAttribute("listaExclusao")
    public ListaExclusao listaExclusao(){
        return new ListaExclusao();
    }

    @GetMapping("/buscar")
    public String buscarDenunciatesExcluidos(Model model,
            @RequestParam(name = "query", required = false) String query) {
        List<Denunciante> denuncianteList;

        if (query != null && !query.isEmpty()) {
            denuncianteList = denuncianteService.busca(query);

            if (denuncianteList.isEmpty()) {
                denuncianteList = denuncianteService.getDenunciantePorEmLista();
            }

        } else {
            denuncianteList = denuncianteService.getDenunciantePorEmLista();
        }

        model.addAttribute("denuncianteList", denuncianteList);

        return "listaExclusao-home";
    }
}
