package bem_estar_animal.tcc.MVC.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Denunciante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_denunciante;

    private String nome;

    private String telefone;

    @OneToOne(mappedBy = "denunciante")
    @JsonBackReference
    private Ficha ficha;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco")
    @JsonBackReference
    private Endereco endereco;
}
