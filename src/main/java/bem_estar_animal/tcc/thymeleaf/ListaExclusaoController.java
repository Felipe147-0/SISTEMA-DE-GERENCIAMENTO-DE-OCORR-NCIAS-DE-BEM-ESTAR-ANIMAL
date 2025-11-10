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
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/listaExclusao")
public class ListaExclusaoController {

    private DenuncianteService denuncianteService;
    private ListaExclusaoService exclusaoService;

    public ListaExclusaoController(DenuncianteService denuncianteService, ListaExclusaoService exclusaoService) {
        this.denuncianteService = denuncianteService;
        this.exclusaoService = exclusaoService;
    }

    @GetMapping("/buscar")
    public String buscarDenunciatesExcluidos(Model model,
            @RequestParam(name = "query", required = false) String query) {
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

        return "listaExclusao-home";
    }

    @PostMapping("/adicionarLista")
    public String adicionarLista(@RequestParam Long listaExclusao, @RequestParam Long idDenunciante) {
        Optional<ListaExclusao> listOptional = exclusaoService.getListaByid(listaExclusao);
        Optional<Denunciante> denuncianteOptional = denuncianteService.encontrarPorId(idDenunciante);

        if (listOptional.isPresent() && denuncianteOptional.isPresent()) {
            Denunciante denunciante = denuncianteOptional.get();

            denunciante.setListaExclusao(listOptional.get());
            denuncianteService.createDenunciante(denunciante);
        }

        return "redirect:/listaExclusao/buscar";
    }

    // @GetMapping("/criar")
    // public String criarLista(Model model) {
    //     ListaExclusao listaExclusao = new ListaExclusao();
    //     Denunciante denunciante = new Denunciante();

    //     // faz a associação
    //     denunciante.setListaExclusao(listaExclusao);
    //     listaExclusao.getDenunciantes().add(denunciante); // caso a listaExclusao tenha a lista de denunciantes

    //     model.addAttribute("listaExclusao", listaExclusao);
    //     return "listaExclusao-criar"; // template para criar a lista
    // }

    // @PostMapping("/criar")
    // public String salvarLista(@ModelAttribute ListaExclusao listaExclusao) {
    //     // CascadeType.PERSIST garante que o denunciante seja salvo junto
    //     exclusaoService.save(listaExclusao);
    //     return "redirect:/listaExclusao/buscar";
    // }

}
