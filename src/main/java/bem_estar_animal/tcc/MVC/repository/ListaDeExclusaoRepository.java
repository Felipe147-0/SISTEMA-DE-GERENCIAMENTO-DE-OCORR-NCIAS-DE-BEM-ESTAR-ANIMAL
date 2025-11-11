package bem_estar_animal.tcc.MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bem_estar_animal.tcc.MVC.model.ListaExclusao;

@Repository
public interface ListaDeExclusaoRepository extends JpaRepository<ListaExclusao, Long> {

    @Query(value = "SELECT * FROM lista_exclusao WHERE id_denunciante = :denuncianteId", nativeQuery = true)
    ListaExclusao findByDenuncianteId(@Param("denuncianteId") Long denuncianteId);

}
