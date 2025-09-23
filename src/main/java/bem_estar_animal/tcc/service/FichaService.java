package bem_estar_animal.tcc.service;

import java.util.List;
import java.util.Optional;
import bem_estar_animal.tcc.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import bem_estar_animal.tcc.model.Denunciante;
import bem_estar_animal.tcc.model.Ficha;
import bem_estar_animal.tcc.model.Funcionario;
import bem_estar_animal.tcc.record.FichaRecord;
import bem_estar_animal.tcc.repository.DenuncianteRepository;
import bem_estar_animal.tcc.repository.FichaRepository;

@Service
public class FichaService {

    private FuncionarioRepository funcionarioRepository;
    private FichaRepository fichaRepository;
    private DenuncianteRepository denuncianteRepository;

    public FichaService(FichaRepository fichaRepository, DenuncianteRepository denuncianteRepository, FuncionarioRepository funcionarioRepository) {
        this.fichaRepository = fichaRepository;
        this.denuncianteRepository = denuncianteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public void createFicha(FichaRecord fichaRecord) {
        Optional<Denunciante> denuncianteFound = denuncianteRepository.findById(fichaRecord.denunciante_id());
        Denunciante denunciante = denuncianteFound.get();

         Optional<Funcionario> funcionarioFound = funcionarioRepository.findById(fichaRecord.funcionario_id());
         Funcionario funcionario = funcionarioFound.get();

        Ficha ficha = new Ficha(
            null,
            fichaRecord.processo(),
            fichaRecord.recebido_por(),
            fichaRecord.data(),
            fichaRecord.hora(),
            denunciante,
            fichaRecord.assunto(),
            fichaRecord.desfecho_da_notificacao(),
            fichaRecord.data_tramite(),
            fichaRecord.hora_tramite(),
            funcionario,
            fichaRecord.historico(),
            fichaRecord.animal()
        );
        fichaRepository.save(ficha);
    }

}
