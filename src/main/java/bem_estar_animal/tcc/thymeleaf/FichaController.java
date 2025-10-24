package bem_estar_animal.tcc.thymeleaf;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.model.Endereco;
import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.service.FichaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ficha")
public class FichaController {

     private FichaService fichaService;

    public FichaController (FichaService fichaService){
        this.fichaService = fichaService;
    }

    @GetMapping("/criar")
    public String criarFicha(Model model) {
        //cria o Instant atual (UTC) e converte para o fuso de São Paulo
        Instant localDateTimeInstant = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant();
        ZonedDateTime dataHoraLocal = localDateTimeInstant.atZone(ZoneId.of("America/Sao_Paulo"));
        
        //formatar a data e a hora
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
        model.addAttribute("data", dataAtual);
        model.addAttribute("hora", horaAtual);
        
        return "ficha-criarFicha";
    }

    @PostMapping("/criar")
    public String criarFicha(@Valid @ModelAttribute Ficha ficha, Errors errors) {
        fichaService.createFicha(ficha);
        return "redirect:/ouvidoria";
    }
}
