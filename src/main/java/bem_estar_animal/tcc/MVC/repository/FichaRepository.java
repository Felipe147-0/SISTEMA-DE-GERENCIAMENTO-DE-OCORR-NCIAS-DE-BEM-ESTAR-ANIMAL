package bem_estar_animal.tcc.MVC.repository;


import bem_estar_animal.tcc.MVC.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
    List<Ficha> findByDenunciante_Nome(String nome);

    List<Ficha> findByProcessoOuvidoria(String processo);

    @Modifying //usado para modificar o banco ( quando nao é um select)
    @Query(value = "INSERT INTO sequencia_ouvidoria VALUES (NULL)", nativeQuery = true)
    void gerarSequencia();

    @Query(value = "SELECT MAX(id) FROM sequencia_ouvidoria", nativeQuery = true)
    Long buscarUltimoNumero();
}
