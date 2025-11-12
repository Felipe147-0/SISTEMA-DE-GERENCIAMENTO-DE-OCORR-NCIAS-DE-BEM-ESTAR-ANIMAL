package bem_estar_animal.tcc.MVC.repository;


import bem_estar_animal.tcc.MVC.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
    List<Ficha> findByDenunciante_NomeLike(String nome);

    List<Ficha> findByProcessoOuvidoria(String processo);

    @Query(value = "select count(id_ficha) from ficha", nativeQuery = true)
    Long contarFichas();

    /*USADO NO PROCESSO OUVIDORIA*/
    /* USADO PARA GERAR O ID EM UMA TABELA SEPARADA E GERAR UM NUMERO BASEADO NO MAIOR ID*/
    /*@Modifying //usado para modificar o banco ( quando nao é um select)
    @Query(value = "INSERT INTO sequencia_ouvidoria VALUES (NULL)", nativeQuery = true)
    void gerarSequencia();*/

    /*@Query(value = "SELECT MAX(id) FROM sequencia_ouvidoria", nativeQuery = true)
    Long buscarUltimoNumero();*/
}
