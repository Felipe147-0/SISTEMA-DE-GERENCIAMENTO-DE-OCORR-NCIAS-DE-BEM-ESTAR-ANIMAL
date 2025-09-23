package bem_estar_animal.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bem_estar_animal.tcc.model.LoginSistema;

@Repository
public interface LoginRepository extends JpaRepository<LoginSistema, Long>{

}
