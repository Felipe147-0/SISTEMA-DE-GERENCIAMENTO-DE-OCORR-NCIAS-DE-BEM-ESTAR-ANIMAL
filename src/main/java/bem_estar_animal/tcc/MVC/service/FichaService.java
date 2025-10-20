package bem_estar_animal.tcc.MVC.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.MVC.model.Denunciante;
import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.model.Funcionario;
import bem_estar_animal.tcc.MVC.repository.DenuncianteRepository;
import bem_estar_animal.tcc.MVC.repository.FichaRepository;
import bem_estar_animal.tcc.MVC.repository.FuncionarioRepository;
import bem_estar_animal.tcc.restfull.record.FichaRecord;

@Service
public class FichaService {

    private FichaRepository fichaRepository;
    private DenuncianteRepository denuncianteRepository;
    private FuncionarioRepository funcionarioRepository;

    public FichaService(FichaRepository fichaRepository, DenuncianteRepository denuncianteRepository,
            FuncionarioRepository funcionarioRepository) {
        this.fichaRepository = fichaRepository;
        this.denuncianteRepository = denuncianteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public Ficha createFicha(Ficha fichaRecebida) {
        ZonedDateTime localDateTime = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        Instant localDateTimeInstant = localDateTime.toInstant();

        Ficha ficha = new Ficha(
                // null,
                // fichaRecebida.getProcesso(),
                // fichaRecebida.getRecebido_por(),
                // localDateTimeInstant,
                // localDateTimeInstant,
                // null,
                // fichaRecebida.getAssunto(),
                // fichaRecebida.getDesfecho_da_notificacao(),
                // null,
                // null,
                // null,
                // fichaRecebida.getHistorico(),
                // fichaRecebida.getAnimal()
                );

        if (fichaRecebida.getDenunciante() != null) {
            Denunciante denuncianteFound = denuncianteRepository
                    .findById(fichaRecebida.getDenunciante().getId_denunciante()).get();
            ficha.setDenunciante(denuncianteFound); // TODO OBRIGATORIO COLOCAR O DENUNCIANTE
        }

        if (fichaRecebida.getFuncionario() != null) {
            Funcionario funcionarioFound = funcionarioRepository
                    .findById(fichaRecebida.getFuncionario().getId_funcionario()).get();
            ficha.setFuncionario(funcionarioFound); // TODO OBRIGATORIO COLOCAR O FUNCIONARIO
        }

        fichaRepository.save(ficha);

        return ficha;
    }

    public Ficha updateFicha(Long id, FichaRecord fichaRecord) {
        Ficha ficha = fichaRepository.findById(id).get();

        // if (fichaRecord.processo() != null && !fichaRecord.processo().isBlank()) {
        //     ficha.setProcesso(fichaRecord.processo());
        // }

        // if (fichaRecord.recebido_por() != null && !fichaRecord.recebido_por().isBlank()) {
        //     ficha.setRecebido_por(fichaRecord.recebido_por());
        // }

        if (fichaRecord.assunto() != null && !fichaRecord.assunto().isBlank()) {
            ficha.setAssunto(fichaRecord.assunto());
        }

        if (fichaRecord.desfecho_da_notificacao() != null && !fichaRecord.desfecho_da_notificacao().isBlank()) {
            ficha.setDesfecho_da_notificacao(fichaRecord.desfecho_da_notificacao());
        }

        // TODO colocar data tramite e hora tramite

        if (fichaRecord.historico() != null && !fichaRecord.historico().isBlank()) {
            ficha.setHistorico(fichaRecord.historico());
        }

        if (fichaRecord.animal() != null && !fichaRecord.animal().isBlank()) {
            ficha.setAnimal(fichaRecord.animal());
        }

        fichaRepository.save(ficha);

        return ficha;
    }

    public void deleteFicha(Long id) {
        fichaRepository.findById(id).ifPresent(ficha -> fichaRepository.delete(ficha));
    }

}
