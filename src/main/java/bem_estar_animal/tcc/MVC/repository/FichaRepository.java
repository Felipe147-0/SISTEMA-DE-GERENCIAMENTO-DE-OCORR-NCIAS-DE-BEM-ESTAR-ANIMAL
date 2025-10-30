package bem_estar_animal.tcc.MVC.repository;


import bem_estar_animal.tcc.MVC.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
    List<Ficha> findByDenunciante_Nome(String nome);

    List<Ficha> findByProcessoOuvidoria(String processo);
}
