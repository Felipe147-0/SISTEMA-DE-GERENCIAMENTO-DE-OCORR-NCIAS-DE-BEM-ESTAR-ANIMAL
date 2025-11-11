package bem_estar_animal.tcc.MVC.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString(exclude = "denunciante")
public class ListaExclusao {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lista_exclusao;

    private String observacao;

    @OneToOne
    @JoinColumn(name = "id_denunciante", referencedColumnName = "id_denunciante")
    private Denunciante denunciante;
}
