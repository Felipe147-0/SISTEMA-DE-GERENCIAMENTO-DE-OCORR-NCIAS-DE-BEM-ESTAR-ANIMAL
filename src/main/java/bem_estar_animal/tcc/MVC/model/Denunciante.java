package bem_estar_animal.tcc.MVC.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"ficha", "endereco", "listaExclusao"})
@Getter
@Setter
@Entity
public class Denunciante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_denunciante;

    private String nome;

    private String cpf;

    private String telefone;

    @Column(name = "em_lista")
    private boolean emLista;

    @OneToOne(mappedBy = "denunciante")
    private Ficha ficha;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @OneToOne(mappedBy = "denunciante")
    private ListaExclusao listaExclusao;
}
