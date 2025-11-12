package bem_estar_animal.tcc.MVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bem_estar_animal.tcc.MVC.model.Denunciante;

@Repository
public interface DenuncianteRepository extends JpaRepository<Denunciante, Long> {

    List<Denunciante> findByCpf(String query);

    @Query("SELECT d FROM Denunciante d WHERE LOWER(d.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Denunciante> findByNomeLike(@Param("nome") String nome);

    List<Denunciante> findByEmListaTrue();
}
