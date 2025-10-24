package bem_estar_animal.tcc.MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bem_estar_animal.tcc.MVC.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long>{

}
