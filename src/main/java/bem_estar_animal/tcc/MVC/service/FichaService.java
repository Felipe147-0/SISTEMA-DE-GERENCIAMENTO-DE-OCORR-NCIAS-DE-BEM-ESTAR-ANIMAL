package bem_estar_animal.tcc.MVC.service;

import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.model.Funcionario;
import bem_estar_animal.tcc.MVC.repository.FichaRepository;
import bem_estar_animal.tcc.MVC.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.MonthDay;
import java.time.Year;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FichaService {

    private FichaRepository fichaRepository;
    private FuncionarioRepository funcionarioRepository;

    public FichaService(FichaRepository fichaRepository, FuncionarioRepository funcionarioRepository) {
        this.fichaRepository = fichaRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public Optional<Ficha> encontrarPorId(Long id) {
        return fichaRepository.findById(id);
    }

    public List<Ficha> busca(String query) {
        if (query.matches("\\d+")) {
            List<Ficha> encontradoPorProcesso = fichaRepository.findByProcessoOuvidoria(query);

            if (!encontradoPorProcesso.isEmpty()) {
                return encontradoPorProcesso;
            }

        } else if (query.matches("\\w+")) {
            List<Ficha> encontradoPorDenunciante = fichaRepository.findByDenunciante_NomeLike("%" + query + "%");

            if (!encontradoPorDenunciante.isEmpty()) {
                return encontradoPorDenunciante;
            }
        }

        return Collections.emptyList();
    }

    @Transactional
    public void createFicha(Ficha fichaRecebida) {
        if (fichaRecebida.getProcessoOuvidoria() == null || fichaRecebida.getProcessoOuvidoria().isEmpty()) {
            String numeroProcesso = gerarNumeroProcesso();
            fichaRecebida.setProcessoOuvidoria(numeroProcesso);
        }
        Funcionario funcionario = funcionarioRepository.findByNome(fichaRecebida.getFuncionario().getNome());
        fichaRecebida.setFuncionario(funcionario);
        fichaRepository.save(fichaRecebida);
    }

    private String gerarNumeroProcesso() {
        Long numero = fichaRepository.contarFichas() + 1;
        int ano = Year.now().getValue();
        int mes = MonthDay.now().getMonthValue();
        int dia = MonthDay.now().getDayOfMonth();
        return String.format("PROC-OUV-%d%d%d-%04d", ano, mes, dia, numero);

        /*USADO NO PROCESSO OUVIDORIA*/
        /*CHAMA OS METODOS DO REPOSITORY*/
        /*fichaRepository.gerarSequencia();*/
        /*Long numero = fichaRepository.buscarUltimoNumero();*/
    }

}
