package bem_estar_animal.tcc.MVC.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Setor {

    //TODO SETOR dividir o setor por categoria

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_setor;

    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionariosList = new ArrayList<>();
}
