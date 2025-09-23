package bem_estar_animal.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bem_estar_animal.tcc.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
