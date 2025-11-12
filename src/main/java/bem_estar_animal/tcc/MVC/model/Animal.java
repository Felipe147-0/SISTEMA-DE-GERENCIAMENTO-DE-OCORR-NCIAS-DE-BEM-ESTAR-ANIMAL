package bem_estar_animal.tcc.MVC.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @Column(name = "id_animal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;

    private String registro;

    private boolean possuiChip;
    
    private String numeroChip;

    @ManyToOne
    @JoinColumn(name = "ficha_id")
    private Ficha ficha;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoAnimalEnum tipo;

    // private String raca;

    // private String cor;

    // // colocar um enum para sexo
    // private Enum sexo;

    // // colocar um enum para status ( resgatado, adotado, em ocorrencia)
    // private Enum status;
}
