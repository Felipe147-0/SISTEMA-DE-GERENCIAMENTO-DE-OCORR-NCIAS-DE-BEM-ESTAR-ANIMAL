package bem_estar_animal.tcc.MVC.service;

import bem_estar_animal.tcc.MVC.model.Ficha;
import bem_estar_animal.tcc.MVC.model.Funcionario;
import bem_estar_animal.tcc.MVC.repository.FichaRepository;
import bem_estar_animal.tcc.MVC.repository.FuncionarioRepository;
import bem_estar_animal.tcc.restfull.record.FichaRecord;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
            List<Ficha> encontradoPorDenunciante = fichaRepository.findByDenunciante_Nome(query);

            if (!encontradoPorDenunciante.isEmpty()) {
                return encontradoPorDenunciante;
            }
        }

        return Collections.emptyList();
    }

    public void createFicha(Ficha fichaRecebida) {
        Funcionario funcionario = funcionarioRepository.findByNome(fichaRecebida.getFuncionario().getNome());
        fichaRecebida.setFuncionario(funcionario);
        fichaRepository.save(fichaRecebida);
    }

    public Ficha updateFicha(Long id, FichaRecord fichaRecord) {
        Ficha ficha = fichaRepository.findById(id).get();

        // if (fichaRecord.processo() != null && !fichaRecord.processo().isBlank()) {
        // ficha.setProcesso(fichaRecord.processo());
        // }

        // if (fichaRecord.recebido_por() != null &&
        // !fichaRecord.recebido_por().isBlank()) {
        // ficha.setRecebido_por(fichaRecord.recebido_por());
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
