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
@Setter
@Getter
@Entity
public class ListaExclusao {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lista_exclusao;

    private String observacao;

    @OneToMany(mappedBy = "listaExclusao")
    private List<Denunciante> denunciantes = new ArrayList<>();
}
