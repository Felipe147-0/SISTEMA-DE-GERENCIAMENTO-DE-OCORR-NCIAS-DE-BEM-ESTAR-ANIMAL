package bem_estar_animal.tcc.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Denunciante;
import bem_estar_animal.tcc.model.Ficha;
import bem_estar_animal.tcc.model.Funcionario;
import bem_estar_animal.tcc.record.FichaRecord;
import bem_estar_animal.tcc.repository.DenuncianteRepository;
import bem_estar_animal.tcc.repository.FichaRepository;
import bem_estar_animal.tcc.repository.FuncionarioRepository;

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

    public Ficha createFicha(FichaRecord fichaRecord) {
        ZonedDateTime localDateTime = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        Instant localDateTimeInstant = localDateTime.toInstant();

        Ficha ficha = new Ficha(
                null,
                fichaRecord.processo(),
                fichaRecord.recebido_por(),
                localDateTimeInstant,
                localDateTimeInstant,
                null,
                fichaRecord.assunto(),
                fichaRecord.desfecho_da_notificacao(),
                null,
                null,
                null,
                fichaRecord.historico(),
                fichaRecord.animal());

        if (fichaRecord.dununcianteId() != null && fichaRecord.dununcianteId() != 0) {
            Denunciante denuncianteFound = denuncianteRepository.findById(fichaRecord.dununcianteId()).get();
            ficha.setDenunciante(denuncianteFound); // TODO OBRIGATORIO COLOCAR O DENUNCIANTE
        }

        if (fichaRecord.funcionarioId() != null && fichaRecord.funcionarioId() != 0) {
            Funcionario funcionarioFound = funcionarioRepository.findById(fichaRecord.funcionarioId()).get();
            ficha.setFuncionario(funcionarioFound); // TODO OBRIGATORIO COLOCAR O FUNCIONARIO
        }

        fichaRepository.save(ficha);

        return ficha;
    }

    public Ficha updateFicha(Long id, FichaRecord fichaRecord) {
        Ficha ficha = fichaRepository.findById(id).get();

        if (fichaRecord.processo() != null && !fichaRecord.processo().isBlank()) {
            ficha.setProcesso(fichaRecord.processo());
        }

        if (fichaRecord.recebido_por() != null && !fichaRecord.recebido_por().isBlank()) {
            ficha.setRecebido_por(fichaRecord.recebido_por());
        }

        if (fichaRecord.assunto() != null && !fichaRecord.assunto().isBlank()) {
            ficha.setAssunto(fichaRecord.assunto());
        }

        if (fichaRecord.desfecho_da_notificacao() != null && !fichaRecord.desfecho_da_notificacao().isBlank()) {
            ficha.setDesfecho_da_notificacao(fichaRecord.desfecho_da_notificacao());
        }

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
