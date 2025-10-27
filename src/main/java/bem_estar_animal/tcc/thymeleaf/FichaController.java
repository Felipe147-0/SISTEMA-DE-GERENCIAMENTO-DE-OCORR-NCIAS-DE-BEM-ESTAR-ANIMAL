package bem_estar_animal.tcc.thymeleaf;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.model.Endereco;
import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.service.FichaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ficha")
@SessionAttributes("ficha")
public class FichaController {

    private FichaService fichaService;

    public FichaController(FichaService fichaService) {
        this.fichaService = fichaService;
    }

    @GetMapping("/criar")
    public String criarFicha(Model model) {
        // cria o Instant atual (UTC) e converte para o fuso de São Paulo
        Instant localDateTimeInstant = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant();
        ZonedDateTime dataHoraLocal = localDateTimeInstant.atZone(ZoneId.of("America/Sao_Paulo"));

        // formatar a data e a hora
        String dataAtual = dataHoraLocal.format(DateTimeFormatter.ofPattern("dd/MM/yyy"));
        String horaAtual = dataHoraLocal.format(DateTimeFormatter.ofPattern("HH:mm"));

        Ficha ficha = new Ficha();
        Denunciante denunciante = new Denunciante();
        Endereco endereco = new Endereco();

        denunciante.setEndereco(endereco);
        ficha.setDenunciante(denunciante);
        ficha.setData_ouvidoria(dataAtual);
        ficha.setHora_ouvidoria(horaAtual);

        model.addAttribute("ficha", ficha);

        return "ficha-criarFicha";
    }

    @GetMapping("/perfil/{id}")
    public String fichaPerfil(@PathVariable Long id, Model model) {
        Ficha ficha = fichaService.encontrarPorId(id);

        model.addAttribute("ficha", ficha);

        return "ficha-perfil";
    }

    @GetMapping("/edit/{id}")
    public String fichaEditar(@PathVariable Long id, Model model) {
        Ficha ficha = fichaService.encontrarPorId(id);

        model.addAttribute("ficha", ficha);

        return "ficha-editar";
    }

    // TODO TESTE TESTAR O CAMPO DE BUSCA
    @GetMapping("/buscar")
    public String listarTodasFichas(Model model, @RequestParam(name = "query", required = false) String query) {
        List<Ficha> fichas = new ArrayList<>();

        if (query != null && !query.isEmpty()) {
            long queryLong = Long.parseLong(query);
            fichas.add(fichaService.encontrarPorId(queryLong));
        } else {
            fichas = fichaService.getAllFichas();
        }

        model.addAttribute("fichas", fichas);

        return "buscar";
    }

    @PostMapping("/criar")
    public String criarFicha(@Valid @ModelAttribute Ficha ficha, Errors errors) {
        fichaService.createFicha(ficha);
        return "redirect:/ouvidoria";
    }

    @PostMapping("/edit")
    public String fichaEditar(@Valid @ModelAttribute Ficha ficha, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("ficha", ficha);
            return "ficha-editar";
        }
        
        fichaService.createFicha(ficha);

        return "redirect:/ficha/perfil/" + ficha.getId_ficha();
    }

}
