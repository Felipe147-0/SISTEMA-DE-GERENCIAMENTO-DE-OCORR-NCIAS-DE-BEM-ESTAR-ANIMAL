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
import bem_estar_animal.tcc.MVC.service.ListaExclusaoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/listaExclusao")
public class ListaExclusaoController {

    private ListaExclusaoService listaExclusaoService;
    private DenuncianteService denuncianteService;

    public ListaExclusaoController(DenuncianteService denuncianteService, ListaExclusaoService listaExclusaoService) {
        this.denuncianteService = denuncianteService;
        this.listaExclusaoService = listaExclusaoService;
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

    @PostMapping("/remover/{id}")
    public String removerDenuncianteDaLista(@PathVariable("id") Long idDenunciante) {
        listaExclusaoService.removerDenuncianteDaLista(idDenunciante);
        return "redirect:/listaExclusao/buscar";
    }
    
}
