package bem_estar_animal.tcc.MVC.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_funcionario;

    private String nome;

    private String registro;

    private String funcao;

    @OneToMany(mappedBy = "funcionario")
    private List<Ficha> fichalList = new ArrayList<>();

    // TODO SETOR colocar o setor
    @ManyToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;
}
